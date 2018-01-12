package main.snnu.controller;

import main.snnu.anno.MyMapping;
import main.snnu.anno.Role;
import main.snnu.entity.Course;
import main.snnu.entity.Result;
import main.snnu.entity.User;
import main.snnu.service.Impl.UserServiceImpl;
import main.snnu.service.UserService;
import main.snnu.utils.JsonReader;
import main.snnu.utils.Page;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by WT on 2017/12/5.
 */
@MyMapping(mapping = "/system/user")
public class UserController {
    private UserService userService = new UserServiceImpl();
    @Role(4)
    @MyMapping(mapping = "/findPage")
    public void findUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String startIndex = request.getParameter("startIndex");
        String pageSize = request.getParameter("pageSize");
        String totalCount = request.getParameter("totalCount");
        Page<User> userPage = new Page<User>(Integer.parseInt(startIndex),Integer.parseInt(pageSize),Integer.parseInt(totalCount));
        userPage.settList((List<User>) (userService.findPage(userPage.getStartIndex(),userPage.getCount()).getData()));
        request.setAttribute("data",userPage.gettList());
        System.out.println(userPage);
        request.setAttribute("currentPage",userPage.getCurrentPage());
        request.setAttribute("totalPage",userPage.getTotalPage());
        request.setAttribute("count",userPage.getCount());
        request.setAttribute("totalCount",userPage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showUser.jsp");
        dispatcher.forward(request,response);
    }
    @Role(4)
    @MyMapping(mapping = "/insertUser")
    public void insertUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        JSONObject json = JsonReader.getJson(request);
        User user = (User) JSONObject.toBean(json,User.class);
        System.err.println(user);
        Result result = userService.insertUser(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(4)
    @MyMapping(mapping = "/deleteUser")
    public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String userId = request.getParameter("userId");
        User user = new User();
        user.setUserId(userId);
        System.err.println(user);
        Result result = userService.deleteUser(user);
        System.err.println(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(4)
    @MyMapping(mapping = "/updateUser")
    public void updateUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        JSONObject json = JsonReader.getJson(request);
        User user = (User)JSONObject.toBean(json,User.class);
        Result result = userService.updateUser(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(4)
    @MyMapping(mapping = "/queryUser")
    public void queryUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String userName = request.getParameter("userName");
        Result result = userService.queryUserByName(userName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}

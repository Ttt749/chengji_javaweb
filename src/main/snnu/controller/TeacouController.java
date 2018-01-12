package main.snnu.controller;

import main.snnu.anno.MyMapping;
import main.snnu.anno.Role;
import main.snnu.entity.Result;
import main.snnu.entity.StuCou;
import main.snnu.entity.TeaCou;
import main.snnu.service.Impl.TeaCouServiceImpl;
import main.snnu.service.Impl.TeacherServiceImpl;
import main.snnu.service.TeaCouService;
import main.snnu.service.TeacherService;
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
@MyMapping(mapping = "/system/teacou")
public class TeacouController {
    private TeaCouService teaCouService = new TeaCouServiceImpl();
    @Role(1)
    @MyMapping(mapping = "/findPage")
    public void findTeacouPage(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String startIndex = request.getParameter("startIndex");
        String pageSize = request.getParameter("pageSize");
        String totalCount = request.getParameter("totalCount");
        Page<TeaCou> teaCouPage = new Page<TeaCou>(Integer.parseInt(startIndex),Integer.parseInt(pageSize),Integer.parseInt(totalCount));
        teaCouPage.settList((List<TeaCou>) (teaCouService.findPage(teaCouPage.getStartIndex(),teaCouPage.getCount()).getData()));
        request.setAttribute("data",teaCouPage.gettList());
        request.setAttribute("currentPage",teaCouPage.getCurrentPage());
        request.setAttribute("totalPage",teaCouPage.getTotalPage());
        request.setAttribute("count",teaCouPage.getCount());
        request.setAttribute("totalCount",teaCouPage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showTeacou.jsp");
        dispatcher.forward(request,response);
    }
    @Role(3)
    @MyMapping(mapping = "/insertTeacou")
    public void insertTeacou(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/json;charset=utf-8");
        TeaCou teaCou = new TeaCou();
        teaCou.setcId(request.getParameter("sId"));
        teaCou.settId(request.getParameter("tId"));
        Result result = teaCouService.insertTeaCOu(teaCou);
        System.err.println(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(3)
    @MyMapping(mapping = "/deleteTeacou")
    public void deleteTeacou(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String tId = request.getParameter("tId");
        String cId = request.getParameter("cId");
        TeaCou teaCou = new TeaCou();
        teaCou.settId(tId);
        teaCou.setcId(cId);
        System.err.println(teaCou);
        Result result = teaCouService.deleteTeaCOu(teaCou);
        System.err.println(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(3)
    @MyMapping(mapping = "/updateTeacou")
    public void updateTeacou(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        JSONObject json = JsonReader.getJson(request);
        TeaCou teaCou = (TeaCou)JSONObject.toBean(json,TeaCou.class);
        Result result = teaCouService.updateTeaCOu(teaCou);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(1)
    @MyMapping(mapping = "/queryTeacou")//tid 查询
    public void queryTeacou(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String tId = request.getParameter("tId");
        Result result = teaCouService.queryTeaCOuByTid(tId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}

package main.snnu.controller;

import main.snnu.anno.MyMapping;
import main.snnu.anno.Role;
import main.snnu.entity.Result;
import main.snnu.entity.Teacher;
import main.snnu.service.Impl.TeacherServiceImpl;
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
@MyMapping(mapping = "/system/teacher")
public class TeacherController {
    private TeacherService teacherService = new TeacherServiceImpl();
    @Role(1)
    @MyMapping(mapping = "/findPage")
    public void findTeacherPage(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String startIndex = request.getParameter("startIndex");
        String pageSize = request.getParameter("pageSize");
        String totalCount = request.getParameter("totalCount");
        Page<Teacher> teacherPage = new Page<Teacher>(Integer.parseInt(startIndex),Integer.parseInt(pageSize),Integer.parseInt(totalCount));
        teacherPage.settList((List<Teacher>) (teacherService.findPage(teacherPage.getStartIndex(),teacherPage.getCount()).getData()));
        request.setAttribute("data",teacherPage.gettList());
        request.setAttribute("currentPage",teacherPage.getCurrentPage());
        request.setAttribute("totalPage",teacherPage.getTotalPage());
        request.setAttribute("count",teacherPage.getCount());
        request.setAttribute("totalCount",teacherPage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showTeacher.jsp");
        dispatcher.forward(request,response);
    }
    @Role(3)
    @MyMapping(mapping = "/insertTeacher")
    public void insertTeacher(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        JSONObject json = JsonReader.getJson(request);
        Teacher teacher = (Teacher) JSONObject.toBean(json,Teacher.class);
        System.err.println(teacher);
        Result result = teacherService.insertTeacher(teacher);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(3)
    @MyMapping(mapping = "/deleteTeacher")
    public void deleteTeacher(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String tId = request.getParameter("tId");
        Teacher teacher = new Teacher();
        teacher.settId(tId);
        System.err.println(teacher);
        Result result = teacherService.deleteTeacher(teacher);
        System.err.println(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(2)
    @MyMapping(mapping = "/updateTeacher")
    public void updateTeacher(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        JSONObject json = JsonReader.getJson(request);
        Teacher teacher = (Teacher) JSONObject.toBean(json,Teacher.class);
        Result result = teacherService.updateTeacher(teacher);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(1)
    @MyMapping(mapping = "/queryTeacher")
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String tId = request.getParameter("tId");
        Result result = teacherService.queryTeacherById(tId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}

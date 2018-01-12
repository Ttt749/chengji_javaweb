package main.snnu.controller;

import main.snnu.anno.MyMapping;
import main.snnu.anno.Role;
import main.snnu.entity.Result;
import main.snnu.entity.Student;
import main.snnu.service.Impl.StudentServiceImpl;
import main.snnu.service.StudentService;
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
@MyMapping(mapping = "/system/student")
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();
    @Role(1)
    @MyMapping(mapping = "/findPage")
    public void findStudentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String startIndex = request.getParameter("startIndex");
        String pageSize = request.getParameter("pageSize");
        String totalCount = request.getParameter("totalCount");
        Page<Student> studentPage = new Page<Student>(Integer.parseInt(startIndex),Integer.parseInt(pageSize),Integer.parseInt(totalCount));
        studentPage.settList((List<Student>) (studentService.findPage(studentPage.getStartIndex(),studentPage.getCount()).getData()));
        request.setAttribute("data",studentPage.gettList());
        request.setAttribute("currentPage",studentPage.getCurrentPage());
        request.setAttribute("totalPage",studentPage.getTotalPage());
        request.setAttribute("count",studentPage.getCount());
        request.setAttribute("totalCount",studentPage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showStudent.jsp");
        dispatcher.forward(request,response);
    }
    @Role(3)
    @MyMapping(mapping = "/insertStudent")
    public void insertStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        JSONObject json = JsonReader.getJson(request);
        Student student = (Student) JSONObject.toBean(json,Student.class);
        System.err.println(student);
        Result result = studentService.insertStudent(student);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(3)
    @MyMapping(mapping = "/deleteStudent")
    public void deleteStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String sId = request.getParameter("sId");
        Student student = new Student();
        student.setsID(sId);
        System.err.println(student);
        Result result = studentService.deleteStudent(student);
        System.err.println(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(3)
    @MyMapping(mapping = "/updateStudent")
    public void updateStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        JSONObject json = JsonReader.getJson(request);
        Student student = (Student) JSONObject.toBean(json,Student.class);
        Result result = studentService.updateStudent(student);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(1)
    @MyMapping(mapping = "/queryStudent")
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String sId = request.getParameter("sId");
        Result result = studentService.queryStudentById(sId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}

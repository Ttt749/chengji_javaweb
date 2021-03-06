package main.snnu.servlet.student;

import main.snnu.entity.Result;
import main.snnu.entity.Student;
import main.snnu.service.Impl.StudentServiceImpl;
import main.snnu.service.StudentService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WT on 2017/12/4.
 */
public class DeleteStudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
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
}

package main.snnu.servlet.course;

import main.snnu.entity.Course;
import main.snnu.entity.Result;
import main.snnu.service.CourseService;
import main.snnu.service.Impl.CourseServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WT on 2017/12/2.
 */
public class deleteCourseServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String cId = request.getParameter("cId");
        Course course = new Course();
        course.setcId(cId);
        System.err.println(course);
        Result result = courseService.deleteCourse(course);
        System.err.println(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}

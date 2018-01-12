package main.snnu.servlet.system;

import main.snnu.entity.Course;
import main.snnu.entity.Result;
import main.snnu.service.CourseService;
import main.snnu.service.Impl.CourseServiceImpl;
import main.snnu.utils.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by WT on 2017/12/1.
 */
public class showCourseServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Result result = courseService.queryAllCourse();
        int i = ((List<Course>)result.getData()).size();
        Page<Course> coursePage = new Page<Course>(1,5,i);
        coursePage.settList((List<Course>) (courseService.findPage(coursePage.getStartIndex(),coursePage.getCount()).getData()));
        request.setAttribute("data",coursePage.gettList());
        request.setAttribute("currentPage",coursePage.getCurrentPage());
        request.setAttribute("totalPage",coursePage.getTotalPage());
        request.setAttribute("count",coursePage.getCount());
        request.setAttribute("totalCount",coursePage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showCourse.jsp");
        dispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}

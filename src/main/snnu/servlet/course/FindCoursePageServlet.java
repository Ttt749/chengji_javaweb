package main.snnu.servlet.course;

import main.snnu.entity.Course;
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
 * Created by WT on 2017/12/5.
 */
public class FindCoursePageServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String startIndex = request.getParameter("startIndex");
        String pageSize = request.getParameter("pageSize");
        String totalCount = request.getParameter("totalCount");
        Page<Course> studentPage = new Page<Course>(Integer.parseInt(startIndex),Integer.parseInt(pageSize),Integer.parseInt(totalCount));
        studentPage.settList((List<Course>) (courseService.findPage(studentPage.getStartIndex(),studentPage.getCount()).getData()));
        request.setAttribute("data",studentPage.gettList());
        request.setAttribute("currentPage",studentPage.getCurrentPage());
        request.setAttribute("totalPage",studentPage.getTotalPage());
        request.setAttribute("count",studentPage.getCount());
        request.setAttribute("totalCount",studentPage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showStudent.jsp");
        dispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}

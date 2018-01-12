package main.snnu.servlet.teacher;

import main.snnu.entity.Teacher;
import main.snnu.service.Impl.TeacherServiceImpl;
import main.snnu.service.TeacherService;
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
public class FindTeacherPageServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
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
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}

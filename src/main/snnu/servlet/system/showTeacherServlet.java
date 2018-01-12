package main.snnu.servlet.system;

import main.snnu.entity.Result;
import main.snnu.entity.Teacher;
import main.snnu.service.Impl.StudentServiceImpl;
import main.snnu.service.Impl.TeacherServiceImpl;
import main.snnu.service.StudentService;
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
 * Created by WT on 2017/12/1.
 */
public class showTeacherServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Result result = teacherService.queryAllTeacher();
        int i = ((List<Teacher>)result.getData()).size();
        Page<Teacher> coursePage = new Page<Teacher>(1,5,i);
        coursePage.settList((List<Teacher>) (teacherService.findPage(coursePage.getStartIndex(),coursePage.getCount()).getData()));
        request.setAttribute("data",coursePage.gettList());
        request.setAttribute("currentPage",coursePage.getCurrentPage());
        request.setAttribute("totalPage",coursePage.getTotalPage());
        request.setAttribute("count",coursePage.getCount());
        request.setAttribute("totalCount",coursePage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showTeacher.jsp");
        dispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}

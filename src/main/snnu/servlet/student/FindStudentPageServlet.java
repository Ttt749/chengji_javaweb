package main.snnu.servlet.student;

import main.snnu.entity.Student;
import main.snnu.service.Impl.StudentServiceImpl;
import main.snnu.service.StudentService;
import main.snnu.utils.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by WT on 2017/12/4.
 */
public class FindStudentPageServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
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
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}

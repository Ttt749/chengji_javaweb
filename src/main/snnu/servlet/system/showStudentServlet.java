package main.snnu.servlet.system;

import main.snnu.entity.Result;
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
 * Created by WT on 2017/12/1.
 */
public class showStudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Result result = studentService.queryAllStudent();
        int i = ((List<Student>)result.getData()).size();
        Page<Student> studentPage = new Page<Student>(1,5,i);
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

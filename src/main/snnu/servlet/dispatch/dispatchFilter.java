package main.snnu.servlet.dispatch;

import main.snnu.servlet.course.*;
import main.snnu.servlet.session.loginPageServlet;
import main.snnu.servlet.session.loginServlet;
import main.snnu.servlet.session.logoutServlet;
import main.snnu.servlet.stucou.insertStuCouServlet;
import main.snnu.servlet.student.*;
import main.snnu.servlet.system.indexServlet;
import main.snnu.servlet.system.showCourseServlet;
import main.snnu.servlet.system.showStudentServlet;
import main.snnu.servlet.system.showTeacherServlet;
import main.snnu.servlet.teacher.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WT on 2017/12/3.
 */
public class dispatchFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String currentURL = request.getRequestURI();
        System.err.println("currentURL:"+currentURL);
        if(currentURL.contains(".css") || currentURL.contains(".js") || currentURL.contains(".png")|| currentURL.contains(".jpg")){
            //如果发现是css或者js文件，直接放行
            filterChain.doFilter(request, response);
            return;
        }
        switch (currentURL){
            case "/session/loginPage":
                loginPageServlet loginPageServlet = new loginPageServlet();
                loginPageServlet.doGet(request,response);
                return;
            case "/session/login":
                loginServlet loginServlet = new loginServlet();
                loginServlet.doGet(request,response);
                return;
            case "/session/logout":
                logoutServlet logoutServlet = new logoutServlet();
                logoutServlet.doGet(request,response);
                return;
            case  "/system/index":
                indexServlet indexServlet = new indexServlet();
                indexServlet.doGet(request,response);
                return;
            case "/system/showStudent":
                showStudentServlet showStudentServlet = new showStudentServlet();
                showStudentServlet.doGet(request,response);
                return;
            case "/system/showCourse":
                showCourseServlet showCourseServlet = new showCourseServlet();
                showCourseServlet.doGet(request,response);
                return;
            case "/system/showTeacher":
                showTeacherServlet showTeacherServlet = new showTeacherServlet();
                showTeacherServlet.doGet(request,response);
                return;
            case "/system/course/queryCourse":
                queryCourseServlet queryCourseServlet = new queryCourseServlet();
                queryCourseServlet.doGet(request,response);
                return;
            case "/system/course/insertCourse":
                insertCourseServlet insertCourseServlet = new insertCourseServlet();
                insertCourseServlet.doPost(request,response);
                return;
            case "/system/course/deleteCourse":
                deleteCourseServlet deleteCourseServlet = new deleteCourseServlet();
                deleteCourseServlet.doPost(request,response);
                return;
            case "/system/course/updateCourse":
                updateCourseServlet updateCourseServlet = new updateCourseServlet();
                updateCourseServlet.doGet(request,response);
                return;
            case "/system/stucou/insertSC":
                insertStuCouServlet insertStuCouServlet = new insertStuCouServlet();
                insertStuCouServlet.doPost(request,response);
                return;
            case "/system/student/insertStudent":
                InsertStudentServlet insertStudentServlet = new InsertStudentServlet();
                insertStudentServlet.doPost(request,response);
                return;
            case "/system/student/updateStudent":
                UpdateStudentServlet updateStudentServlet = new UpdateStudentServlet();
                updateStudentServlet.doPost(request,response);
                return;
            case "/system/student/deleteStudent":
                DeleteStudentServlet deleteStudentServlet = new DeleteStudentServlet();
                deleteStudentServlet.doPost(request,response);
                return;
            case "/system/student/queryStudent":
                QueryStudentServlet queryStudentServlet = new QueryStudentServlet();
                queryStudentServlet.doGet(request,response);
                return;
            case "/system/student/findPage":
                FindStudentPageServlet findStudentPageServlet = new FindStudentPageServlet();
                findStudentPageServlet.doGet(request,response);
                return;
            case "/system/course/findPage":
                FindCoursePageServlet findCoursePageServlet = new FindCoursePageServlet();
                findCoursePageServlet.doGet(request,response);
                return;
            case "/system/teacher/findPage":
                FindTeacherPageServlet findTeacherPageServlet = new FindTeacherPageServlet();
                findTeacherPageServlet.doGet(request,response);
                return;
            case "/system/teacher/insertTeacher":
                InsertTeacherServlet insertTeacherServlet = new InsertTeacherServlet();
                insertTeacherServlet.doGet(request,response);
                return;
            case "/system/teacher/updateTeacher":
                UpdateTeacherServlet updateTeacherServlet = new UpdateTeacherServlet();
                updateTeacherServlet.doGet(request,response);
                return;
            case "/system/teacher/deleteTeacher":
                DeleteTeacherServlet deleteTeacherServlet = new DeleteTeacherServlet();
                deleteTeacherServlet.doGet(request,response);
                return;
            case "/system/teacher/queryTeacher":
                QueryTeacherServlet queryTeacherServlet = new QueryTeacherServlet();
                queryTeacherServlet.doGet(request,response);
                return;
            default:
                break;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

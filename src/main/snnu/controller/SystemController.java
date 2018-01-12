package main.snnu.controller;

import main.snnu.anno.MyMapping;
import main.snnu.anno.Role;
import main.snnu.entity.*;
import main.snnu.service.*;
import main.snnu.service.Impl.*;
import main.snnu.utils.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by WT on 2017/12/5.
 */
@MyMapping(mapping = "/system")
public class SystemController {
    @Role(1)
    @MyMapping(mapping = "/index")
    public void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/index.jsp");
        dispatcher.forward(request,response);
    }
    private CourseService courseService = new CourseServiceImpl();
    @Role(1)
    @MyMapping(mapping = "/showCourse")
    public void showCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
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
    private StudentService studentService = new StudentServiceImpl();
    @Role(1)
    @MyMapping(mapping = "/showStudent")
    public void showStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
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
    private TeacherService teacherService = new TeacherServiceImpl();
    @Role(1)
    @MyMapping(mapping = "/showTeacher")
    public void showTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
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
    private StuCouService stuCouService = new StuCouServiceImpl();
    @Role(1)
    @MyMapping(mapping = "/showStuCou")
    public void showStuCou(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Result result = stuCouService.queryAllStuCou();
        int i = ((List<StuCou>)result.getData()).size();
        Page<StuCou> stuCouPage = new Page<StuCou>(1,5,i);
        stuCouPage.settList((List<StuCou>) (stuCouService.findPage(stuCouPage.getStartIndex(),stuCouPage.getCount()).getData()));
        request.setAttribute("data",stuCouPage.gettList());
        request.setAttribute("currentPage",stuCouPage.getCurrentPage());
        request.setAttribute("totalPage",stuCouPage.getTotalPage());
        request.setAttribute("count",stuCouPage.getCount());
        request.setAttribute("totalCount",stuCouPage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showStuCou.jsp");
        dispatcher.forward(request,response);
    }
    private TeaCouService teaCouService = new TeaCouServiceImpl();
    @Role(1)
    @MyMapping(mapping = "/showTeaCou")
    public void showTeaCou(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Result result = teaCouService.queryAllTeaCOu();
        int i = ((List<TeaCou>)result.getData()).size();
        Page<TeaCou> teaCouPage = new Page<TeaCou>(1,5,i);
        teaCouPage.settList((List<TeaCou>) (teaCouService.findPage(teaCouPage.getStartIndex(),teaCouPage.getCount()).getData()));
        request.setAttribute("data",teaCouPage.gettList());
        request.setAttribute("currentPage",teaCouPage.getCurrentPage());
        request.setAttribute("totalPage",teaCouPage.getTotalPage());
        request.setAttribute("count",teaCouPage.getCount());
        request.setAttribute("totalCount",teaCouPage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showTeacou.jsp");
        dispatcher.forward(request,response);
    }
    private UserService userService = new UserServiceImpl();
    @Role(4)
    @MyMapping(mapping = "/showUser")
    public void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Result result = userService.queryAll();
        int i = ((List<User>)result.getData()).size();
        Page<User> coursePage = new Page<User>(1,5,i);
        coursePage.settList((List<User>) (userService.findPage(coursePage.getStartIndex(),coursePage.getCount()).getData()));
        System.out.println(coursePage);
        request.setAttribute("data",coursePage.gettList());
        request.setAttribute("currentPage",coursePage.getCurrentPage());
        request.setAttribute("totalPage",coursePage.getTotalPage());
        request.setAttribute("count",coursePage.getCount());
        request.setAttribute("totalCount",coursePage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showUser.jsp");
        dispatcher.forward(request,response);
    }
}

package main.snnu.controller;

import main.snnu.anno.MyMapping;
import main.snnu.anno.Role;
import main.snnu.entity.Result;
import main.snnu.entity.User;
import main.snnu.enums.StatusEnum;
import main.snnu.service.Impl.UserServiceImpl;
import main.snnu.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by WT on 2017/12/5.
 */
@MyMapping(mapping = "/session")
public class SessionController {
    @MyMapping(mapping = "/loginPage")
    public void loginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/session/loginPage.jsp");
        dispatcher.forward(request,response);
    }
    @MyMapping(mapping = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        Cookie cookiePassword = new Cookie("userPassword", userPassword);
        cookiePassword.setMaxAge(60 * 60 * 24 * 3);
        response.addCookie(cookiePassword);
        Cookie cookieName = new Cookie("userName", userName);
        cookieName.setMaxAge(60 * 60 * 24 * 3);
        response.addCookie(cookieName);

        UserService userService = new UserServiceImpl();
        Result result = userService.checkUser(userName, userPassword);
        System.err.println(result);
        if (result.getMsg() != null && result.getMsg().equals(StatusEnum.LOGIN_SUCCESS.getStateInfo())) {
            User user = (User) result.getData();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/system/index");
        } else {
            response.sendRedirect("/session/loginPage");
        }
    }
    @MyMapping(mapping = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("/session/loginPage");
    }
}

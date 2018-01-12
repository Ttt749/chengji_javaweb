package main.snnu.servlet.session;

import main.snnu.entity.Result;
import main.snnu.entity.User;
import main.snnu.enums.StatusEnum;
import main.snnu.service.Impl.UserServiceImpl;
import main.snnu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by WT on 2017/11/30.
 */
public class loginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

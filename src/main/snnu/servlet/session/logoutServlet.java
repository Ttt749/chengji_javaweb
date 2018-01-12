package main.snnu.servlet.session;

import main.snnu.entity.Result;
import main.snnu.entity.User;
import main.snnu.enums.StatusEnum;
import main.snnu.service.Impl.UserServiceImpl;
import main.snnu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by WT on 2017/12/2.
 */
public class logoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("/session/loginPage");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}

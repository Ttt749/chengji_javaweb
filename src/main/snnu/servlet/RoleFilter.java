package main.snnu.servlet;

import main.snnu.entity.User;
import main.snnu.utils.AnnoUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by WT on 2017/12/9.
 */
public class RoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String currentURL = request.getRequestURI();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Map<String, Integer> hashMapRole = AnnoUtil.getHashMapRole();
        if (hashMapRole != null && hashMapRole.containsKey(currentURL)) {
            if (hashMapRole.get(currentURL) <= user.getUserRole()) {
                filterChain.doFilter(request, response);
                return;
            } else {
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

package main.snnu.servlet;

import main.snnu.utils.AnnoUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by WT on 2017/12/5.
 */
public class Dispatcher implements Filter{
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
        Map<String,Object> mapClass= AnnoUtil.getHashMapClass();
        Map<String,Method> mapMethod=AnnoUtil.getHashMapMethod();
        if(mapClass!=null&&mapClass.containsKey(currentURL)){
            try {
                mapMethod.get(currentURL).invoke(mapClass.get(currentURL),request,response);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

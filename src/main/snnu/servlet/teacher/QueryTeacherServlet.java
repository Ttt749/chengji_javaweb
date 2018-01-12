package main.snnu.servlet.teacher;

import main.snnu.entity.Result;
import main.snnu.service.Impl.TeacherServiceImpl;
import main.snnu.service.TeacherService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WT on 2017/12/5.
 */
public class QueryTeacherServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String tId = request.getParameter("tId");
        Result result = teacherService.queryTeacherById(tId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}

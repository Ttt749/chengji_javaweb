package main.snnu.servlet.stucou;

import main.snnu.entity.Result;
import main.snnu.entity.StuCou;
import main.snnu.service.Impl.StuCouServiceImpl;
import main.snnu.service.StuCouService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WT on 2017/12/3.
 */
public class insertStuCouServlet extends HttpServlet {
    private StuCouService stuCouService = new StuCouServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        StuCou stuCou = new StuCou();
        stuCou.setcId(request.getParameter("cId"));
        stuCou.setsId(request.getParameter("sId"));
        stuCou.setScScore(0);
        Result result = stuCouService.insertStuCou(stuCou);
        System.err.println(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}

package main.snnu.controller;

import main.snnu.anno.MyMapping;
import main.snnu.anno.Role;
import main.snnu.entity.Result;
import main.snnu.entity.StuCou;
import main.snnu.service.Impl.StuCouServiceImpl;
import main.snnu.service.StuCouService;
import main.snnu.utils.JsonReader;
import main.snnu.utils.Page;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by WT on 2017/12/5.
 */
@MyMapping(mapping = "/system/stucou")
public class StuCouController {
    private StuCouService stuCouService = new StuCouServiceImpl();
    @Role(2)
    @MyMapping(mapping = "/findPage")
    public void findStucouPage(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String startIndex = request.getParameter("startIndex");
        String pageSize = request.getParameter("pageSize");
        String totalCount = request.getParameter("totalCount");
        Page<StuCou> stuCouPage = new Page<StuCou>(Integer.parseInt(startIndex),Integer.parseInt(pageSize),Integer.parseInt(totalCount));
        stuCouPage.settList((List<StuCou>) (stuCouService.findPage(stuCouPage.getStartIndex(),stuCouPage.getCount()).getData()));
        request.setAttribute("data",stuCouPage.gettList());
        request.setAttribute("currentPage",stuCouPage.getCurrentPage());
        request.setAttribute("totalPage",stuCouPage.getTotalPage());
        request.setAttribute("count",stuCouPage.getCount());
        request.setAttribute("totalCount",stuCouPage.getTotalCount());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/system/showStuCou.jsp");
        dispatcher.forward(request,response);
    }
    @Role(1)
    @MyMapping(mapping = "/insertSC")
    public void insertSC(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
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
    @Role(1)
    @MyMapping(mapping = "/deleteStucou")
    public void deleteStucou(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String sId = request.getParameter("sId");
        String cId = request.getParameter("cId");
        StuCou stuCou = new StuCou();
        stuCou.setsId(sId);
        stuCou.setcId(cId);
        System.err.println(stuCou);
        Result result = stuCouService.deleteStuCou(stuCou);
        System.err.println(result);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(2)
    @MyMapping(mapping = "/updateStucou")
    public void updateStucou(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        JSONObject json = JsonReader.getJson(request);
        StuCou stuCou = (StuCou)JSONObject.toBean(json,StuCou.class);
        Result result = stuCouService.updateStuCou(stuCou);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
    @Role(2)
    @MyMapping(mapping = "/queryStucou")//sid 查询
    public void queryStucou(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/json;charset=utf-8");
        String sId = request.getParameter("sId");
        Result result = stuCouService.queryStuCouByStu(sId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}

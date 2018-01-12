package main.snnu.service.Impl;

import main.snnu.dao.Impl.StuCouDaoImpl;
import main.snnu.dao.StuCouDao;
import main.snnu.entity.Result;
import main.snnu.entity.StuCou;
import main.snnu.enums.StatusEnum;
import main.snnu.service.StuCouService;
import main.snnu.utils.DaoFactory;

import java.util.List;

/**
 * Created by WT on 2017/11/30.
 */
public class StuCouServiceImpl implements StuCouService {
    private StuCouDao stuCouDao = (StuCouDao) DaoFactory.getDao(StuCouDao.class);
    @Override
    public Result queryAllStuCou() {
        Result result=new Result();
        try{
            List<StuCou> stuCouList = stuCouDao.queryAll();
            if(stuCouList!=null&&stuCouList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(stuCouList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result findPage(int startIndex, int pageSize) {
        Result result=new Result();
        try{
            List<StuCou> stuCouList = stuCouDao.findPage(startIndex,pageSize);
            if(stuCouList!=null&&stuCouList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(stuCouList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryStuCouByStu(String sId) {
        Result result=new Result();
        try{
            List<StuCou> stuCouList = stuCouDao.queryByStu(sId);
            if(stuCouList!=null&&stuCouList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(stuCouList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryStuCouByCou(String cId) {
        Result result=new Result();
        try{
            List<StuCou> stuCouList = stuCouDao.queryByCou(cId);
            if(stuCouList!=null&&stuCouList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(stuCouList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result deleteStuCou(String sId, String cId) {
        Result result=new Result();
        try{
            int i = stuCouDao.delete(sId,cId);
            if(i>0){
                result.setMsg(StatusEnum.DETELE_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.DETELE_ERROR.getStateInfo());
            }
            result.setCode(i);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result deleteStuCou(StuCou stuCou) {
        Result result=new Result();
        try{
            int i = stuCouDao.delete(stuCou);
            if(i>0){
                result.setMsg(StatusEnum.DETELE_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.DETELE_ERROR.getStateInfo());
            }
            result.setCode(i);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result insertStuCou(StuCou stuCou) {
        Result result=new Result();
        try{
            int i = stuCouDao.insert(stuCou);
            if(i>0){
                result.setMsg(StatusEnum.INSERT_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.INSERT_ERROR.getStateInfo());
            }
            result.setCode(i);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result updateStuCou(StuCou stuCou) {
        Result result=new Result();
        try{
            int i = stuCouDao.update(stuCou);
            if(i>0){
                result.setMsg(StatusEnum.UPDATE_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.UPDATE_ERROR.getStateInfo());
            }
            result.setCode(i);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }
}

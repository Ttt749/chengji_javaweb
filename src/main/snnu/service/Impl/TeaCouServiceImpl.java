package main.snnu.service.Impl;

import main.snnu.dao.Impl.TeaCouDaoImpl;
import main.snnu.dao.TeaCouDao;
import main.snnu.entity.Result;
import main.snnu.entity.TeaCou;;
import main.snnu.enums.StatusEnum;
import main.snnu.service.TeaCouService;
import main.snnu.utils.DaoFactory;

import java.util.List;

/**
 * Created by WT on 2017/12/1.
 */
public class TeaCouServiceImpl implements TeaCouService {
    private TeaCouDao teaCouDao = (TeaCouDao) DaoFactory.getDao(TeaCouDao.class);

    @Override
    public Result queryAllTeaCOu(){
        Result result = new Result();
        try{
            List<TeaCou> teaCouList = teaCouDao.queryAll();
            if(teaCouList!=null&&teaCouList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(teaCouList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result findPage(int startIndex, int pageSize) {
        Result result = new Result();
        try{
            List<TeaCou> teaCouList = teaCouDao.findPage(startIndex,pageSize);
            if(teaCouList!=null&&teaCouList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(teaCouList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryTeaCOuByTid(String tId) {
        Result result = new Result();
        try{
            List<TeaCou> teaCouList = teaCouDao.queryByStu(tId);
            if(teaCouList!=null&&teaCouList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(teaCouList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryTeaCOuByCou(String cId) {
        Result result = new Result();
        try{
            List<TeaCou> teaCouList = teaCouDao.queryByCou(cId);
            if(teaCouList!=null&&teaCouList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(teaCouList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result deleteTeaCOu(TeaCou teaCou) {
        Result result = new Result();
        try{
            int  i = teaCouDao.delete(teaCou);
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
    public Result insertTeaCOu(TeaCou teaCou) {
        Result result = new Result();
        try{
            int  i = teaCouDao.insert(teaCou);
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
    public Result updateTeaCOu(TeaCou teaCou) {
        Result result = new Result();
        try{
            int  i = teaCouDao.update(teaCou);
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

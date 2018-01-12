package main.snnu.service.Impl;

import main.snnu.dao.Impl.UserDaoImpl;
import main.snnu.entity.Result;
import main.snnu.enums.StatusEnum;
import main.snnu.service.UserService;
import main.snnu.dao.UserDao;
import main.snnu.entity.User;
import main.snnu.utils.DaoFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WT on 2017/11/30.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = (UserDao) DaoFactory.getDao(UserDao.class);

    @Override
    public Result checkUser(String userName, String userPassword){
        Result result=new Result();
        if(userDao==null){
            userDao = new UserDaoImpl();
        }
        try{
            User user=userDao.queryByName(userName);
            if(user==null||user.getUserId()==null||user.getUserId().length()<=0)
                result.setMsg(StatusEnum.LOGIN_FAIL.getStateInfo());
            else if(user.getUserPassword().equals(userPassword))
                result.setMsg(StatusEnum.LOGIN_SUCCESS.getStateInfo());
            else
                result.setMsg(StatusEnum.LOGIN_FAIL.getStateInfo());
            result.setData(user);
        }catch (SQLException e){
            result.setException(e);
        }catch (Exception e) {
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryAll() {
        Result result=new Result();
        try{
            List<User> userList = userDao.queryAll();
            if(userList!=null&&userList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(userList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result insertUser(User user) {
        int i=0;
        Result result=new Result();
        if(userDao==null){
            userDao = new UserDaoImpl();
        }
        try{
            i=userDao.insert(user);
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
    public Result deleteUser(User user) {
        int i=0;
        Result result=new Result();
        if(userDao==null){
            userDao = new UserDaoImpl();
        }
        try{
            i=userDao.delete(user);
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
    public Result updateUser(User user) {
        int i=0;
        Result result=new Result();
        if(userDao==null){
            userDao = new UserDaoImpl();
        }
        try{
            i=userDao.update(user);
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

    @Override
    public Result queryUserByName(String UserName) {
        User user=new User();
        Result result=new Result();
        if(userDao==null){
            userDao = new UserDaoImpl();
        }
        try{
            user=userDao.queryByName(UserName);
            if(user!=null&&user.getUserId()!=null&&user.getUserId().length()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(user);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result findPage(int startIndex, int pageSize) {
        List<User> userList=new ArrayList<>();
        Result result=new Result();
        if(userDao==null){
            userDao = new UserDaoImpl();
        }
        try{
            userList=userDao.findePage(startIndex,pageSize);
            if(userList!=null&&userList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(userList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }
}

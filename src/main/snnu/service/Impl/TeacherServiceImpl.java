package main.snnu.service.Impl;

import main.snnu.dao.Impl.TeacherDaoImpl;
import main.snnu.dao.TeacherDao;
import main.snnu.entity.Result;
import main.snnu.entity.Teacher;
import main.snnu.enums.StatusEnum;
import main.snnu.service.TeacherService;
import main.snnu.utils.DaoFactory;

import java.util.List;

/**
 * Created by WT on 2017/12/1.
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = (TeacherDao) DaoFactory.getDao(TeacherDao.class);
    @Override
    public Result queryAllTeacher(){
        Result result = new Result();
        try{
            List<Teacher> teacherList = teacherDao.queryall();
            if(teacherList!=null&&teacherList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(teacherList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result findPage(int startIndex, int pageSize) {
        Result result = new Result();
        try{
            List<Teacher> teacherList = teacherDao.findPage(startIndex,pageSize);
            if(teacherList!=null&&teacherList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(teacherList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryTeacherById(String tId) {
        Result result = new Result();
        try{
            Teacher teacher = teacherDao.queryById(tId);
            if(teacher!=null&&teacher.gettId()!=null&&teacher.gettId().length()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(teacher);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryTeacherByName(String tName) {
        Result result = new Result();
        try{
            Teacher teacher = teacherDao.queryById(tName);
            if(teacher!=null&&teacher.gettId()!=null&&teacher.gettId().length()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(teacher);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result insertTeacher(Teacher teacher) {
        Result result = new Result();
        try{
            int i = teacherDao.insert(teacher);
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
    public Result deleteTeacher(Teacher teacher) {
        Result result = new Result();
        try{
            int i = teacherDao.delete(teacher);
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
    public Result updateTeacher(Teacher teacher) {
        Result result = new Result();
        try{
            int i = teacherDao.update(teacher);
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

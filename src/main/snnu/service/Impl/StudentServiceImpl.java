package main.snnu.service.Impl;

import main.snnu.dao.Impl.StudentDaoImpl;
import main.snnu.dao.StudentDao;
import main.snnu.entity.Result;
import main.snnu.entity.Student;
import main.snnu.enums.StatusEnum;
import main.snnu.service.StudentService;
import main.snnu.utils.DaoFactory;

import java.util.List;

/**
 * Created by WT on 2017/11/30.
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = (StudentDao) DaoFactory.getDao(StudentDao.class);
    @Override
    public Result queryAllStudent() {
        Result result = new Result();
        try{
            List<Student> studentList = studentDao.queryall();
            if(studentList!=null&&studentList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(studentList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result findPage(int startIndex, int pageSize) {
        Result result = new Result();
        try{
            List<Student> studentList = studentDao.findPage(startIndex,pageSize);
            if(studentList!=null&&studentList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(studentList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryStudentById(String sId) {
        Result result = new Result();
        try{
            Student student = studentDao.queryById(sId);
            if(student!=null&&student.getsID()!=null&&student.getsID().length()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(student);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result insertStudent(Student student) {
        Result result = new Result();
        try{
            int i = studentDao.insert(student);
            if(student!=null){
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
    public Result deleteStudent(Student student) {
        Result result = new Result();
        try{
            int i = studentDao.delete(student);
            if(student!=null){
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
    public Result updateStudent(Student student) {
        Result result = new Result();
        try{
            int i = studentDao.update(student);
            if(student!=null){
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
}

package main.snnu.service.Impl;

import main.snnu.dao.CourseDao;
import main.snnu.dao.Impl.CourseDaoImpl;
import main.snnu.entity.Course;
import main.snnu.entity.Result;
import main.snnu.enums.StatusEnum;
import main.snnu.service.CourseService;
import main.snnu.utils.DaoFactory;

import java.util.List;

/**
 * Created by WT on 2017/11/30.
 */
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = (CourseDao) DaoFactory.getDao(CourseDao.class);
    @Override
    public Result queryAllCourse() {
        Result result=new Result();
        try{
            List<Course> courseList = courseDao.queryAll();
            System.out.println(courseList);
            if(courseList!=null&&courseList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(courseList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result findPage(int startIndex, int pageSize) {
        Result result=new Result();
        try{
            List<Course> courseList=courseDao.findPage(startIndex,pageSize);
            if(courseList!=null&&courseList.size()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(courseList);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result queryCourseById(String cId) {
        Result result=new Result();
        try{
            Course course=courseDao.queryById(cId);
            if(course!=null&&course.getcId()!=null&&course.getcId().length()>0){
                result.setMsg(StatusEnum.CHECK_SUCCESS.getStateInfo());
            }else{
                result.setMsg(StatusEnum.CHECK_ERROR.getStateInfo());
            }
            result.setData(course);
        }catch (Exception e){
            result.setException(e);
        }
        return result;
    }

    @Override
    public Result insertCourse(Course course) {
        Result result=new Result();
        try{
            int i=courseDao.insert(course);
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
    public Result deleteCourse(Course course) {
        Result result=new Result();
        try{
            int i=courseDao.delete(course);
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
    public Result updateCourse(Course course) {
        Result result=new Result();
        try{
            int i=courseDao.update(course);
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

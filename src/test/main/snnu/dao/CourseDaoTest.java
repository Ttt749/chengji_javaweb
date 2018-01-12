package main.snnu.dao;

import main.snnu.dao.Impl.CourseDaoImpl;
import main.snnu.entity.Course;
import main.snnu.utils.DaoFactory;
import main.snnu.utils.Invoker;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by WT on 2017/11/30.
 */
public class CourseDaoTest {
    @Test
    public void update() throws Exception {
        try{
            Course course = new Course();
            course.setcId("c565656");
            course.setcName("sad");
            course.setcAttr("caaaaa");
            course.setcClassroom("sad");
            CourseDao courseDao = (CourseDao) Invoker.getInstance(CourseDao.class);
            System.out.println(courseDao.update(course));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void insert() throws Exception {
        try{
            Course course = new Course();
            course.setcId("c565656");
            course.setcName("sad");
            course.setcAttr("ca");
            course.setcClassroom("sad");
            CourseDao courseDao = (CourseDao) Invoker.getInstance(CourseDao.class);
            System.out.println(courseDao.insert(course));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryById() throws Exception {
        try{
            CourseDao courseDao = (CourseDao) Invoker.getInstance(CourseDao.class);
            System.out.println(courseDao.queryById("c565656"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findPage() throws Exception {
        try{
            CourseDao courseDao = (CourseDao) Invoker.getInstance(CourseDao.class);
            System.out.println(courseDao.findPage(0,5));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryAll() throws Exception {
        try{
            CourseDao courseDao = (CourseDao) Invoker.getInstance(CourseDao.class);
            System.out.println(courseDao.queryAll());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void delete() throws Exception{
        try{
            Course course = new Course();
            course.setcId("c565656");
            course.setcName("sad");
            course.setcAttr("ca");
            course.setcClassroom("sad");
            CourseDao courseDao = (CourseDao) Invoker.getInstance(CourseDao.class);
            System.out.println(courseDao.delete(course));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
package main.snnu.service;

import main.snnu.entity.Course;
import main.snnu.entity.Result;
import main.snnu.service.Impl.CourseServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by WT on 2017/12/2.
 */
public class CourseServiceTest {
    private CourseService courseService = new CourseServiceImpl();
    @Test
    public void findPage() throws Exception {
        try{
            Result result = courseService.findPage(0,5);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void deleteCourse() throws Exception {
        try{
            Course course = new Course();
            course.setcId("a");
            Result result=courseService.deleteCourse(course);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
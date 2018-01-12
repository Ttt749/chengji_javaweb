package main.snnu.service.Impl;

import main.snnu.entity.Result;
import main.snnu.service.CourseService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by WT on 2017/12/30.
 */
public class CourseServiceImplTest {
    private CourseService courseService =new CourseServiceImpl();
    @Test
    public void queryAllCourse() throws Exception {
        Result result = courseService.queryAllCourse();
        System.out.println(result);
    }

}
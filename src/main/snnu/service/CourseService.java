package main.snnu.service;

import main.snnu.entity.Course;
import main.snnu.entity.Result;

/**
 * Created by WT on 2017/11/30.
 */
public interface CourseService {
    Result queryAllCourse();
    Result findPage(int startIndex,int pageSize);
    Result queryCourseById(String cId);
    Result insertCourse(Course course);
    Result deleteCourse(Course course);
    Result updateCourse(Course course);
}

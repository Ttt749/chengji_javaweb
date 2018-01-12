package main.snnu.dao;

import main.snnu.anno.Prarm;
import main.snnu.anno.Request;
import main.snnu.anno.ResultMap;
import main.snnu.anno.Sql;
import main.snnu.entity.Course;

import java.util.List;

/**
 * Created by WT on 2017/11/29.
 */
public interface CourseDao {
    @Sql("select * from course")
    @ResultMap("Course")
    List<Course> queryAll() throws Exception;

    @Sql("select * from course limit #startIndex,#pageSize")
    @ResultMap("Course")
    List<Course> findPage(@Prarm("startIndex") int startIndex,@Prarm("pageSize") int pageSize) throws Exception;

    @Sql("select * from course where c_id='#cId'")
    @ResultMap("Course")
    Course queryById(@Prarm("cId") String cId) throws Exception;

    @Sql("insert into course(c_id,c_name,c_attr,c_classroom) VALUES ('#course.cId','#course.cName','#course.cAttr','#course.cClassroom')")
    @Request("Course")
    int insert(@Prarm("course") Course course) throws Exception;

    @Sql("DELETE FROM course WHERE c_id = '#course.cId'")
    @Request("Course")
    int delete(@Prarm("course") Course course) throws Exception;

    @Sql("UPDATE course SET c_name='#course.cName',c_attr='#course.cAttr',c_classroom='#course.cClassroom' WHERE c_id='#course.cId'")
    @Request("Course")
    int update(@Prarm("course") Course course) throws Exception;
}

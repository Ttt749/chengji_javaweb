package main.snnu.dao;

import main.snnu.anno.Prarm;
import main.snnu.anno.Request;
import main.snnu.anno.ResultMap;
import main.snnu.anno.Sql;
import main.snnu.entity.Teacher;

import java.util.List;

/**
 * Created by WT on 2017/12/1.
 */
public interface TeacherDao {
    @Sql("select * from teacher")
    @ResultMap("Teacher")
    List<Teacher> queryall() throws Exception;
    @Sql("select * from teacher limit #startIndex,#pageSize")
    @ResultMap("Teacher")
    List<Teacher> findPage(@Prarm("startIndex") int startIndex,@Prarm("pageSize") int pageSize) throws Exception;
    @Sql("select * from teacher WHERE t_id='#tId'")
    @ResultMap("Teacher")
    Teacher queryById(@Prarm("tId") String tId) throws Exception;
    @Sql("select * from teacher WHERE t_name='#tName'")
    @ResultMap("Teacher")
    Teacher queryByName(@Prarm("tName") String tName) throws Exception;
    @Sql("insert into " +
            "teacher (t_id,t_name,t_age,t_sex,t_school,t_graduate,t_text) " +
            "values ('#teacher.tId','#teacher.tName',#teacher.tAge,'#teacher.tSex'," +
            "'#teacher.tSchool','#teacher.tGraduate','#teacher.tText')")
    @Request("Teacher")
    int insert(@Prarm("teacher") Teacher teacher) throws Exception;
    @Sql("DELETE FROM teacher WHERE t_id='#teacher.tId'")
    @Request("Teacher")
    int delete(@Prarm("teacher")Teacher teacher) throws Exception;
    @Sql("UPDATE teacher SET " +
            "t_name='#teacher.tName',t_age=#teacher.tAge,t_sex='#teacher.tSex'," +
            "t_school='#teacher.tSchool',t_graduate='#teacher.tGraduate',t_text='#teacher.tText' " +
            "WHERE t_id=?")
    @Request("Teacher")
    int update(@Prarm("teacher")Teacher teacher) throws Exception;
}

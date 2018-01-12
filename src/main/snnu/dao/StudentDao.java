package main.snnu.dao;

import main.snnu.anno.Prarm;
import main.snnu.anno.Request;
import main.snnu.anno.ResultMap;
import main.snnu.anno.Sql;
import main.snnu.entity.Student;

import java.util.List;

/**
 * Created by WT on 2017/11/29.
 */
public interface StudentDao {
    @Sql("select * from student")
    @ResultMap("Student")
    List<Student> queryall() throws Exception;
    @Sql("select * from student limit #startIndex,#pageSize")
    @ResultMap("Student")
    List<Student> findPage(@Prarm("startIndex") int startIndex,@Prarm("pageSize") int pageSize) throws Exception;
    @Sql("select * from student WHERE s_id='#sId'")
    @ResultMap("Student")
    Student queryById(@Prarm("sId") String sId) throws Exception;
    @Sql("INSERT INTO " +
            "student(s_id,s_name,s_age,s_sex,s_class) " +
            "VALUES ('#student.sID','#student.sName',#student.sAge,'#student.sSex','#student.sClass')")
    @Request("Student")
    int insert(@Prarm("student") Student student) throws Exception;
    @Sql("DELETE FROM student WHERE s_id='#student.sID'")
    @Request("Student")
    int delete(@Prarm("student") Student student) throws Exception;
    @Sql("UPDATE student " +
            "SET s_name='#student.sName',s_age=#student.sAge,s_sex='#student.sSex',s_class='#student.sClass' " +
            "WHERE s_id='#student.sID'")
    @Request("Student")
    int update(@Prarm("student")Student student) throws Exception;
}

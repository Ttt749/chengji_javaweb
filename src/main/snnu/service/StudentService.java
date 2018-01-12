package main.snnu.service;

import main.snnu.entity.Result;
import main.snnu.entity.Student;

/**
 * Created by WT on 2017/11/30.
 */
public interface StudentService {
    Result queryAllStudent();
    Result findPage(int startIndex,int pageSize);
    Result queryStudentById(String sId);
    Result insertStudent(Student student);
    Result deleteStudent(Student student);
    Result updateStudent(Student student);
}

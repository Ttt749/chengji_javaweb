package main.snnu.service;

import main.snnu.entity.Result;
import main.snnu.entity.Teacher;

/**
 * Created by WT on 2017/12/1.
 */
public interface TeacherService {
    Result queryAllTeacher();
    Result findPage(int startIndex,int pageSize);
    Result queryTeacherById(String tId);
    Result queryTeacherByName(String tName);
    Result insertTeacher(Teacher teacher);
    Result deleteTeacher(Teacher teacher);
    Result updateTeacher(Teacher teacher);
}

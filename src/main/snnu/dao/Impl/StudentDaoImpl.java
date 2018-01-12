package main.snnu.dao.Impl;

import main.snnu.entity.Student;
import main.snnu.dao.StudentDao;
import main.snnu.utils.C3P0Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WT on 2017/11/29.
 */
public class StudentDaoImpl implements StudentDao {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    @Override
    public List<Student> queryall() throws Exception{
        String sql="select * from student";
        List<Student> studentList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Student student = new Student();
                student.setsID(rs.getString("s_id"));
                student.setsName(rs.getString("s_name"));
                student.setsAge(rs.getInt("s_age"));
                student.setsSex(rs.getString("s_sex"));
                student.setsClass(rs.getString("s_class"));
                studentList.add(student);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e){
            throw e;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch (SQLException e){
                throw e;
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException e){
                throw e;
            }
        }
        return studentList;
    }

    @Override
    public List<Student> findPage(int startIndex,int pageSize) throws Exception {
        String sql="select * from student limit ?,?";
        List<Student> studentList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,startIndex);
            pstmt.setInt(2,pageSize);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setsID(rs.getString("s_id"));
                student.setsName(rs.getString("s_name"));
                student.setsAge(rs.getInt("s_age"));
                student.setsSex(rs.getString("s_sex"));
                student.setsClass(rs.getString("s_class"));
                studentList.add(student);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e){
            throw e;
        } finally {
            try{
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                throw e;
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException e){
                throw e;
            }
        }
        return studentList;
    }

    @Override
    public Student queryById(String sId) throws Exception{
        String sql="select * from student WHERE s_id='"+sId+"'";
        Student student=new Student();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                student.setsID(rs.getString("s_id"));
                student.setsName(rs.getString("s_name"));
                student.setsAge(rs.getInt("s_age"));
                student.setsSex(rs.getString("s_sex"));
                student.setsClass(rs.getString("s_class"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e){
            throw e;
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch (SQLException e){
                throw e;
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException e){
                throw e;
            }
        }
        return student;
    }

    @Override
    public int insert(Student student) throws Exception{
        String sql="INSERT INTO student(s_id,s_name,s_age,s_sex,s_class) VALUES (?,?,?,?,?)";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,student.getsID());
            pstmt.setString(2,student.getsName());
            pstmt.setInt(3,student.getsAge());
            pstmt.setString(4,student.getsSex());
            pstmt.setString(5,student.getsClass());
            i=pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } catch (Exception e){
            conn.rollback();
            throw e;
        } finally {
            try{
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                throw e;
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException e){
                throw e;
            }
        }
        return i;
    }

    @Override
    public int delete(Student student) throws Exception{
        String sql="DELETE FROM student WHERE s_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,student.getsID());
            i=pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } catch (Exception e){
            conn.rollback();
            throw e;
        } finally {
            try{
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                throw e;
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException e){
                throw e;
            }
        }
        return i;
    }

    @Override
    public int update(Student student) throws Exception{
        String sql="UPDATE student SET s_name=?,s_age=?,s_sex=?,s_class=? WHERE s_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,student.getsName());
            pstmt.setInt(2,student.getsAge());
            pstmt.setString(3,student.getsSex());
            pstmt.setString(4,student.getsClass());
            pstmt.setString(5,student.getsID());
            i=pstmt.executeUpdate();
            conn.commit();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } catch (Exception e){
            conn.rollback();
            throw e;
        } finally {
            try{
                if(pstmt!=null)
                    pstmt.close();
            }catch (SQLException e){
                throw e;
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException e){
                throw e;
            }
        }
        return i;
    }
}

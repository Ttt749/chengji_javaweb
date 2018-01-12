package main.snnu.dao.Impl;

import main.snnu.dao.TeacherDao;
import main.snnu.entity.Teacher;
import main.snnu.utils.C3P0Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WT on 2017/12/1.
 */
public class TeacherDaoImpl implements TeacherDao {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    @Override
    public List<Teacher> queryall() throws Exception {
        String sql="select * from teacher";
        List<Teacher> teacherList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.settId(rs.getString("t_id"));
                teacher.settName(rs.getString("t_name"));
                teacher.settAge(rs.getInt("t_age"));
                teacher.settSex(rs.getString("t_sex"));
                teacher.settSchool(rs.getString("t_school"));
                teacher.settGraduate(rs.getString("t_graduate"));
                teacher.settText(rs.getString("t_text"));
                teacherList.add(teacher);
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
        return teacherList;
    }

    @Override
    public List<Teacher> findPage(int startIndex, int pageSize) throws Exception {
        String sql="select * from teacher limit ?,?";
        List<Teacher> teacherList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,startIndex);
            pstmt.setInt(2,pageSize);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.settId(rs.getString("t_id"));
                teacher.settName(rs.getString("t_name"));
                teacher.settAge(rs.getInt("t_age"));
                teacher.settSex(rs.getString("t_sex"));
                teacher.settSchool(rs.getString("t_school"));
                teacher.settGraduate(rs.getString("t_graduate"));
                teacher.settText(rs.getString("t_text"));
                teacherList.add(teacher);
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
        return teacherList;
    }

    @Override
    public Teacher queryById(String tId) throws Exception {
        String sql="select * from teacher WHERE t_id='"+tId+"'";
        Teacher teacher=new Teacher();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                teacher.settId(rs.getString("t_id"));
                teacher.settName(rs.getString("t_name"));
                teacher.settAge(rs.getInt("t_age"));
                teacher.settSex(rs.getString("t_sex"));
                teacher.settSchool(rs.getString("t_school"));
                teacher.settGraduate(rs.getString("t_graduate"));
                teacher.settText(rs.getString("t_text"));
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
        return teacher;
    }

    @Override
    public Teacher queryByName(String tName) throws Exception {
        String sql="select * from teacher WHERE t_name='"+tName+"'";
        Teacher teacher=new Teacher();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                teacher.settId(rs.getString("t_id"));
                teacher.settName(rs.getString("t_name"));
                teacher.settAge(rs.getInt("t_age"));
                teacher.settSex(rs.getString("t_sex"));
                teacher.settSchool(rs.getString("t_school"));
                teacher.settGraduate(rs.getString("t_graduate"));
                teacher.settText(rs.getString("t_text"));
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
        return teacher;
    }

    @Override
    public int insert(Teacher teacher) throws Exception {
        String sql="insert into teacher (t_id,t_name,t_age,t_sex,t_school,t_graduate,t_text) values (?,?,?,?,?,?,?)";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,teacher.gettId());
            pstmt.setString(2,teacher.gettName());
            pstmt.setInt(3,teacher.gettAge());
            pstmt.setString(4,teacher.gettSex());
            pstmt.setString(5,teacher.gettSchool());
            pstmt.setString(6,teacher.gettGraduate());
            pstmt.setString(7,teacher.gettText());
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
    public int delete(Teacher teacher) throws Exception {
        String sql="DELETE FROM teacher WHERE t_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,teacher.gettId());
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
    public int update(Teacher teacher) throws Exception {
        String sql="UPDATE teacher SET t_name=?,t_age=?,t_sex=?,t_school=?,t_graduate=?,t_text=? WHERE t_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,teacher.gettName());
            pstmt.setInt(2,teacher.gettAge());
            pstmt.setString(3,teacher.gettSex());
            pstmt.setString(4,teacher.gettSchool());
            pstmt.setString(5,teacher.gettGraduate());
            pstmt.setString(6,teacher.gettText());
            pstmt.setString(7,teacher.gettId());
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

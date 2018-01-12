package main.snnu.dao.Impl;

import main.snnu.dao.CourseDao;
import main.snnu.entity.Course;
import main.snnu.utils.C3P0Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WT on 2017/11/29.
 */
public class CourseDaoImpl implements CourseDao {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    @Override
    public List<Course> queryAll() throws Exception{
        String sql="select * from course";
        List<Course> courseList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Course course = new Course();
                course.setcId(rs.getString("c_id"));
                course.setcName(rs.getString("c_name"));
                course.setcAttr(rs.getString("c_attr"));
                course.setcClassroom(rs.getString("c_classroom"));
                courseList.add(course);
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
        return courseList;
    }

    @Override
    public List<Course> findPage(int startIndex, int pageSize) throws Exception{
        String sql="select * from course limit ?,?";
        List<Course> courseList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,startIndex);
            pstmt.setInt(2,pageSize);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setcId(rs.getString("c_id"));
                course.setcName(rs.getString("c_name"));
                course.setcAttr(rs.getString("c_attr"));
                course.setcClassroom(rs.getString("c_classroom"));
                courseList.add(course);
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
        return courseList;
    }

    @Override
    public Course queryById(String cId) throws Exception{
        String sql="select * from course where c_id='"+cId+"'";
        Course course=new Course();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                course.setcId(rs.getString("c_id"));
                course.setcName(rs.getString("c_name"));
                course.setcAttr(rs.getString("c_attr"));
                course.setcClassroom(rs.getString("c_classroom"));
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
        return course;
    }

    @Override
    public int insert(Course course) throws Exception{
        String sql="insert into course(c_id,c_name,c_attr,c_classroom) VALUES (?,?,?,?)";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,course.getcId());
            pstmt.setString(2,course.getcName());
            pstmt.setString(3,course.getcAttr());
            pstmt.setString(4,course.getcClassroom());
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
    public int delete(Course course) throws Exception{
        String sql="DELETE FROM course WHERE c_id = ?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,course.getcId());
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
    public int update(Course course) throws Exception{
        String sql="UPDATE course SET c_name=?,c_attr=?,c_classroom=? WHERE c_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,course.getcName());
            pstmt.setString(2,course.getcAttr());
            pstmt.setString(3,course.getcClassroom());
            pstmt.setString(4,course.getcId());
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

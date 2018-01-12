package main.snnu.dao.Impl;

import main.snnu.dao.TeaCouDao;
import main.snnu.dao.TeacherDao;
import main.snnu.entity.TeaCou;
import main.snnu.entity.Teacher;
import main.snnu.utils.C3P0Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WT on 2017/12/1.
 */
public class TeaCouDaoImpl implements TeaCouDao {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;

    @Override
    public List<TeaCou> queryAll() throws Exception {
        String sql="select * from t_c";
        List<TeaCou> teaCouList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                TeaCou teaCou = new TeaCou();
                teaCou.settId(rs.getString("t_id"));
                teaCou.setcId(rs.getString("c_id"));
                teaCouList.add(teaCou);
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
        return teaCouList;
    }

    @Override
    public List<TeaCou> findPage(int startIndex, int pageSize) throws Exception {
        String sql="select * from t_c limit ?,?";
        List<TeaCou> teaCouList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,startIndex);
            pstmt.setInt(2,pageSize);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                TeaCou teaCou = new TeaCou();
                teaCou.settId(rs.getString("t_id"));
                teaCou.setcId(rs.getString("c_id"));
                teaCouList.add(teaCou);
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
        return teaCouList;
    }

    @Override
    public List<TeaCou> queryByStu(String tId) throws Exception {
        String sql="select * from t_c WHERE t_id='"+tId+"'";
        List<TeaCou> teaCouList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                TeaCou teaCou = new TeaCou();
                teaCou.settId(rs.getString("t_id"));
                teaCou.setcId(rs.getString("c_id"));
                teaCouList.add(teaCou);
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
        return teaCouList;
    }

    @Override
    public List<TeaCou> queryByCou(String cId) throws Exception {
        String sql="select * from t_c WHERE c_id='"+cId+"'";
        List<TeaCou> teaCouList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                TeaCou teaCou = new TeaCou();
                teaCou.settId(rs.getString("t_id"));
                teaCou.setcId(rs.getString("c_id"));
                teaCouList.add(teaCou);
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
        return teaCouList;
    }

    @Override
    public int delete(TeaCou teaCou) throws Exception {
        String sql="DELETE FROM t_c WHERE t_id=? AND c_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,teaCou.gettId());
            pstmt.setString(2,teaCou.getcId());
            i = pstmt.executeUpdate();
            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } catch (Exception e){
            conn.rollback();
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
        return i;
    }

    @Override
    public int insert(TeaCou teaCou) throws Exception {
        String sql="INSERT INTO t_c(t_id,c_id) VALUES (?,?)";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,teaCou.gettId());
            pstmt.setString(2,teaCou.getcId());
            i = pstmt.executeUpdate();
            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } catch (Exception e){
            conn.rollback();
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
        return i;
    }

    @Override
    public int update(TeaCou teaCou) throws Exception {
        String sql="UPDATE t_c SET t_id=?,c_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,teaCou.gettId());
            pstmt.setString(2,teaCou.getcId());
            i = pstmt.executeUpdate();
            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } catch (Exception e){
            conn.rollback();
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
        return i;
    }
}

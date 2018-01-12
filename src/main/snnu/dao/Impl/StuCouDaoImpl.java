package main.snnu.dao.Impl;

import main.snnu.dao.StuCouDao;
import main.snnu.entity.StuCou;
import main.snnu.utils.C3P0Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WT on 2017/11/29.
 */
public class StuCouDaoImpl implements StuCouDao {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    @Override
    public List<StuCou> queryAll() throws Exception{
        String sql="select * from s_c";
        List<StuCou> stuCouList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StuCou stuCou = new StuCou();
                stuCou.setsId(rs.getString("s_id"));
                stuCou.setcId(rs.getString("c_id"));
                stuCou.setScScore(rs.getInt("s_c_score"));
                stuCouList.add(stuCou);
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
        return stuCouList;
    }

    @Override
    public List<StuCou> findPage(int startIndex, int pageSize) throws Exception {
        String sql="select * from s_c limit ?,?";
        List<StuCou> stuCouList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,startIndex);
            pstmt.setInt(2,pageSize);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                StuCou stuCou = new StuCou();
                stuCou.setsId(rs.getString("s_id"));
                stuCou.setcId(rs.getString("c_id"));
                stuCou.setScScore(rs.getInt("s_c_score"));
                stuCouList.add(stuCou);
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
        return stuCouList;
    }

    @Override
    public List<StuCou> queryByStu(String sId) throws Exception{
        String sql="select * from s_c WHERE s_id='"+sId+"'";
        List<StuCou> stuCouList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StuCou stuCou=new StuCou();
                stuCou.setsId(rs.getString("s_id"));
                stuCou.setcId(rs.getString("c_id"));
                stuCou.setScScore(rs.getInt("s_c_score"));
                stuCouList.add(stuCou);
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
        return stuCouList;
    }

    @Override
    public List<StuCou> queryByCou(String cId) throws Exception{
        String sql="select * from s_c WHERE c_id='"+cId+"'";
        List<StuCou> stuCouList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                StuCou stuCou=new StuCou();
                stuCou.setsId(rs.getString("s_id"));
                stuCou.setcId(rs.getString("c_id"));
                stuCou.setScScore(rs.getInt("s_c_score"));
                stuCouList.add(stuCou);
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
        return stuCouList;
    }

    @Override
    public int delete(String sId, String cId) throws Exception{
        String sql="DELETE FROM s_c WHERE s_id=? and c_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,sId);
            pstmt.setString(2,cId);
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
    public int delete(StuCou stuCou) throws Exception{
        String sql="DELETE FROM s_c WHERE s_id=? and c_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,stuCou.getsId());
            pstmt.setString(2,stuCou.getcId());
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
    public int insert(StuCou stuCou) throws Exception{
        String sql="INSERT INTO s_c(s_id,c_id,s_c_score) VALUES (?,?,?)";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,stuCou.getsId());
            pstmt.setString(2,stuCou.getcId());
            pstmt.setInt(3,stuCou.getScScore());
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

            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException e){

            }
        }
        return i;
    }

    @Override
    public int update(StuCou stuCou) throws Exception{
        String sql="UPDATE s_c SET s_c_score WHERE s_id=? AND c_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,stuCou.getScScore());
            pstmt.setString(2,stuCou.getsId());
            pstmt.setString(3,stuCou.getcId());
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

            }
            try{
                if(conn!=null)
                    conn.close();
            }catch (SQLException e){

            }
        }
        return i;
    }
}

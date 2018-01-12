package main.snnu.dao.Impl;

import main.snnu.dao.UserDao;
import main.snnu.entity.User;
import main.snnu.utils.C3P0Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WT on 2017/11/29.
 */
public class UserDaoImpl implements UserDao {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    @Override
    public List<User> queryAll() throws Exception{
        String sql="select * from tb_user";
        List<User> userList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                User user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserRole(rs.getInt("user_role"));
                userList.add(user);
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
        return userList;
    }

    @Override
    public List<User> findePage(int startIndex,int pageSize) throws Exception {
        String sql="select * from tb_user limit ?,?";
        List<User> userList=new ArrayList<>();
        try{
            conn = C3P0Util.getConnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,startIndex);
            pstmt.setInt(2,pageSize);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUserId(rs.getString("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserRole(rs.getInt("user_role"));
                userList.add(user);
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
        return userList;
    }

    @Override
    public User queryByName(String userName) throws Exception{
        String sql="select * from tb_user WHERE user_name='"+userName+"'";
        User user=new User();
        try{
            conn = C3P0Util.getConnection();
            stmt =conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                user.setUserId(rs.getString("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserRole(rs.getInt("user_role"));
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
        return user;
    }

    @Override
    public int insert(User user) throws Exception{
        String sql="insert into tb_user (user_id,user_name,user_password,user_role) values (?,?,?,?)";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,user.getUserId());
            pstmt.setString(2,user.getUserName());
            pstmt.setString(3,user.getUserPassword());
            pstmt.setInt(4,user.getUserRole());
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
    public int delete(User user) throws Exception{
        String sql="DELETE FROM tb_user WHERE user_id=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,user.getUserId());
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
    public int update(User user) throws Exception{
        String sql="UPDATE tb_user SET user_password=?,user_role=?WHERE user_id=? and user_name=?";
        int i=0;
        try{
            conn = C3P0Util.getConnection();
            conn.setAutoCommit(false);
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,user.getUserPassword());
            pstmt.setString(3,user.getUserId());
            pstmt.setString(4,user.getUserPassword());
            pstmt.setInt(2,user.getUserRole());
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

package main.snnu.dao;

import main.snnu.anno.Prarm;
import main.snnu.anno.Request;
import main.snnu.anno.ResultMap;
import main.snnu.anno.Sql;
import main.snnu.entity.User;

import java.util.List;

/**
 * Created by WT on 2017/11/29.
 */
public interface UserDao {
    @Sql("select * from tb_user")
    @ResultMap("User")
    List<User> queryAll() throws Exception;
    @Sql("select * from tb_user limit #startIndex,#pageSize")
    @ResultMap("User")
    List<User> findePage(@Prarm("startIndex") int startIndex,@Prarm("pageSize") int pageSize) throws Exception;
    @Sql("select * from tb_user WHERE user_name='#userName'")
    @ResultMap("User")
    User queryByName(@Prarm("userName") String userName) throws Exception;
    @Sql("insert into " +
            "tb_user (user_id,user_name,user_password,user_role) " +
            "values ('#user.userId','#user.userName','#user.userPassword',#user.userRole)")
    @Request("User")
    int insert(@Prarm("user") User user) throws Exception;
    @Sql("DELETE FROM tb_user WHERE user_id='#user.userId'")
    @Request("User")
    int delete(@Prarm("user")User user) throws Exception;
    @Sql("UPDATE tb_user SET " +
            "user_password='#user.userPassword',user_role=#user.userRole " +
            "WHERE user_id='#user.userId' and user_name='#user.userName'")
    @Request("User")
    int update(@Prarm("user") User user) throws Exception;
}

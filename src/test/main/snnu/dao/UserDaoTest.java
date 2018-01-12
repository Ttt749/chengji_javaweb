package main.snnu.dao;

import main.snnu.dao.Impl.UserDaoImpl;
import main.snnu.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by WT on 2017/12/1.
 */
public class UserDaoTest {
    @Test
    public void findePage() throws Exception {
        List<User> userList = userDao.findePage(1,5);
        System.out.println(userList);
    }

    private UserDao userDao = new UserDaoImpl();
    @Test
    public void queryAll() throws Exception {
        List<User> userList = userDao.queryAll();
        System.out.println(userList);
    }

    @Test
    public void queryByName() throws Exception {
        User user=userDao.queryByName("41512100");
        System.out.println(user);
    }

}
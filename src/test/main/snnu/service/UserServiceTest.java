package main.snnu.service;

import main.snnu.entity.Result;
import main.snnu.service.Impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by WT on 2017/12/1.
 */
public class UserServiceTest {
    @Test
    public void findPage() throws Exception {
        Result result =userService.findPage(1,5);
        System.out.println(result);
    }

    private UserService userService = new UserServiceImpl();
    @Test
    public void queryAll() throws Exception {
        Result result = userService.queryAll();
        System.out.println(result);

    }
    @Test
    public void checkUser() throws Exception {
        Result result = userService.checkUser("41512100","41512100");
        System.out.println(result);
    }

}
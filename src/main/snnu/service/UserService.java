package main.snnu.service;

import main.snnu.entity.Result;
import main.snnu.entity.User;

/**
 * Created by WT on 2017/11/30.
 */
public interface UserService {
    Result checkUser(String userName, String userPassword);
    Result queryAll();
    Result insertUser(User user);
    Result deleteUser(User user);
    Result updateUser(User user);
    Result queryUserByName(String UserName);
    Result findPage(int startIndex,int pageSize);
}

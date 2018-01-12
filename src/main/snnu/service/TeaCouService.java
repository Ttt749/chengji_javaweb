package main.snnu.service;

import main.snnu.entity.Result;
import main.snnu.entity.TeaCou;

/**
 * Created by WT on 2017/12/1.
 */
public interface TeaCouService {
    Result queryAllTeaCOu();
    Result findPage(int startIndex,int pageSize);
    Result queryTeaCOuByTid(String tId);
    Result queryTeaCOuByCou(String cId);
    Result deleteTeaCOu(TeaCou teaCou);
    Result insertTeaCOu(TeaCou teaCou);
    Result updateTeaCOu(TeaCou teaCou);
}

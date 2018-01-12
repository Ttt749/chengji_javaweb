package main.snnu.service;

import main.snnu.entity.Result;
import main.snnu.entity.StuCou;

/**
 * Created by WT on 2017/11/30.
 */
public interface StuCouService {
    Result queryAllStuCou();
    Result findPage(int startIndex,int pageSize);
    Result queryStuCouByStu(String sId);
    Result queryStuCouByCou(String cId);
    Result deleteStuCou(String sId,String cId);
    Result deleteStuCou(StuCou stuCou);
    Result insertStuCou(StuCou stuCou);
    Result updateStuCou(StuCou stuCou);
}

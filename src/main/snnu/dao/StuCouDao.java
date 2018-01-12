package main.snnu.dao;

import main.snnu.anno.Prarm;
import main.snnu.anno.Request;
import main.snnu.anno.ResultMap;
import main.snnu.anno.Sql;
import main.snnu.entity.StuCou;

import java.util.List;

/**
 * Created by WT on 2017/11/29.
 */
public interface StuCouDao {
    @Sql("select * from s_c")
    @ResultMap("StuCou")
    List<StuCou> queryAll() throws Exception;
    @Sql("select * from s_c limit #startIndex,#pageSize")
    @ResultMap("StuCou")
    List<StuCou> findPage(@Prarm("startIndex") int startIndex,@Prarm("pageSize") int pageSize) throws Exception;
    @Sql("select * from s_c where s_id='#sId'")
    @ResultMap("StuCou")
    List<StuCou> queryByStu(@Prarm("sId") String sId) throws Exception;
    @Sql("select * from s_c where c_id='#cId'")
    @ResultMap("StuCou")
    List<StuCou> queryByCou(@Prarm("cId") String cId) throws Exception;
    @Sql("DELETE FROM s_c WHERE s_id='#sId' and c_id='#cId'")
    int delete(@Prarm("sId")String sId,@Prarm("cId")String cId) throws Exception;
    @Sql("DELETE FROM s_c WHERE s_id='#stuCou.sId' and c_id='#stuCou.cId'")
    @Request("StuCou")
    int delete(@Prarm("stuCou") StuCou stuCou) throws Exception;
    @Sql("INSERT INTO s_c(s_id,c_id,s_c_score) VALUES ('#stuCou.sId','#stuCou.cId',#stuCou.scScore)")
    @Request("StuCou")
    int insert(@Prarm("stuCou")StuCou stuCou) throws Exception;
    @Sql("UPDATE s_c SET s_c_score=#stuCou.scScore WHERE s_id='#stuCou.sId' AND c_id='#stuCou.cId'")
    @Request("StuCou")
    int update(@Prarm("stuCou") StuCou stuCou) throws Exception;
}

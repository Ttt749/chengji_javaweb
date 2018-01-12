package main.snnu.dao;

import main.snnu.anno.Prarm;
import main.snnu.anno.Request;
import main.snnu.anno.ResultMap;
import main.snnu.anno.Sql;
import main.snnu.entity.TeaCou;

import java.util.List;

/**
 * Created by WT on 2017/12/1.
 */
public interface TeaCouDao {
    @Sql("select * from t_c")
    @ResultMap("TeaCou")
    List<TeaCou> queryAll() throws Exception;
    @Sql("select * from t_c limit #startIndex,#pageSize")
    @ResultMap("TeaCou")
    List<TeaCou> findPage(@Prarm("startIndex") int startIndex,@Prarm("pageSize") int pageSize) throws Exception;
    @Sql("select * from t_c WHERE t_id='#tId'")
    @ResultMap("TeaCou")
    List<TeaCou> queryByStu(@Prarm("tId") String tId) throws Exception;
    @Sql("select * from t_c WHERE c_id='#cId'")
    @ResultMap("TeaCou")
    List<TeaCou> queryByCou(@Prarm("cId") String cId) throws Exception;
    @Sql("DELETE FROM t_c WHERE t_id='#teaCou.tId' AND c_id='#teaCou.cId'")
    @Request("TeaCou")
    int delete(@Prarm("teaCou") TeaCou teaCou) throws Exception;
    @Sql("INSERT INTO t_c(t_id,c_id) VALUES ('#teaCou.tId','#teaCou.cId')")
    @Request("TeaCou")
    int insert(@Prarm("teaCou") TeaCou teaCou) throws Exception;
    @Sql("UPDATE t_c SET t_id='#teaCou.tId',c_id='#teaCou.cId'")
    @Request("TeaCou")
    int update(@Prarm("teaCou") TeaCou teaCou) throws Exception;
}

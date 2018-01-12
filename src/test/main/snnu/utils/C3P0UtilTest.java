package main.snnu.utils;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by WT on 2017/11/30.
 */
public class C3P0UtilTest {
    @Test
    public void getConnection() throws Exception {
        try {
            Connection connection=C3P0Util.getConnection();
            System.out.println("Connection:"+connection);
            connection.close();
        }catch (Exception re){
            re.printStackTrace();
        }
    }

}
package main.snnu.utils;

/**
 * Created by WT on 2017/12/30.
 */
public class DaoFactory{
    public static Object getDao(Class clazz){
        return Invoker.getInstance(clazz);
    }
}

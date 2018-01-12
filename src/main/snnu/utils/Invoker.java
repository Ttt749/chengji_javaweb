package main.snnu.utils;

import java.lang.reflect.Proxy;

/**
 * Created by WT on 2017/12/30.
 */
public class Invoker {
    public static Object getInstance(Class<?> clazz){
        MethodProxy methodProxy = new MethodProxy();
        Object object = Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[] {clazz},
                methodProxy
        );
        return object;
    }
}

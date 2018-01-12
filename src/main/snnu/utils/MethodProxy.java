package main.snnu.utils;

import main.snnu.anno.Prarm;
import main.snnu.anno.Request;
import main.snnu.anno.ResultMap;
import main.snnu.anno.Sql;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by WT on 2017/12/30.
 */
public class MethodProxy implements InvocationHandler{
    private Map<String,String> map = ScanXml.getStringMap();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                System.out.println("有实例化");
                return method.invoke(this, args);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            //如果传进来的是一个接口（核心)
        } else {
            return run(method, args);
        }
        return null;
    }
    public Object run(Method method,Object[] args){
        //TODO
        //如远程http调用
        //如远程方法调用（rmi)
        //....
        Sql sql = (Sql) method.getAnnotation(Sql.class);
        if(sql.value().startsWith("select")||sql.value().startsWith("SELECT")){
           return excuteQuery(sql.value(),method,args);
        }else {
           return excuteUpdate(sql.value(),method,args);
        }
    }
    private Object excuteQuery(String sql,Method method,Object[] args){
        Connection conn = C3P0Util.getConnection();
        Type type=method.getAnnotatedReturnType().getType();
        Annotation[][] an = method.getParameterAnnotations();
        ResultMap resultMap = (ResultMap) method.getAnnotation(ResultMap.class);
        Request request = (Request) method.getAnnotation(Request.class);
        try{
            //拼接sql
            if(request!=null&&request.value().length()>0) {
                Class clazz = Class.forName(map.get(request.value()));
                BeanInfo info = Introspector.getBeanInfo(args[0].getClass());
                PropertyDescriptor[] fieldName = info.getPropertyDescriptors();
                Prarm prarm = (Prarm) an[0][0];
                String str = prarm.value();
                for (int i = 0; i < fieldName.length; i++) {
                    String str1 = "#" + str +"."+ fieldName[i].getName();
                    if(!"class".equalsIgnoreCase(fieldName[i].getName())) {
                        if(sql.indexOf(str1)!=-1){
                            sql = sql.replace(str1,fieldName[i].getReadMethod().invoke(args[0]).toString());
                        }
                    }
                }
            }else{
                for (int i =0;i<an.length;i++){
                    Prarm parms = (Prarm) an[i][0];
                    String str1 = parms.value();
                    str1="#"+str1;
                    sql=sql.replaceAll(str1,args[i].toString());
                }
            }
            //返回值
            List<Object> objects = new ArrayList<>();
            PreparedStatement prep = conn.prepareStatement(sql);
            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()){
                Class clz = null;
                Object object = null;
                clz = Class.forName(map.get(resultMap.value()));
                object=clz.newInstance();
                BeanInfo clzInfo = Introspector.getBeanInfo(clz);
                PropertyDescriptor[] fieldName = clzInfo.getPropertyDescriptors();
                for(int i=0;i<fieldName.length;i++){
                    if(!"id".equalsIgnoreCase(fieldName[i].getName()) &&
                            !"class".equalsIgnoreCase(fieldName[i].getName())){
                        fieldName[i].getWriteMethod().invoke(object,resultSet.getObject(map.get(fieldName[i].getName())));
                    }
                }
                if(type.getTypeName().indexOf("List")==-1){
                    return object;
                }else{
                    objects.add(object);
                }
            }
            if(type.getTypeName().indexOf("List")!=-1){
                return objects;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(type.getTypeName());
        return null;
    }
    private Object excuteUpdate(String sql,Method method,Object[] args){
        Connection conn = C3P0Util.getConnection();
        Type type=method.getAnnotatedReturnType().getType();
        Annotation[][] an = method.getParameterAnnotations();
        ResultMap resultMap = (ResultMap) method.getAnnotation(ResultMap.class);
        Request request = (Request) method.getAnnotation(Request.class);
        try{
            //拼接sql
            if(request!=null&&request.value().length()>0) {
                Class clazz = Class.forName(map.get(request.value()));
                BeanInfo info = Introspector.getBeanInfo(args[0].getClass());
                PropertyDescriptor[] fieldName = info.getPropertyDescriptors();
                Prarm prarm = (Prarm) an[0][0];
                String str = prarm.value();
                for (int i = 0; i < fieldName.length; i++) {
                    String str1 = "#" + str +"."+ fieldName[i].getName();
                    if(!"class".equalsIgnoreCase(fieldName[i].getName())) {
                        if(sql.indexOf(str1)!=-1){
                            sql = sql.replace(str1,fieldName[i].getReadMethod().invoke(args[0]).toString());
                        }
                    }
                }
            }else{
                for (int i =0;i<an.length;i++){
                    Prarm parms = (Prarm) an[i][0];
                    String str1 = parms.value();
                    str1="#"+str1;
                    sql=sql.replaceAll(str1,args[i].toString());
                }
            }
            //返回值
            int i=0;
            PreparedStatement prep = conn.prepareStatement(sql);
            i = prep.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(type.getTypeName());
        return null;
    }
}

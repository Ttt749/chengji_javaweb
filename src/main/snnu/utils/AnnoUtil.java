package main.snnu.utils;

import main.snnu.anno.MyMapping;
import main.snnu.anno.Role;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WT on 2017/12/5.
 */
public class AnnoUtil {
    private static Map<String,Object> hashMapClass = new HashMap<>();
    private static Map<String,Method> hashMapMethod = new HashMap<>();
    private static Map<String,Integer> hashMapRole = new HashMap<>();
    static {
        scanPackage("main/snnu/controller");
    }
    public static Map<String,Object> getHashMapClass(){
        return hashMapClass;
    }

    public static Map<String, Method> getHashMapMethod() {
        return hashMapMethod;
    }

    public static Map<String, Integer> getHashMapRole() {
        return hashMapRole;
    }

    public static void scanPackage(String iPackage){
        String path = iPackage.replace(".", "/");
        URL url = Thread.currentThread().getContextClassLoader().getResource(path);
        try {
            if(url!=null && url.toString().startsWith("file")){
                String filePath = URLDecoder.decode(url.getFile(),"utf-8");
                File dir = new File(filePath);
                List<File> fileList = new ArrayList<File>();
                fetchFileList(dir,fileList);
                for(File f:fileList){
                    String fileName =  f.getAbsolutePath();
                    if(fileName.endsWith(".class")){
                        String nosuffixFileName = fileName.substring(fileName.indexOf("main"),fileName.indexOf(".class"));
                        String filePackage = nosuffixFileName.replaceAll("\\\\", ".");
                        Class<?> clazz = Class.forName(filePackage);
                        if(clazz.isAnnotationPresent(MyMapping.class)){
                            MyMapping myMappingClass=(MyMapping) clazz.getAnnotation(MyMapping.class);
                            String str = myMappingClass.mapping();
                            Method[] methods = clazz.getMethods();
                            for(Method method : methods){
                                String str1="";
                                if(method.isAnnotationPresent(MyMapping.class)){
                                    MyMapping myMappingMethod = (MyMapping) method.getAnnotation(MyMapping.class);
                                    str1 = str + myMappingMethod.mapping();
                                    hashMapMethod.put(str1,method);
                                    hashMapClass.put(str1,clazz.newInstance());
                                }
                                if(method.isAnnotationPresent(Role.class)){
                                    Role role = (Role) method.getAnnotation(Role.class);
                                    hashMapRole.put(str1,role.value());
                                }
                            }
                        }
                    }else{
                    }
                    //TODO code........
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void  fetchFileList(File dir,List<File> fileList){
        if(dir.isDirectory()){
            for(File f:dir.listFiles()){
                fetchFileList(f,fileList);
            }
        }else{
            fileList.add(dir);
        }
    }
}

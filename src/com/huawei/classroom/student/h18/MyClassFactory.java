package com.huawei.classroom.student.h18;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyClassFactory {
    private final Map<String, Map<String, Object>> params; //保存参数，键为类名，值为一个键为属性名，值为参数的Map

    //构造函数
    public MyClassFactory(String fileName) {
        this.params = readLines(fileName);
    }


    //创建实例
    public <T> T createInstance(Class<T> clazz) throws InvocationTargetException, NoSuchMethodException{
        T t = null;
        try {
            String className = clazz.getName();
            t = clazz.newInstance();
            Map<String, Object> map = params.get(className);//获取该类的所有参数
            for(String key: map.keySet()) {//获取属性名
                Object value = map.get(key);//获取值
                String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
                dynamicInvokeMethod(t, methodName, value);//动态注入方法，调用setXxx
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return t;
    }

    //多参数动态注入方法
    public void dynamicInvokeMethod(Object obj, String methodName, Object... values)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException{
        Class[] classes = new Class[values.length];
        for(int i = 0; i < values.length; i++) {
            classes[i] = values[i].getClass();
        }
        Method method = obj.getClass().getMethod(methodName, classes);
        method.invoke(obj, values);
    }

    //读取配置文件
    public Map<String, Map<String, Object>> readLines(String fileName) {
        Map<String, Map<String, Object>> res = new HashMap<>();
        try (InputStream in = new FileInputStream(fileName);
        		//不然会导致乱码，必须设置为UTF-8
             InputStreamReader reader = new InputStreamReader(in, "UTF-8");
             LineNumberReader lineReader = new LineNumberReader(reader)){
            String line = "";
            line = lineReader.readLine();
            while(line != null) {
                if(line.trim().length() != 0 && line.trim().charAt(0) != '#') {//不读取注释或空行
                    String[] param = line.split("=");//进行分割
                    String name = param[0];
                    String attribute = param[1];
                    int idx = name.lastIndexOf(".");
                    String className = name.substring(0, idx);
                    String paramName = name.substring(idx + 1);
                    Map<String, Object> map = null;
                    if(res.containsKey(className)) {
                        map = res.get(className);//如当前类已存在，把这个Map拿出来往里面赋值
                    } else {
                        map = new HashMap<>();//出现了一个新的类，给这个类存储参数
                    }
                    if(attribute.charAt(0) == '\"') {//是字符串
                        String value = attribute.substring(1, attribute.length() - 1);
                        map.put(paramName, value);
                    } else {//是int
                        Integer value = Integer.parseInt(attribute);
                        map.put(paramName, value);
                    }
                    if(!res.containsKey(className)) {
                        res.put(className, map);//放进去一个新的类的参数
                    }
                }
                line = lineReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}

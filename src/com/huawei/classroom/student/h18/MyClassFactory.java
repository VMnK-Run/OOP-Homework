package com.huawei.classroom.student.h18;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyClassFactory {
    private final Map<String, Map<String, Object>> params;
    public MyClassFactory(String fileName) {
        this.params = readLines(fileName);
    }

    public <T> T createInstance(Class<T> clazz) throws InvocationTargetException, NoSuchMethodException{
        T t = null;
        try {
            String className = clazz.getName();
            t = clazz.newInstance();
            Map<String, Object> map = params.get(className);
            for(String key: map.keySet()) {
                Object value = map.get(key);
                String methodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
                dynamicInvokeMethod(t, methodName, value);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return t;
    }

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

    public Map<String, Map<String, Object>> readLines(String fileName) {
        Map<String, Map<String, Object>> res = new HashMap<>();
        try (Reader reader = new FileReader(fileName);
            LineNumberReader lineReader = new LineNumberReader(reader)){
            String line = "";
            line = lineReader.readLine();
            while(line != null) {
                if(line.trim().length() != 0 && line.trim().charAt(0) != '#') {
                    String[] param = line.split("=");
                    String name = param[0];
                    String attribute = param[1];
                    int idx = name.lastIndexOf(".");
                    String className = name.substring(0, idx);
                    String paramName = name.substring(idx + 1);
                    Map<String, Object> map = null;
                    if(res.containsKey(className)) {
                        map = res.get(className);
                    } else {
                        map = new HashMap<>();
                    }
                    if(attribute.charAt(0) == '\"') {
                        String value = attribute.substring(1, attribute.length() - 1);
                        map.put(paramName, value);
                    } else {
                        Integer value = Integer.parseInt(attribute);
                        map.put(paramName, value);
                    }
                    if(!res.containsKey(className)) {
                        res.put(className, map);
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

package com.huawei.classroom.student.h19.q05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.*;

public class StudentUtil {
    private final List<String> sortRes = new ArrayList<>();
    public StudentUtil() {

    }
    public List<String> sort(String fileName) {
        List<String[]> scores = readLines(fileName);
        Map<String, Person> map = new HashMap<>();
        for(String[] str: scores) {
            String name = str[0];
            String subject = str[1];
            int score = Integer.parseInt(str[2].substring(0, str[2].length() - 1));
            if(!map.containsKey(name)) {
                Person newPerson = new Person(name);
                if(subject.equals("语文")) {
                    newPerson.setChinese(score);
                } else if(subject.equals("数学")) {
                    newPerson.setMath(score);
                } else {
                    newPerson.setOther(score);
                }
                newPerson.setTotal();
                map.put(name, newPerson);
            } else {
                Person person = map.get(name);
                if(subject.equals("语文")) {
                    person.setChinese(score);
                } else if(subject.equals("数学")) {
                    person.setMath(score);
                } else {
                    person.setOther(score);
                }
                person.setTotal();
            }
        }

        List<Map.Entry<String, Person>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for(Map.Entry<String, Person> person: list) {
            sortRes.add(person.getKey());
        }
        return sortRes;
    }

    private List<String[]> readLines(String fileName) {
        List<String[]> scores = new ArrayList<>();
        try(Reader reader = new FileReader(fileName);
            LineNumberReader lineReader = new LineNumberReader(reader)) {
            String line = lineReader.readLine();
            while(line != null) {
                scores.add(line.split(","));
                line = lineReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }
}

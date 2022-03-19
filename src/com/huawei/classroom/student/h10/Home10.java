package com.huawei.classroom.student.h10;

import java.util.HashMap;

/**
 * 把你作业的代码写到这个类里面
 * 不可以修改类的名字、包名、和固有的几个方法名以及方法的可见性
 * 可以增加其他方法、属性、类
 * 可以引用jdk的类
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Home10 {
	public Home10() {
	} 
	/**
	 * 将一个字符串中字符按出现频率的高到低排序返回，如果两个字符出现的频率一样，则将最先出现的字符排在前面
	 * 例如：orderChar(“abcdefg”)返回 “abcdefg” 
	 * orderChar(“abcdefgg”)返回 “gabcdef”
	 * orderChar(“abcdefgge”)返回 “egabcdf”
	 * orderChar(“天津大学软件学院”)返回 “学天津大软件院”
	 * @param content
	 * @return
	 */
	public String orderChar(String content) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < content.length(); i++) {
			char ch = content.charAt(i);
			if(!map.containsKey(ch)) {
				map.put(ch, 1);
			}
			else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		char[] arrays = content.toCharArray();
		for(int i = 0; i < content.length(); i++) {
			for(int j = i + 1; j < content.length(); j++) {
				if(map.get(arrays[j]) > map.get(arrays[i])){
					char temp = arrays[j];
					arrays[j] = arrays[i];
					arrays[i] = temp;
				}
			}
		}
		String res = arrays.toString();
		return res;
	}
	
}

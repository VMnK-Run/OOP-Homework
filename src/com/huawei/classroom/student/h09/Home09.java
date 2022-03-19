package com.huawei.classroom.student.h09;

import java.util.*;

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
public class Home09 {
	public Home09() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 计算出一段文字中不重复的字符的个数，例如“天津市天津大学 ”不重复字符为5
	 * 提示：使用java.util.HashSet 
	 * 难度系数1星
	 * @param s
	 * @return
	 */
	public int getDistinctCharCount(String s) {
		Set set = new HashSet();
		char[] arrays = s.toCharArray();
		for(int i = 0; i < arrays.length; i++) {
			set.add(arrays[i]);
		}
		return set.size();
	}
	/**
	 * 返回一段文字中，出现频率最高的字符（不考虑并列第一的情况） 例如：getFrequentChar("好好学习") 返回'好'
	 * 例如：getFrequentChar("我是天津大学软件学院学生") 返回'学'
	 * 提示：使用一个长度为65535的数组，或者使用HashMap   
	 * 难度系数2星
	 * @param s
	 * @return
	 */
	public char getFrequentChar(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//Map map = new HashMap();
		char[] arrays = s.toCharArray();
		for(int i = 0; i < arrays.length; i++) {
			if(!map.containsKey(arrays[i])) {
				map.put(arrays[i], 1);
			}
			else {
				map.put(arrays[i], map.get(arrays[i]) + 1);
			}
		}
		int max = 0;
		char ch = ' ';
		Set<Character> set = map.keySet();
		for(char now:set) {
			if(map.get(now) > max){
				max = map.get(now);
				ch = now;
			}
		}
		return ch;
	}
	

	
	/**
	 * 返回一段文字中，出现频率最高的词（每个词由2个字符构成，任意两个相邻的字符称为一个词，例如“天津大学，你好”由“天津”“津大”“大学”“学，”“，你”“你好” 6个词构成)
	 * 不会出现频率最高并列的情况
	 * 提示：使用HashMap 
	 * 难度系数2星
	 * @param content
	 * @return
	 */
	public String getFrequentWord(String content){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < content.length() - 1; i++) {
			String str = content.substring(i, i + 2);
			if(!map.containsKey(str)) {
				map.put(str, 1);
			}
			else {
				map.put(str, map.get(str) + 1);
			}
		}
		Set<String> set = map.keySet();
		int max = 0;
		String res = " ";
		for(String str : set){
			if(map.get(str) > max){
				max = map.get(str);
				res = str;
			}
		}
		return res;
	}
	 
	 
	
	/**
	 * 把一个StringBufer中所有的空格去掉
	 * 提示：不能新建StringBuffer对象，必须在原来的基础上删掉原来字符串
	 * 难度系数1星
	 * @param buf
	 */
	public void zipStringBufer(StringBuffer buf) {
		 for(int i = 0; i < buf.length(); i++) {
			 if(buf.charAt(i) == ' ') {
				 buf.deleteCharAt(i);
			 }
		 }
	}

 
}


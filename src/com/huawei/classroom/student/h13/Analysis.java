
package com.huawei.classroom.student.h13;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

/**
 * 在本包下增加合适的类和方法，使得Test类能够测试通过 
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Analysis {
	private String[] chapters = null;

	/**
	 * @throws Exception
	 * 
	 */
	public Analysis(String filename) throws Exception {
		String text = readFromTxt(filename);//文件读入
		text = text.replaceAll("[\\pP\t\r]", "");//利用正则表达式将标点符号、换号符等删除
		chapters = splitContentToChapter(text);//要操作的数组
	}

	/**
	 * 提示 ：将一个文本文件读取到一个字符串中返回
	 * 
	 * @param filename
	 *            红楼梦文本文件的全路径名
	 * @return 文本的内容
	 */
	private String readFromTxt(String filename) throws Exception {
		Reader reader = null;
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			// InputStream in=new FileInputStream(filename);

			reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
			int readed = reader.read(chars);
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			return buf.toString();
		} finally {
			close(reader);
		}
	}
	
	/**
	 * 返回红楼梦中出现频率最高的N个次，频率从高到低排列（所谓词就是两个相邻的汉字）
	 * @param n
	 * @return
	 */
	public List<String> getTopNWords(int n){
		List<String> res = new ArrayList<>();
		Map<String, Integer>map = new HashMap<>();
		for(int i = 1; i < chapters.length; i++) {
			String text = chapters[i];
			for(int j = 0; j < text.length() - 1; j++){
				if(text.charAt(j) == ' ' || text.charAt(j + 1) == ' ') continue;
				String word = text.substring(j, j + 2);
				if(!map.containsKey(word)) {
					map.put(word, 1);
				} else {
					map.put(word, map.get(word) + 1);
				}
			}
		}
		List<Map.Entry<String, Integer>> sortList = new ArrayList<>(map.entrySet());
		sortList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
		for(int i = 0; i < n; i++) {
			res.add(sortList.get(i).getKey());
		}
		return res;
	}
	/**
	 * 关闭输入输入流
	 * 
	 * @param inout
	 */
	private void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 提示 将红楼梦文本文件拆分为120个章节的方法
	 * 
	 * @param content
	 * @return 返回120个元素的字符串数组
	 */
	private String[] splitContentToChapter(String content) {
		// 提示 使用 content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");正则表达拆分
		// 百度一下正则表达式
		String contents[] = content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");
		return contents;
	}

	 
	/**
	 * 统计红楼梦章节字符串str出现的频率
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public int[] getStringFrequent(String str) throws Exception {
		int[] counts = new int[120];
		for(int i = 1; i < chapters.length; i++) {
			int cnt = 0;
			int len = str.length();
			for(int j = 0; j < chapters[i].length() - len + 1; j++) {
				String temp = chapters[i].substring(j, j + len);
				if(temp.equals(str)) {//利用遍历在每一章中搜索能够匹配的str
					cnt++;
				}
			}
			counts[i - 1] = cnt;
		}
		return counts;
	}
}

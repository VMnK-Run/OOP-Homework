package com.huawei.classroom.student.h11;

import java.util.HashMap;
import java.util.Iterator;

public class Home11 {

	public Home11() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
	 * 请找出   哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
	 * 测试的时候，商品名称可能增加新的商品，例如方便面、面包...
	 * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
	 * @return 哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
	 */
	public String getFrequentItem(String content)  {
		//HashMap的键设置为每两个物品组成的字符串
		HashMap<String, Integer> map = new HashMap<>();
		String res = "";
		String[] str = content.split(";");
		int length = str.length;
		for(int i = 0; i < length; i++) {
			String[] s1 = str[i].split(",");
			for(int j = 0; j < s1.length - 1; j++) {
				for(int k = j + 1; k < s1.length; k++) {
					String comb = s1[j] + "," + s1[k];//两两进行组合
					if(!map.containsKey(comb)) {
						map.put(comb, 1);
					} else {
						map.put(comb, map.get(comb) + 1);
					}
				}
			}
		}
		Iterator it = map.keySet().iterator();//遍历这个map
		int max = 0;
		while(it.hasNext()) {
			String temp = (String) it.next();
			if(max < map.get(temp)) {
				max = map.get(temp);
				res = temp;
			}//找到其中最大的那个
		}
		return res;//返回
	}
}

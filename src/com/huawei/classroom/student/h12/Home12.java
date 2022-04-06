package com.huawei.classroom.student.h12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Home12 {
	public Home12() {
		// TODO Auto-generated constructor stub
	}
	public Set<Set<String>> comb = new HashSet<>();
	/**
	 * @param items, 单次购物小票
	 * @param set 当前选中的集合；
	 * @param n 需要的个数
	 * @param now 当前选中的个数
	 * @param idx 当前搜索下标
	 * 用到了深度优先搜索
	 */
	public void getNItems(String[] items, Set<String> set, int n, int now, int idx) {
		if(now == n) {
			Set<String> newSet = new HashSet<>(set);
			comb.add(newSet);
			return;
		}
		for(int i = idx; i < items.length; i++) {
			set.add(items[i]);
			getNItems(items, set, n, now + 1, i + 1);
			set.remove(items[i]);
		}
	}

	/**
	 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
	 * 请找出   哪n(n>=1)个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回 
	 * 
	 * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
	 * @param n
	 * @return 哪n个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回 
	 *  不会出现并列的情况
	 */
	public Set<String> getFrequentItem(String content,int n)  {
		Set<String> res = new HashSet<>();
		HashMap<Set<String>, Integer> map = new HashMap<>();
		String[] receipt = content.split(";");
		for(int i = 0; i < receipt.length; i++) {
			String[] item = receipt[i].split(",");
			getNItems(item, new HashSet<>(), n, 0, 0);
			Iterator it = comb.iterator();
			while(it.hasNext()) {
				Set<String> temp = (Set<String>) it.next();
				if(!map.containsKey(temp)) {
					map.put(temp, 1);
				} else {
					map.put(temp, map.get(temp) + 1);
				}
			}
		}
		int max = 0;
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			Set<String> temp = (Set<String>) it.next();
			if(max < map.get(temp)) {
				max = map.get(temp);
				res = temp;
			}
		}
		return res;
	}
}

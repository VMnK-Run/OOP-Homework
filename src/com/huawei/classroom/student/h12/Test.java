package com.huawei.classroom.student.h12;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "a,b,c,d,e,f;a,e,b,c,g,k;s,w,q,a,c,b;z,l,m,a";
 		Home12 h=new Home12();
		/**
		 * 
		 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
		 * 请找出   哪n(n>=1)个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回 
		 * 测试的时候，购物次数<100,每次购买的商品数量<10,1<=n<=10
		 */
		Set<String> result = new HashSet<>();
		Set<String> right = new HashSet<>();
		result=h.getFrequentItem(content,3);
		right.add("a");
		right.add("b");
		right.add("c");
		//System.out.println(result);
		if(result.equals(right)) {
			System.out.println("test 1 Passed!");
			//System.out.println("做对了，你真是个小机灵鬼！");
		}else {
			System.out.println(result);
		}

		content = "1,2,3;5,2,1;6,1,2;8,9,7";
		result = h.getFrequentItem(content, 2);
		right = new HashSet<>();
		right.add("1");
		right.add("2");
		if(result.equals(right)) {
			System.out.println("test 2 Passed!");
		} else {
			System.out.println(result);
		}

		content = "9,0,1,2,3,4;2,3,4,8,1,0;1,4,6,2,3,7,8;1,2,3,4,p,q;1,2,3,4,s,w;s,e,r,f,p;7,8,9,0,e";
		result = h.getFrequentItem(content, 4);
		right = new HashSet<>();
		for(int i = 1; i <= 4; i++) {
			right.add(String.valueOf(i));
		}
		if(result.equals(right)) {
			System.out.println("test 3 Passed!");
		} else {
			System.out.println(result);
		}
	}
}

package com.kiramario.test;

public class StringTest {

	public static void main(String[] args) {
		String url =  "http://o2o.hx168.com.cn/m/o2o/article/index.php?code={brokercode}";
		
		System.out.println(url.replace("{brokercode}", "7320"));
		System.out.println(url);
		

	}

}

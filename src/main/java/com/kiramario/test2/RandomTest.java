package com.kiramario.test2;

import java.util.Random;
public class RandomTest {
	static void test(){
		Random r = new Random(2008);
		System.out.println(r.nextInt(3));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
	      test();
	    }
	}

}

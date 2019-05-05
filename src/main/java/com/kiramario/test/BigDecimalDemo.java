package com.kiramario.test;

import java.math.BigInteger;

public class BigDecimalDemo {

	public static void main(String[] args) {
		/*BigInteger bi1 = new BigInteger("45");
		BigInteger bi2 = new BigInteger("16");
		
		BigInteger r = bi1.add(bi2);
		
		System.out.println(r);*/
		
		int s = 0;
		int f = 2;
		
		int r = s/f + (s%f != 0 ? 1 : 0);
		
		System.out.println(r);
	}

}

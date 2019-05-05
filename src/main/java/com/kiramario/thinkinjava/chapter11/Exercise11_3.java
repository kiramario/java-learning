package com.kiramario.thinkinjava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Exercise11_3 {
	
	/*
	 * 1： 	Arrays.asList方法，返回的是Arrays的内部类，继承了AbstractList 类(abstract 类)， 
	 * 		但并没有覆写 add() 方法，所以调用add方法报错
	 * 		Arrays.asList方法返回的collection不可改变长度
	 * 
	 */
	public static void addElementToCollection(){
		Collection<Integer> collection = null;
		collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
//		collection = Arrays.asList(1,2,3,4,5);
		

		Integer[] moreInts = {1,2,3,4,5};
		
		collection.addAll(Arrays.asList(moreInts));
		
		Collections.addAll(collection,1,2,3,4,5);
		Collections.addAll(collection, moreInts);
		
//		System.out.println(collection);
	}
	
	public static void main(String[] args) {
		
		addElementToCollection();
		
		
	}

}

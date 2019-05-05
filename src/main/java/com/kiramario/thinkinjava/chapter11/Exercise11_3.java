package com.kiramario.thinkinjava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Exercise11_3 {
	
	/*
	 * 1�� 	Arrays.asList���������ص���Arrays���ڲ��࣬�̳���AbstractList ��(abstract ��)�� 
	 * 		����û�и�д add() ���������Ե���add��������
	 * 		Arrays.asList�������ص�collection���ɸı䳤��
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

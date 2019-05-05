package com.kiramario.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareableComparator {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,10,9,5,20);
		System.out.println(list);
		
		
		Collections.sort(list,new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				int res = 0;

				res =  (o1 > o2) ? -1 : 1;
				System.out.println("o1 = " + o1 + "; o2 = " + o2 + "; res = " + res); 
				return res;
			}
			
		});
		System.out.println(list);
	}

}

package com.kiramario.multithreading;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class VectorTest {
	//可能会发生边界报错
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		
		Thread t1  = new Thread(new Runnable(){
			@Override
			public void run(){
				for (int i = 0; i < 10; i++) {
				    System.out.println(v.get(i));
				}
			}
		});
		
		Thread t2  = new Thread(new Runnable(){
			@Override
			public void run(){
				for (int i = 0; i < v.size(); i++) {
				    v.remove(i);
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}

}

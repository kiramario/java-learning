package com.kiramario.thinkinjava.chapter11;

import java.util.Arrays;
import java.util.LinkedList;

class SimpleIteration{
	
}

public class Exercise11_7 {

	public static void main(String[] args) {
		LinkedList<Integer> link = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(link);
		System.out.println(link.getFirst());
		System.out.println(link.element());
		
		System.out.println(link.peek());
		System.out.println(link);
		System.out.println(link.remove());
		System.out.println(link);
		System.out.println(link.removeFirst());
		System.out.println(link);
		System.out.println(link.poll());
		System.out.println(link);
		System.out.println(link.add(10));
		System.out.println(link);
		link.addLast(100);
		System.out.println(link);

	}

}

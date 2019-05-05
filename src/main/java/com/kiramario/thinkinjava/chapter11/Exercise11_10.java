package com.kiramario.thinkinjava.chapter11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class QueueDemo{
	public static void printQ(Queue queue) {
		while(queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
}



public class Exercise11_10 {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		
		for(int i = 0; i < 10; i++) {
			queue.offer(rand.nextInt(i + 10));
		}
		QueueDemo.printQ(queue); 
		
		Queue<Character> qc = new LinkedList<Character>();
		for(char c : "kiramario".toCharArray()) {
			qc.offer(c);
		}
		QueueDemo.printQ(qc); 
		System.out.println(qc);
		
		System.out.println("=======priority queue=========");
		
		PriorityQueue<Integer> priority1 = new PriorityQueue<Integer>();
		Random r1 = new Random(47);
		for(int i = 0; i < 10; i++) {
			priority1.offer(r1.nextInt(i + 10));
		}
		QueueDemo.printQ(priority1); 
		List<Integer> list1 = Arrays.asList(10,9,5,20);
		priority1 = new PriorityQueue<Integer>(list1);
		System.out.println(list1);
		System.out.println(priority1);
		
		priority1 = new PriorityQueue<Integer>(list1.size(),Collections.reverseOrder());
		priority1.addAll(list1);
		System.out.println(priority1);
	}

}

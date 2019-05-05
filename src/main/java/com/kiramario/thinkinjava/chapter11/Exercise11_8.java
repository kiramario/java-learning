package com.kiramario.thinkinjava.chapter11;

import java.util.LinkedList;
import java.util.Set;

class Stack<T>{
	private LinkedList<T> storage = new LinkedList<T>();
	public void push(T v) {storage.addFirst(v);}
	public T pop() {return storage.poll();}
	public T peek() {return storage.getFirst();}
	public boolean isEmpty() {
		return storage.isEmpty();
	}
	public String toString() {
		return storage.toString();
	}
	
}


public class Exercise11_8 {

	public static void main(String[] args) {
		Stack<Integer> sta = new Stack<Integer>();
		sta.push(1);
		sta.push(2);
		
		System.out.println(sta);
		
		System.out.println(sta.pop());
		
		System.out.println(sta);
		

	}

}

package com.kiramario.thinkinjava.chapter11;



class Apple{
	private static long counter;
	private final long id = ++counter;
	public long getId(){return id;}
}
public class NormarlExercise {
	public static void main(String[] args){
		/* *********
		//对某个东西计数，还蛮方便
		//TODO 试下多线程
		Apple a1 = new Apple();
		System.out.println(a1.getId());
		Apple a2 = new Apple();
		System.out.println(a2.getId());
		* ***********/
		
		
		
	}
}

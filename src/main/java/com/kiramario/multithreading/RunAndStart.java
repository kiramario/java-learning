package com.kiramario.multithreading;

class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName() + " is running");
	}
}

public class RunAndStart extends Thread{
	
	public static void main(String[] args){
		Thread mythread = new MyThread("m-1");
		System.out.println(Thread.currentThread().getName()+" is running");
		mythread.run();
		
		System.out.println(Thread.currentThread().getName()+" is running");
		mythread.start();
	}
	
}

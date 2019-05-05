package com.kiramario.multithreading;

public class NotifyallTest {
	 private static Object obj = new Object();
	 
	static class Thread3 extends Thread{
		
		public Thread3(String name){
			super(name);
		}
		
		public void run(){
			synchronized(obj){
				 try {
					// 打印输出结果
					 Thread.sleep(1000);
					 System.out.println(Thread.currentThread().getName() + " wait");
					// 唤醒当前的wait线程
					 obj.wait();
					// 打印输出结果
					 System.out.println(Thread.currentThread().getName() + " continue");
				 }catch(InterruptedException e){
					 
				 }
				
			}
		}
	}
	
	public static void main(String[] args) {
		Thread3 t1 = new Thread3("t1");
		Thread3 t2 = new Thread3("t2");
		Thread3 t3 = new Thread3("t3");
		t1.start();
		t2.start();
		t3.start();
		
		try {
			System.out.println(Thread.currentThread().getName()+" sleep(3000)");
			Thread.sleep(3000);
		}catch(InterruptedException e){}
		
		synchronized(obj){
			System.out.println(Thread.currentThread().getName()+" notifyAll()");
			obj.notifyAll();
		}
	}

}

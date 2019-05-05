package com.kiramario.multithreading;


class Count {
	public void synMethod(){
		synchronized(this){
			try{
				for(int i = 0; i < 5; i ++){
					 Thread.sleep(1000); // 休眠100ms
					 System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);  
				}
			}catch(InterruptedException e){}
		}
	}
	
	public void nonsynMethod(){
		try{
			for(int i = 0; i < 5; i ++){
				 Thread.sleep(1000); // 休眠100ms
				 System.out.println(Thread.currentThread().getName() + " nonsynMethod loop " + i);  
			}
		}catch(InterruptedException e){}
		
	}
	
	public void synMethod2(){
		synchronized(this){
			try{
				for(int i = 0; i < 5; i ++){
					 Thread.sleep(1000); // 休眠100ms
					 System.out.println(Thread.currentThread().getName() + " synMethod2 loop " + i);  
				}
			}catch(InterruptedException e){}
		}
		
		
	}
}


public class SynchronizedDemo2 {
	
	
	public static void main(String[] args){
		final Count count = new Count();
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				count.synMethod();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				count.nonsynMethod();
//				count.synMethod2();
			}
		},"t2");
		
		t1.setPriority(1);                // 设置t1的优先级为1
		t2.setPriority(10);                // 设置t2的优先级为10
		
		t1.start();
		t2.start();
	}
}

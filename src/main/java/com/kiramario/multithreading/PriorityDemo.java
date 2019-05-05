package com.kiramario.multithreading;

public class PriorityDemo {
	
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName()
				+"("+Thread.currentThread().getPriority()+ ")");
		
		Thread5 t1=new Thread5("t1");    // 新建t1
		Thread5 t2=new Thread5("t2");    // 新建t2
		
		t1.setPriority(1);                // 设置t1的优先级为1
		t2.setPriority(10);                // 设置t2的优先级为10
		
		t1.start();                        // 启动t1
		t2.start();                        // 启动t2
	}
}


class Thread5 extends Thread{
	public Thread5(String name){
		super(name);
	}
	
	public void run(){
		 for (int i=0; i<5; i++) {
			 System.out.println(Thread.currentThread().getName()
					 +"("+Thread.currentThread().getPriority()+ ")"
					 +", loop "+i);
		 }
	}
}
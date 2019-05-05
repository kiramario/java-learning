package com.kiramario.multithreading;

public class PriorityDemo {
	
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName()
				+"("+Thread.currentThread().getPriority()+ ")");
		
		Thread5 t1=new Thread5("t1");    // �½�t1
		Thread5 t2=new Thread5("t2");    // �½�t2
		
		t1.setPriority(1);                // ����t1�����ȼ�Ϊ1
		t2.setPriority(10);                // ����t2�����ȼ�Ϊ10
		
		t1.start();                        // ����t1
		t2.start();                        // ����t2
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
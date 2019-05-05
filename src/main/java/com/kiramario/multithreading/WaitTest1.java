package com.kiramario.multithreading;

class T{
	
}
class Thread2 extends Thread{
	public Thread2(String name){
		super(name);
	}
	
	public void run(){
		synchronized(this){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" call notify()");
			// ���ѵ�ǰ��wait�߳�
			notify();
		}
	}
	/*
	public void run(){
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" call notify()");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}

public class WaitTest1 {
	
	
	public static void main(String[] args){
		Thread2 t = new Thread2("t1");
		synchronized(t) {
			try{
				// �������߳�t1��
	            System.out.println(Thread.currentThread().getName()+" start t");
	            t.start();
	            
	            // ���̵߳ȴ�t1ͨ��notify()���ѡ�
	            System.out.println(Thread.currentThread().getName()+" wait()");
	            t.wait();
	            System.out.println(Thread.currentThread().getName()+" continue");
			}catch(InterruptedException  e){e.printStackTrace();}
		}
		
	}
}

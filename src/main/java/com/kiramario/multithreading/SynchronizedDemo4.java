package com.kiramario.multithreading;



class Something{
	public synchronized void isSyncA(){
		try{
			for(int i = 0; i < 5; i++){
				Thread.sleep(1000);
				 System.out.println(Thread.currentThread().getName()+" : isSyncA");
			}
		}catch(InterruptedException e){}
	}
	
	public synchronized void isSyncB(){
		try{
			for(int i = 0; i < 5; i++){
				Thread.sleep(1000);
				 System.out.println(Thread.currentThread().getName()+" : isSyncB");
			}
		}catch(InterruptedException e){}
	}
	
	public static synchronized void cSyncA(){
		try{
			for(int i = 0; i < 5; i++){
				Thread.sleep(1000);
				 System.out.println(Thread.currentThread().getName()+" : cSyncA");
			}
		}catch(InterruptedException e){}
	}
	
	public static synchronized void cSyncB(){
		try{
			for(int i = 0; i < 5; i++){
				Thread.sleep(1000);
				 System.out.println(Thread.currentThread().getName()+" : cSyncB");
			}
		}catch(InterruptedException e){}
	}
}


public class SynchronizedDemo4 {
	Something x = new Something();
	Something y = new Something();
	
	public void test1(){
		Thread t1 = new Thread(
				new Runnable(){
					@Override
					public void run(){
						y.cSyncB();
					}
				},"t1"
		);
		
		Thread t2 = new Thread(
				new Runnable(){
					@Override
					public void run(){
						x.cSyncA();
					}
				},"t2"
		);
		
		t1.start();
		t2.start();
	}
	public static void main(String[] args) {
		SynchronizedDemo4 d = new SynchronizedDemo4();
		d.test1();
	}
	
}

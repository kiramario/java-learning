package com.kiramario.multithreading;

import java.util.concurrent.TimeUnit;

public class LockTest1 {

	public static void main(String[] args) {
		Count2 c = new Count2();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				
				try {
					c.print();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					c.print();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t2");
		
		t1.start();
		t2.start();
	}

}

class Count2{
	Lock2 lock2 = new Lock2();
	public void print() throws InterruptedException{
		lock2.lock();
		doAdd();
		lock2.unlock();
	}
	
	public void doAdd() throws InterruptedException{
		lock2.lock();
		System.out.println(Thread.currentThread().getName() + " do add");
		TimeUnit.SECONDS.sleep(2);
		lock2.unlock();
	}
}


class Lock2{
	boolean isLocked = false;
	Thread isLockedBy = null;
	int lockedCount = 0;
	
	public synchronized void lock() throws InterruptedException{
		Thread thread = Thread.currentThread();
		while(isLocked && isLockedBy != thread){
			wait();
		}
		
		isLocked = true;
		lockedCount++;
		isLockedBy = thread;
	}
	
	public synchronized void unlock() throws InterruptedException{
		if(Thread.currentThread() == isLockedBy){
			lockedCount--;
			if(lockedCount == 0){
				isLocked = false;
				notify();
			}
		}
	}
}
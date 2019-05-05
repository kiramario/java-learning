package com.kiramario.multithreading;

import java.util.concurrent.TimeUnit;

public class WaitNotifyTest1 {
	
	public void test1() throws InterruptedException{
		final Object lock = new Object();
		new Thread(new NotifyTest(lock,1)).start();
		new Thread(new NotifyTest(lock,2)).start();
		
		TimeUnit.SECONDS.sleep(2);
		synchronized(lock){
			lock.notifyAll();
		}
	}
	
	public void test2() throws InterruptedException{
		final Object lock = new Object();
		 new Thread(new PrintAB(lock,'A')).start();
         new Thread(new PrintAB(lock,'B')).start();
	}
	
	public static void main(String[] args) throws InterruptedException {
		WaitNotifyTest1 test = new WaitNotifyTest1();
		
		
//		test.test1();
		
		test.test2();
	}

}


class NotifyTest implements Runnable {
	private Object lock;
	private int num;
	public NotifyTest(Object lock, int num){
		this.lock = lock;
		this.num = num;
	}
	
	@Override
	public void run() {
		synchronized(lock){
			try{
				lock.wait();
				System.out.println("----" + num);
			}catch(InterruptedException e){
				
			}
		}
	}
	
}



class PrintAB implements Runnable{
	private Object lock;
	private char ch;
	public PrintAB(Object lock, char ch){
		this.lock = lock;
		this.ch = ch;
	}
	@Override
	public void run() {
		while(true){
			synchronized(lock){
				try{
					/**
                     * 第一次执行并不会唤醒任何线程，
                     * 第二次以及以后就会唤醒另外一个线程获取Monitor锁，因为只有一个线程挂起
                     * 而notify() 就是唤醒一个线程
                     */
					lock.notify();
					System.out.println(Thread.currentThread().getName()+":"+ch);
					/**
                     * synchronized 代码块执行完毕之后才会交出Monitor锁，别的线程才有执行机会
                     * wait 执行过之后当前线程就挂起了,然后释放锁，接着已经被操作系统notify
                     * 的线程获取Monitor 开始执行
                     */
                    lock.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
}





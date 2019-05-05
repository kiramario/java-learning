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
                     * ��һ��ִ�в����ỽ���κ��̣߳�
                     * �ڶ����Լ��Ժ�ͻỽ������һ���̻߳�ȡMonitor������Ϊֻ��һ���̹߳���
                     * ��notify() ���ǻ���һ���߳�
                     */
					lock.notify();
					System.out.println(Thread.currentThread().getName()+":"+ch);
					/**
                     * synchronized �����ִ�����֮��Żύ��Monitor��������̲߳���ִ�л���
                     * wait ִ�й�֮��ǰ�߳̾͹�����,Ȼ���ͷ����������Ѿ�������ϵͳnotify
                     * ���̻߳�ȡMonitor ��ʼִ��
                     */
                    lock.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
}





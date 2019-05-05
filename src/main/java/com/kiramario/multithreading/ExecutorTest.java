package com.kiramario.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	public static void main(String[] args) {
		/*
		 * �̳߳�Ϊ���޴󣬵�ִ�еڶ�������ʱ��һ�������Ѿ���ɣ��Ḵ��ִ�е�һ��������̣߳�������ÿ���½��̡߳�
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++){
			final int index = i;
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
			cachedThreadPool.execute(new Runnable(){
				@Override
				public void run(){
					System.out.println(index);
				}
			});
		}*/
		
		
		
		/*
		 * ��Ϊ�̳߳ش�СΪ3��ÿ���������index��sleep 2�룬����ÿ�����ӡ3�����֡�
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 10; i++){
			final int index = i;
			
			fixedThreadPool.execute(new Runnable(){
				@Override
				public void run(){
					System.out.println(index);
					try{
						Thread.sleep(2000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			});
		}*/

		/*
		 * ��ʾ�ӳ�3��ִ�С�
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable(){
			@Override
			public void run(){
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);*/
		
		// System.out.println(TimeUnit.SECONDS.toHours(3605));
		
		/*
		 * ��ʾ�ӳ�1���ÿ3��ִ��һ�Ρ�
		 * ScheduledExecutorService��Timer����ȫ�����ܸ�ǿ�󣬺������һƪ�������жԱȡ�
		 * 
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName() + "; delay 1 seconds, and excute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);
		System.out.println(Thread.currentThread().getName());*/
		
	
		//�������������൱��˳��ִ�и�������	
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 10; i++){
			final int index = i;
			singleThreadExecutor.execute(new Runnable(){
				@Override
				public void run(){
					try{
						System.out.println(index + "| " + Thread.currentThread().getName());
						Thread.sleep(2000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			});
		}

		
		System.out.println("good");
		
		
	}
	
}

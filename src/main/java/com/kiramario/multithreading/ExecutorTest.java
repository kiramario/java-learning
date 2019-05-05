package com.kiramario.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	public static void main(String[] args) {
		/*
		 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
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
		 * 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
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
		 * 表示延迟3秒执行。
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable(){
			@Override
			public void run(){
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);*/
		
		// System.out.println(TimeUnit.SECONDS.toHours(3605));
		
		/*
		 * 表示延迟1秒后每3秒执行一次。
		 * ScheduledExecutorService比Timer更安全，功能更强大，后面会有一篇单独进行对比。
		 * 
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName() + "; delay 1 seconds, and excute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);
		System.out.println(Thread.currentThread().getName());*/
		
	
		//结果依次输出，相当于顺序执行各个任务。	
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

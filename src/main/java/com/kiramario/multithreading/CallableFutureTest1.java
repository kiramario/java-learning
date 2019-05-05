package com.kiramario.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureTest1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Callable<Integer> call = new Callable<Integer>(){
			@Override
			public Integer call() throws Exception {
                System.out.println("计算线程正在计算结果...");
                Thread.sleep(3000);
                return 1;
			}	
		};
		
		FutureTask<Integer> ft = new FutureTask<Integer>(call);
		
		Thread thread = new Thread(ft);
		thread.start();
		System.out.println("main线程干点别的...");
		
		Integer result = ft.get();
		System.out.println("从计算线程拿到的结果为：" + result);

	}
	
	

}

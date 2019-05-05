package com.kiramario.multithreading;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}


class Storage1 implements AbstractStorage{
	//仓库最大容量
	private final int MAX_SIZE = 100;
	//仓库存储的载体
	private LinkedList list = new LinkedList();

	@Override
	//消费产品
	public void consume(int num) {
		synchronized(list){
			while(num > list.size()){
				System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"  + list.size() + "\t暂时不能执行生产任务!");
				try{
					list.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
			for(int i = 0; i < num; i++){
				list.remove();
			}
			System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
			list.notifyAll();
		}
		
		
	}

	@Override
	//生产产品
	public void produce(int num) {
		//同步
		synchronized(list){
			while(list.size() + num > MAX_SIZE){
				System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行生产任务!");
				
				try{
					list.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
			for(int i = 0; i < num; i++){
				list.add(new Object());
			}
			
			System.out.println(Thread.currentThread().getName() + "【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
			list.notifyAll();
		}
		
		
	}
	
}


class Producer extends Thread{
	//每次生产的数量
	private int num;
	
	//所属的仓库
	public AbstractStorage abstractStorage;
	
	public Producer(AbstractStorage abstractStorage){
		this.abstractStorage = abstractStorage;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	@Override
	public void run(){
		produce(num);
	}
	
	void produce(int num){
		abstractStorage.produce(num);
	}
}



class Consumer extends Thread{
	//每次生产的数量
	private int num;
	
	//所属的仓库
	public AbstractStorage abstractStorage;
	
	public Consumer(AbstractStorage abstractStorage){
		this.abstractStorage = abstractStorage;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	@Override
	public void run(){
		consume(num);
	}
	
	void consume(int num){
		abstractStorage.consume(num);
	}
}
public class ProductAndConsumTest1 {

	public static void main(String[] args) throws InterruptedException {
		AbstractStorage abstractStorage = new Storage1();
		
		//生成者
		Producer p1 = new Producer(abstractStorage);
		p1.setNum(10);
		p1.setName("p1");
		Producer p2 = new Producer(abstractStorage);
		p2.setNum(10);
		p2.setName("p2");
		Producer p3 = new Producer(abstractStorage);
		p3.setNum(10);
		p3.setName("p3");
		Producer p4 = new Producer(abstractStorage);
		p4.setNum(10);
		p4.setName("p4");
		
		//消费者
		Consumer c1 = new Consumer(abstractStorage);
		c1.setNum(20);
		Consumer c2 = new Consumer(abstractStorage);
		c2.setNum(20);
		
		
		// 线程开始执行
		c1.start();
		c2.start();
		
		TimeUnit.SECONDS.sleep(2);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
	}

}



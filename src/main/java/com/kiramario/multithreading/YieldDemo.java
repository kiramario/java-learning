package com.kiramario.multithreading;

public class YieldDemo {
	private static Object obj = new Object();
	 
	public static void main(String[] args) {
		/*Thread3 t1 = new Thread3("t1");
		Thread3 t2 = new Thread3("t2");
		
		t1.start();
		t2.start();*/
		
		Thread4 t1 = new Thread4("t1");
		Thread4 t2 = new Thread4("t2");
		
		t1.start();
		t2.start();

	}
	
	static class Thread4 extends Thread{
		public Thread4(String name){
			super(name);
		}
		
		public void run(){
			synchronized(obj){
				for(int i = 0; i < 10; i++){
					System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i); 
					if (i%4 == 0)
						Thread.yield();
				}
			}
			
		}
	}

}


class Thread3 extends Thread{
	public Thread3(String name){
		super(name);
	}
	
	public synchronized void run(){
		for(int i = 0; i < 10; i++){
			System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i); 
			if (i%4 == 0)
				Thread.yield();
		}
	}
}
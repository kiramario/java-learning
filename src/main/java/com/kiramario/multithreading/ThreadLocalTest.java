package com.kiramario.multithreading;

public class ThreadLocalTest {
	
	static class ResourceClass {
		public final static ThreadLocal<String> R1 = new ThreadLocal<String>();
		public final static ThreadLocal<String> R2 = new ThreadLocal<String>();
	}
	
	static class A{
		public void setOne(String value){
			ResourceClass.R1.set(value);
		}
		
		public void setTwo(String value){
			ResourceClass.R2.set(value);
		}
	}
	
	static class B{
		public void display(){
			System.out.println(ResourceClass.R1.get() + ": " + ResourceClass.R2.get());
		}
	}
	
	
	public static void main(String[] args) {
		final A a = new A();
		final B b = new B();
		
		for(int i = 0; i < 5; i++){
			final String resource1 = "Ïß³Ì-" + i;
			final String resource2 = "value = " + i;
			
			new Thread(){
				public void run(){
					try{
						a.setOne(resource1);
						a.setTwo(resource2);
						b.display();
					}finally{
						/*ResourceClass.R1.remove();
						ResourceClass.R2.remove();*/
					}
				}
			}.start();
		}

	}

}

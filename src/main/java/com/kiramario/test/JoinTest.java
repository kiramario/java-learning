package com.kiramario.test;

public class JoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Parent p = new Parent();
//		p.start();
		System.out.println(System.getProperty("java.io.tmpdir"));
	}
	
	

}

class Parent extends Thread{
	public void run(){
		System.out.println("parent run");
		Children child = new Children();
		child .start();
		try {
			child .join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("parent run over");
	}
}

class Children extends Thread{
	public void run(){
		System.out.println("children run");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("children run over");
	}
}
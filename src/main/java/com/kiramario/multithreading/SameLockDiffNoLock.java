package com.kiramario.multithreading;

public class SameLockDiffNoLock {
	private static EnoLock[] lockArray = new EnoLock[2];
	
	private static void doLockThings(String eno){
		EnoLock lock = null;
		if(eno.equals("123")){
			lock = lockArray[0];
		}else{
			lock = lockArray[1];
		}
		synchronized(lock){
			System.out.println(eno + " do things");
			try{Thread.sleep(3000);}catch(Exception e){e.printStackTrace();}
			System.out.println(eno + " do things over");
		}
	}
	
	public static void main(String[] args) {
		String eno1 = "123";
		String eno2 = "456";
		
		
		EnoLock lock1 = new EnoLock(eno1);
		EnoLock lock2 = new EnoLock(eno2);
		
		lockArray[0] = lock1;
		lockArray[1] = lock2;
		
		Thread t1 = new Thread(new Runnable(){
			@Override public void run(){ doLockThings(eno1); }
		});
		Thread t2 = new Thread(new Runnable(){
			@Override public void run(){ doLockThings(eno1); }
		});
		Thread t3 = new Thread(new Runnable(){
			@Override public void run(){ doLockThings(eno2); }
		});
		Thread t4 = new Thread(new Runnable(){
			@Override public void run(){ doLockThings(eno2); }
		});
		
		t1.start();t2.start();t3.start();t4.start();

	}

}


class EnoLock{
	private String eno = "";
	public EnoLock(String eno){
		this.eno = eno;
	}
}



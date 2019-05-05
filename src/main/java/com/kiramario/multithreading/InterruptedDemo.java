package com.kiramario.multithreading;

public class InterruptedDemo {

	public static void main(String[] args) {
		try{
			Thread4 t1 = new Thread4("t1");
			System.out.println(t1.getName() +" ("+t1.getState()+") is new.");
			
			t1.start();
			System.out.println(t1.getName() +" ("+t1.getState()+") is started.");  
			
			// ���߳�����300ms��Ȼ�����̸߳�t1�����жϡ�ָ�
			Thread.sleep(300);
			t1.interrupt();
			System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");
			
			// ���߳�����300ms��Ȼ��鿴t1��״̬��
			Thread.sleep(300);
			System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
			
		}catch(InterruptedException e){}
		
	}

}


class Thread4 extends Thread{
	public Thread4(String name){
		super(name);
	}
	
	@Override
	public void run(){
		try{
			int i = 0;
			while (!isInterrupted()) {
				Thread.sleep(100); // ����100ms
				i++;
				System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i); 
			}
		}catch(InterruptedException e){
			 System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");  
		}
	}
}
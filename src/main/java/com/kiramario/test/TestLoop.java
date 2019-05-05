package com.kiramario.test;

import java.util.UUID;

public class TestLoop {

	public void r1(int i){
		if(i==5){
			return;
		}
		System.out.println("god" + i);
	}
	
	public void do1(){
		for(int i = 0; i <10; i++){
			r1(i);
		}
	}
	
	public static void main(String[] args){
		TestLoop t = new TestLoop();
		t.do1();
		
	}
}

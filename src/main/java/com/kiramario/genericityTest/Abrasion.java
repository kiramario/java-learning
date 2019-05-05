package com.kiramario.genericityTest;

import java.util.ArrayList;

public class Abrasion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class a = new ArrayList<String>().getClass();
		Class b = new ArrayList<Integer>().getClass();
		System.out.println(a==b);
		
		Hello h = new Hello();
		TestHello<Hello> th = new TestHello<Hello>(h);
		th.callHello();
	}

}


class Hello{
	public void hello(){
		System.out.println("say hello");
	}
}

class TestHello<T>{
	private T t;
	public TestHello(T t){
		this.t = t;
	}
	public void callHello(){
//		t.hello();
	}
}
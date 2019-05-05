package com.kiramario.test2;

public class SingleTonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Singleton1{
	private static Singleton1 single = new Singleton1();
	private Singleton1() {}
	public static Singleton1 getSingleton(){
		return single;
	}
	
}

class Singleton2{
	private static Singleton2 single = null;
	private Singleton2(){}
	public static Singleton2 getSingleton(){
		if(single == null){
			single = new Singleton2();
		}
		return single;
	}
}

class Singleton3{
	private static class Holder{
		private static Singleton3 single = new Singleton3();
	}
	
	private Singleton3(){};
	
	public static Singleton3 getSingleton(){
		return Holder.single;
	}
}


enum Singleton4{
	INSTANCE;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}



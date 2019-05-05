package com.kiramario.test;

//https://www.cnblogs.com/jimxz/p/3974939.html


class Insect {
	private int i = 9;
	protected int j;
	
	protected static int x1 = printInit("static insect.x1 init");
	
	Insect(){
		System.out.println("基类构造函数阶段： i = " + i + ", j = " + j);
		j = 39;
	}
	
	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}

class Beetle extends Insect {
	protected int k = printInit("Beetle.k initialized");
	protected static int x2 = printInit("static Beetle.x2 initialized");    
	
	Beetle(){
		System.out.println(1);
	}
	
}


class Base{
	Base(){
		System.out.println("do father constructor");
		preProcess();
	}
	
	void preProcess() {
		System.out.println("do father preProcess");
	}
}

class Derived extends Base{
	public String whenAmIset = "set when declare";
	
	public Derived() {
		
        System.out.println("do son constructor");
        
    }
	
//	@Override
	void preProcess() {
		System.out.println("do son process");
        System.out.println("whenAmISet:" + whenAmIset);
		whenAmIset = "set in preProcess";
		System.out.println("whenAmISet:" + whenAmIset);
        System.out.println("set in preProcess end");
	}
}


public class ClassInitOrder2 {

	public static void main(String[] args) {
		Beetle b = new Beetle();
		
//		Derived d = new Derived();
//        System.out.println(d.whenAmIset);
        
	}

}

package com.kiramario.genericityTest;

public class TestBorder<T extends Dog & Cat & Pig> {
	T t;
	
	public TestBorder(T t){
		this.t = t;
	}
	
	public void test(){
		t.eat();
		t.shout();
		t.run();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//extends 后面跟的第一个边界，可以为类或接口，之后的均为接口。
	}

}


interface Dog{
    void shout();
}

interface Cat{
    void run();
}

interface Pig{
    void eat();
}
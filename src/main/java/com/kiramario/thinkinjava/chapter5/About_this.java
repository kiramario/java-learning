package com.kiramario.thinkinjava.chapter5;

public class About_this {
	int i = 0;
	
	About_this increment(int i){
		this.i += i;
		return this;
	}
	public static void main(String[] args) throws InterruptedException{
		System.out.println(21212);
		About_this a = new About_this();
		
		
		a.increment(11).increment(123);
		System.out.println(a.i);
		
		new Person().eat(new Apple());
		
		Flower x = new Flower();
		x.printPetalCount();
		
		Book nov = new Book(true);
		nov.checkIn();
		
		new Book(true);
		Thread.sleep(5000);
		System.gc();
	};
	
}


class Person{
	public void eat(Apple apple){
		Apple peeled = apple.getPeeled();
		System.out.println("yumm");
	}
}

class Apple{
	Apple getPeeled(){
		return Peeler.peel(this);
	}
}

class Peeler{
	static Apple peel(Apple apple){
		return apple;
	}
}


class Flower{
	int petalCount = 0;
	String s = "init value";
	Flower(int petal){
		petalCount = petal;
		System.out.println("Flower(int petal): " + petalCount);
	}
	Flower(String s){
		this.s = s;
		System.out.println("Flower(String s): " + this.s);
	}
	Flower(String s, int petal){
		this(petal);
		this.s =s;
		System.out.println("String s, int petal: " + this.s);
	}
	Flower(){
		this("hi",47);
		System.out.println("Flower()");
	}
	
	void printPetalCount(){
		//	this(11);  不能写在非构造函数中
		System.out.println("petalcount=" + petalCount + "; s=" + this.s);
	}
}

class Book{
	boolean checkedOut = false;
	Book(boolean checkout){
		checkedOut = checkout;
	}
	void checkIn(){
		checkedOut = false;
	}
	
	@Override
	protected void finalize() throws Throwable{
		//super.finalize();
		if(checkedOut){
			System.out.println("error: checkout");
		}
	}
}
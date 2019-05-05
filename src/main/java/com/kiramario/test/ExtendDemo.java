package com.kiramario.test;

import java.util.ArrayList;
import java.util.List;

public class ExtendDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Extend_c1 c = new Extend_c2();
		c.check();
		System.out.println(c.name);
		System.out.println(c.getName());
		
		
	}

}

interface Extend_c{
	public void check();
}


class Extend_c1 implements Extend_c{
	private List list = new ArrayList<String>();
	String name = "Extend_c1";
	
	public Extend_c1(){
		System.out.println("i am Extend_c1");
		System.out.println(list);
	}
	protected Extend_c1 addList(String name){
		list.add(name);
		return this;
	}
	
	public void check() {
		System.out.println(this.list);
	}
	
	public String getName(){
		return name;
	}
}

class Extend_c2 extends Extend_c1{
	String name = "Extend_c2";
	
	public Extend_c2(){
		this.addList("kiramario");
		this.addList("zhangyang");
	}
	
	public String getName(){
		return name;
	}
}
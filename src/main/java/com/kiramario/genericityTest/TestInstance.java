package com.kiramario.genericityTest;

import java.lang.reflect.Array;

public class TestInstance <T>{
	private Class<T> t;
	public TestInstance(Class<T> t){
		this.t = t;
	}
	
	public boolean compare(Object obj){
		return t.isInstance(obj);
	}
	
	@SuppressWarnings("unchecked")
	T[] create(int size){
		return (T[]) Array.newInstance(t, size);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInstance<A> ti = new TestInstance<A>(A.class);
		System.out.println(ti.compare(new A()));
		System.out.println(ti.compare(new B()));
		
		
		A[] as = ti.create(10);
		System.out.println(as.length);
	}

}


class A{}
class B extends A{}



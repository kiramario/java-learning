package com.kiramario.test2;

public class Lunch{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		serviceConsumer(new Implemention1());
		serviceConsumer(new Implemention2());
	}
	
	public static void serviceConsumer(Service fact){

		fact.method1();
		fact.method2();
	}
}



interface Service{
	void method1();
	void method2();
}

interface ServiceFactory{
	Service getService();
}

class Implemention1 implements Service{
	@Override
	public void method1(){System.out.println("Implemention1 method1");}
	@Override
	public void method2(){System.out.println("Implemention1 method2");}
}

class Implemention1Factory implements ServiceFactory{
	@Override
	public Service getService(){
		return new Implemention1();
	}
}

class Implemention2 implements Service{
	@Override
	public void method1(){System.out.println("Implemention2 method1");}
	@Override
	public void method2(){System.out.println("Implemention2 method2");}
}

class Implemention2Factory implements ServiceFactory{
	@Override
	public Service getService(){
		return new Implemention2();
	}
}


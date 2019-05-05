package com.kiramario.thinkinjava.chapter5;

import java.util.Random;

public class About_init {
	
	public static void main(String[] args){
/*		System.out.println(new MethodInit3().i);
		System.out.println(new MethodInit3().j);
		
		House h = new House();
		h.f();
		System.gc();*/
		
		
		/*System.out.println("creating cupboard in main");
		new Capboard();
		System.out.println("creating cupboard in main");
		new Capboard();
		table.f2(1);
		capboard.f3(1);*/
		
		/*System.out.println("inside main()");
		Cups.cup1.f(99);*/
		
		/*System.out.println("inside main()");
		new Mugs();
		System.out.println("new Mugs completed");
		new Mugs(1);
		System.out.println("new Mugs(1) completed");*/
		
		
		/*ArrayNew a = new ArrayNew();
		a.arraytest();*/
		
//		new NewVarArgs().varargs(1,2,3,4,"dfe","fefe",'a');
		new NewVarArgs().varargs(new Integer[]{1,2,3,4});
		
	}
	/*static Table table = new Table();
	static Capboard capboard = new Capboard();*/
	
	/*static Cups cups1 = new Cups();
	static Cups cups2 = new Cups();*/
}


class MethodInit3{
	int i = f();
	int j = g(i);
	int f(){return 11;}
	int g(int n){return n * 10;}
}

class Window{
	private int marker;
	Window(int marker){this.marker = marker;System.out.println("WINDOW(" + marker + ")");}
	@Override
	protected void finalize(){
		System.out.println("finalize: " + marker);
	}
}

class House{
	Window w1 = new Window(1);
	House(){
		System.out.println("House");
		w3 = new Window(33);
	}
	Window w2 = new Window(2);
	void f(){System.out.println("f();");}
	Window w3 = new Window(3);
	
}


class Bowl{
	Bowl(int i){
		System.out.println("Bowl(" + i + ")");
	}
	void f1(int i){
		System.out.println("f1(" + i + ")");
	}
}


class Table{
	static Bowl bowl = new Bowl(1);
	Table(){
		System.out.println("Table()" );
		bowl2.f1(1);
	}
	void f2(int i){
		System.out.println("f2(" + i + ")");
	}
	static Bowl bowl2 = new Bowl(2);
}


class Capboard{
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	Capboard(){
		System.out.println("Capboard" );
		bowl4.f1(2);
	}
	void f3(int i){
		System.out.println("f3(" + i + ")");
	}
	static Bowl bowl5 = new Bowl(5);
}


class Spoon{
	static {
		int i = 47;
	}
}




class Cup{
	Cup(int i){
		System.out.println("Cup(" + i + ")");
	}
	void f(int i){
		System.out.println("f(" + i + ")");
	}
}
class Cups{
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	Cups(){
		System.out.println("Cups()");
	}
}


class Mug{
	Mug(int marker){
		System.out.println("Mug(" + marker + ")");
	}
	void f(int i){
		System.out.println("f(" + i + ")");
	}
}

class Mugs{
	Mug mug1;
	Mug mug2;
	{
		mug1 = new Mug(1);
		mug2 = new Mug(2);
		System.out.println("mug1 mug2 initialize)");
	}
	Mugs(){
		System.out.println("Mugs()");
	}
	Mugs(int i){
		System.out.println("Mugs(int)");
	}
}

class ArrayNew{
	public void arraytest(){
		Random rand = new Random(47);
		for(int i = 0; i < 12; i++){
			System.out.println(rand.nextInt(20));
		}
	}
}

class NewVarArgs{
	void varargs(Object... args){
		for(Object arg : args){
			System.out.println(arg);
		}
	}
}



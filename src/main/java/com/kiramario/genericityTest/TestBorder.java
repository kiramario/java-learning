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
		//extends ������ĵ�һ���߽磬����Ϊ���ӿڣ�֮��ľ�Ϊ�ӿڡ�
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
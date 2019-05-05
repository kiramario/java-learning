package com.kiramario.genericityTest;

public class TestNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Product(new ProductFactory());
	}

}


interface Factory<T>{
	T create();
}

class Product<T>{
	public <F extends Factory<T>> Product(F factory){
		factory.create();
	}
}

class ProductFactory implements Factory<Integer>{

	@Override
	public Integer create() {
		Integer integer = new Integer(10);
		System.out.println(integer);
		return null;
	}
	
}
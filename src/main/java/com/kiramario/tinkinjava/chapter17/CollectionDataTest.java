package com.kiramario.tinkinjava.chapter17;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * 解决容器的填充问题
 * 也可以用Collections填充，也可以用这些方法
 */
public class CollectionDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new LinkedHashSet<String>(
					new CollectionData<String>(new Government(),3)
				);
		System.out.println(set);
		set.addAll(CollectionData.list(new Government(),3));
		System.out.println(set);
	}

}


class Government implements Generator<String>{
	String[] founcation = ("Human should have courage for seeking truth").split(" ");
	private int index;
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return founcation[index++];
	}
	
}

class CollectionData<T> extends ArrayList<T>{
	public CollectionData(Generator<T> gen, int quantity){
		for(int i = 0; i < quantity; i++){
			add(gen.next());
		}
	}
	
	public static <T> CollectionData<T> list(Generator<T> gen,int quantity){
		return new CollectionData(gen,quantity);
	}
}
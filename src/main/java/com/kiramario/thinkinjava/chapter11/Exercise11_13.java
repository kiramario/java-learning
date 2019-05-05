package com.kiramario.thinkinjava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

class IterableClass implements Iterable<String>{
	protected String[] words = new String[] {"A","B","C","d"};
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			public boolean hasNext() {
				return index < words.length;
			}

			public String next() {
				return words[index++];
			}
			
		};
	}
	
}

class RevisibeArrayList<T> extends ArrayList<T>{
	public RevisibeArrayList(Collection<T> c) {
		super(c);
	}
	
	public Iterable<T> revesed(){
		return new Iterable<T>() {

			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;
					public boolean hasNext() {
						return current > -1;
					}

					public T next() {
						return get(current--);
					}
					
				};
			}
			
		};
	}
	
	public Iterable<T> randomized(){
		return new Iterable<T>() {
			ArrayList<T> duplicate = new ArrayList<T>();
			{
				for(int i = 0; i < size(); i++) {
					duplicate.add(get(i));
				}
			}
			public Iterator<T> iterator() {
				Collections.shuffle(duplicate);
				return duplicate.iterator();
			}
			
		};
	}
}

public class Exercise11_13 {

	public static void main(String[] args) {
		for(String s : new IterableClass()) {
			System.out.println(s);
		}
		
		for(Map.Entry entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		
		System.out.println("====RevisibeArrayList====");
		
		RevisibeArrayList<String> ral = new RevisibeArrayList<String>(Arrays.asList("hello good kira mario!".split(" ")));
		
		for(String s : ral) {
			System.out.print(s + " ");
		}
		System.out.println();
		for(String s:ral.revesed()) {
			System.out.print(s + " ");
		}
		System.out.println();
		for(String s:ral.randomized()) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println(ral);
		
	}

}

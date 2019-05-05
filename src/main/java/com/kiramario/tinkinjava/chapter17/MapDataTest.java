package com.kiramario.tinkinjava.chapter17;

import java.util.Iterator;

public class MapDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MapData.map(new Letters(), 11));
	}

}


class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{
	
	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	
	@Override
	public Pair<Integer, String> next() {
		// TODO Auto-generated method stub
		return new Pair<Integer,String>(number++,""+letter++);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>(){
			@Override
			public Integer next(){return number++;}

			@Override
			public boolean hasNext() {
				return number<size;
			}
			
			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	
}
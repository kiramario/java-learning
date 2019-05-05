package com.kiramario.thinkinjava.chapter11;

import java.util.AbstractCollection;
import java.util.Iterator;

class CollectionSequence extends AbstractCollection<Integer>{
	private Integer[] elements = new Integer[]{1,2,3,4,5};
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			public boolean hasNext() {
				return index < elements.length;
			}

			public Integer next() {
				return elements[index++];
			}
			
		};
	}

	@Override
	public int size() {
		return elements.length;
	}
	
}

public class Exercise11_12 {

	public static void main(String[] args) {
		CollectionSequence cs = new CollectionSequence();
		Iterator<Integer> csi = cs.iterator();
		while(csi.hasNext()) {
			System.out.println(csi.next());
		}

	}

}

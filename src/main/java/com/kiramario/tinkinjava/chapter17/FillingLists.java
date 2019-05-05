package com.kiramario.tinkinjava.chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillingLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<StringAddress> list = new ArrayList<StringAddress>(
				Collections.nCopies(4, new StringAddress("kiram"))
		);
		System.out.println(list);
		
		Collections.fill(list, new StringAddress("world"));
		System.out.println(list);
	}
}


class StringAddress{
	private String s;
	public StringAddress(String s){
		this.s = s;
	}
	@Override
	public String toString(){
		return super.toString() + " " + s; 
	}
}
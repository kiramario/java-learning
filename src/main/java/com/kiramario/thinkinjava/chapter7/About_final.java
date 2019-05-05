package com.kiramario.thinkinjava.chapter7;

import java.util.Random;

public class About_final {
	public static void main(String[] args){
		FinalData fd1 = new FinalData("fd1");
		//fd1.valueOne++;
		fd1.v2.i++;
		fd1.v1 = new Value(22);
		//fd1.v2 = new Value(22);
		System.out.println(fd1);
		FinalData fd2 = new FinalData("fd2");
		System.out.println(fd1);
		System.out.println(fd2);
	}
}


class Value{
	int i;
	public Value(int i){
		this.i = i;
	}
}

class FinalData{
	private static Random rand = new Random(47);
	private String id;
	public FinalData(String id){this.id=id;}
	public final int valueOne = 9;
	public static final int VALUE_TWO = 99;
	public static final int VALUE_THREE = 39;
	public final int i4 = rand.nextInt(10);
	static final int INT_5 = rand.nextInt(110);
	public Value v1 = new Value(11);
	public final Value v2 = new Value(22);
	public static final Value VAL_3 = new Value(33);
	public final int[] a = {1,2,3,4,5,6};
	@Override
	public String toString(){
		return id + ": " + "i4=" + i4 + ". INT_5=" + INT_5; 
	}
	
}
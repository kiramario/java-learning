package com.kiramario.thinkinjava.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Section5 {
	
	//没搞懂这个例子的实际用途
	public static void arrayOfGeneric(){
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[])la;
//		ls[0] = new ArrayList<Integer>();
		Object[] objects = ls;
		
		objects[0] = new ArrayList<Integer>();
		
	}
	
	public static void main(String[] args) {
	
		/*Integer[] a = {1,3,2};
		System.out.println(Arrays.deepToString(MethodParameter.f(a)));*/
		
		Object[] b = new Object[2];
		b[0] = 1;
		b[1] = "ab";
		System.out.println(Arrays.toString(b));
	}

}

class MethodParameter{
	public static <T> T[] f(T[] args){
		return args;
	}
}
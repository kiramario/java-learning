package com.kiramario.thinkinjava.chapter16;

import java.util.Arrays;
import java.util.Random;

public class Section4 {

	public static void printArray(){
		int[] a = {1,2,3};
		int[][] b = {
				{1,2},
				{3,4,6}
		};
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.deepToString(b));
	}
	
	public static void raggedArray(){
		Random rand = new Random(System.currentTimeMillis());
		int[][][] a = new int[rand.nextInt(4)][][];
		System.out.println(a.length);
		for(int i = 0; i < a.length; i++){
			a[i] = new int[rand.nextInt(5)][];
			for(int j = 0; j < a[i].length; j++){
				a[i][j] = new int[rand.nextInt(5)];
			}
		}
		System.out.println(Arrays.deepToString(a));
	}
	
	public static void main(String[] args){
//		printArray();
		
		raggedArray();
	}
}

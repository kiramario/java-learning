package com.kiramario.test;

public class DT {
	static long[] arr = new long[1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
//		System.out.println(f(50));	//42943 ms	20365011074
//		System.out.println(f1(1000));	//0 ms	9079565065540428013
		System.out.println(f2(1000));	//1 ms	9079565065540428013
		long end = System.currentTimeMillis();
		
		
		
		
		System.out.println(end - start);
	}

	
	public static long f(int n){
		if(n <= 2){
			return n;
		}else{
			return f(n - 1) + f(n - 2);
		}
	}
	
	public static long f1(int n){
		
		if(n <= 2){
			return n;
		}
		
		long res = 0;
		long f1 = 1;
		long f2 = 2;
		for(int i = 3; i <= n; i++){
			res = f1 + f2;
			f1 = f2;
			f2 = res;
		}
		
		return res;

	}
	
	public static long f2(int n){
		
		if(n <= 2){
			return n;
		}else{
			if(arr[n] != 0 ){
				return arr[n];
			}else{
				arr[n] =  f2(n - 1) + f2(n - 2);
				return arr[n];
			}
		}
	}
}

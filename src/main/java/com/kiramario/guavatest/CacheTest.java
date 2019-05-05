package com.kiramario.guavatest;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Callables;

public class CacheTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AndyService us = new AndyService();
		us.invalid();
		for(int i = 0; i < 10; i++){
			System.out.println(us.getAndyName(String.valueOf("1001")));
			TimeUnit.SECONDS.sleep(1);
		}
	} 
	
}


class AndyService{
	private final LoadingCache<String,String> cache;
	
	public AndyService(){
		cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build(new CacheLoader<String,String>(){
			public String load(String id) throws Exception{
				System.out.println("method inovke");
				 return "User:" + id;
			}
		});
	}
	
	
	public String getAndyName(String id) throws Exception{
		return cache.get(id);
	}
	
	public String callFun(String id){
		return id+ " good";
	}
	
	public void invalid(){
		cache.invalidateAll();
	}
}
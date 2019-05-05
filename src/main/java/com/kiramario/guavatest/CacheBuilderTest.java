package com.kiramario.guavatest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Ticker;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheBuilderTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		TradAccountCache tradecache = new TradAccountCache();
		for(int i = 0; i < 10; i++){
			
			
			System.out.println(tradecache.tradeAccountCache.get("abc"));
			TimeUnit.SECONDS.sleep(1);
		}

	}

	
	
}

class TradeAccount {    
    private String id; //ID
    private String owner; //ËùÓÐÕß
    private double balance; //Óà¶î
    
    public TradeAccount(String id, String owner, double balance){
    	this.id = id;
    	this.owner = owner;
    	this.balance = balance;
    }
    
    @Override
    public String toString(){
    	return  id +"; " + owner + ";" + balance;
    }
}
class TradAccountCache{
	public LoadingCache<String, TradeAccount> tradeAccountCache = 
			CacheBuilder.newBuilder()
//						.expireAfterWrite(5, TimeUnit.SECONDS)
						.refreshAfterWrite(5, TimeUnit.SECONDS)
						.maximumSize(5)
//						.removalListener(listener)
//						.ticker(Ticker.systemTicker())
						.build(new CacheLoader<String,TradeAccount>(){
							@Override
							public TradeAccount load(String key) throws Exception{
								System.out.println("invoke load");
								return new TradeAccount("id-"+key, "owner-"+key,1000.0);
							}
						});
}

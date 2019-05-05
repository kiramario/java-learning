package com.kiramario.tinkinjava.chapter17;

import java.util.LinkedHashMap;

/*
 * 填充Map，初始化map
 */
public class MapData<K,V> extends LinkedHashMap<K,V> {
	public MapData(Generator<Pair<K,V>> gen,int quantity){
		for(int i = 0; i < quantity; i++){
			Pair<K,V> p = gen.next();
			put(p.key,p.value);
		}
	}
	
	public MapData(Generator<K> genK,Generator<V> genV,int quantity){
		for(int i = 0; i < quantity; i++){
			put(genK.next(),genV.next());
		}
	}
	
	public MapData(Generator<K> genK,V v,int quantity){
		for(int i = 0; i < quantity; i++){
			put(genK.next(),v);
		}
	}
	
	public MapData(Iterable<K> genK,Generator<V> genV){
		for(K key : genK){
			put(key,genV.next());
		}
	}
	
	public MapData(Iterable<K> genK,V value){
		for(K key : genK){
			put(key,value);
		}
	}
	
	public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
		return new MapData<K,V>(gen,quantity);
	}
	// ...  后面的就是按照参数重新写一遍
}

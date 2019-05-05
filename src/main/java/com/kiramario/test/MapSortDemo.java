package com.kiramario.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSortDemo {

	
	
	
	
	
	
	
	public static void main(String[] args){
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("7320", 100);
        map.put("100", 156);
        map.put("1800", 260);
        map.put("1500", 267);
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        System.out.println("===================================");
        
        Map<String,Integer> sortedMap = new LinkedHashMap<String,Integer>(); //ÅÅÐòºóµÄÈÝÆ÷
        
        
        List<Map.Entry<String,Integer>> entryList 
        	= new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        
        Collections.sort(entryList,new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return -o1.getValue().compareTo(o2.getValue());
			}
        });
        
        Iterator<Map.Entry<String,Integer>> iter = entryList.iterator();
        Map.Entry<String,Integer> tmpEntry = null;
        while(iter.hasNext()){
        	tmpEntry = iter.next();
        	sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        	
        }
        
        
        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()){
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
	}
	
	
	
}

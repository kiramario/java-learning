package com.kiramario.thinkinjava.chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class PrintingContainers{
	static Collection fill(Collection<String> collection){
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	
	static Map fill(Map<String,String> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
	}
}

public class Exercise11_4 {

	public static void main(String[] args) {
		/*System.out.println(PrintingContainers.fill(new ArrayList<String>()));
		System.out.println(PrintingContainers.fill(new LinkedList<String>()));
		System.out.println(PrintingContainers.fill(new HashSet<String>()));
		System.out.println(PrintingContainers.fill(new TreeSet<String>()));
		System.out.println(PrintingContainers.fill(new LinkedHashSet<String>()));
		System.out.println(PrintingContainers.fill(new HashMap<String,String>()));
		System.out.println(PrintingContainers.fill(new TreeMap<String,String>()));
		System.out.println(PrintingContainers.fill(new LinkedHashMap<String,String>()));
		
		*/
		
		
		TreeMap<String,Integer> mi = new TreeMap<String,Integer>();
		mi.put("a", 10);
		mi.put("b", 1);
		mi.put("c", 5);
		System.out.println(mi);
		
		TreeSet<Integer> si = new TreeSet<Integer>();
		si.add(10);
		si.add(1);
		si.add(5);
		si.add(1);
		System.out.println(si);
	}

}

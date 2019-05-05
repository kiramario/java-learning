package com.kiramario.thinkinjava.chapter11;

import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Exercise11_9 {

	public static void main(String[] args) {
	    Set<String> set1 = new HashSet<String>();
	    Collections.addAll(set1, "A B C".split(" "));
	    Collections.addAll(set1, "A","b");

	    set1.add("D");
	    
	    System.out.println(set1);
	    
	    System.out.println(set1.contains("D"));
	    
	    Set<String> set2 = new HashSet<String>();
	    Collections.addAll(set2, "b","D");
	    System.out.println(set2);
	    
	    System.out.println(set1.containsAll(set2));
	    
	    TreeSet<String> set3 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	    set3.add("A");
	    set3.add("b");
	    set3.add("c");
	    set3.add("D");
	    System.out.println(set3);
	    

	}

}

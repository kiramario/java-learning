package com.kiramario.test2;

import java.io.File;
import java.util.StringTokenizer;

class TB {
	public void doS(){
		
	}
}

class TA{
	public void doS(){
		TB b = new TB();
		System.out.println(b.getClass().getClassLoader());
	}
}
public class ClassLoaderDemo1 {

	
	public static void main(String[] args){

		ClassLoader cl = TA.class.getClassLoader();
		System.out.println("ClassLoader is:"+cl.toString());
		System.out.println("ClassLoader\'s parent is:"+cl.getParent().toString());
		System.out.println("ClassLoader\'s grand father is:"+cl.getParent().getParent().toString());
		
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(File.pathSeparator);
		StringTokenizer st = new StringTokenizer("D:\\Application\\JAVA\\JDK\\jre\\lib\\ext;C:\\Windows\\Sun\\Java\\lib\\ext",File.pathSeparator);
		System.out.println(st.countTokens());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
	}
}

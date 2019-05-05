package com.kiramario.test2;

import java.io.*;
public class ReadTest {
	
	public static void transReadNoBuf() throws IOException{
		InputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\replaceArea\\stat_channel.txt");
		InputStreamReader isr = new InputStreamReader(in);
		
		char []cha = new char[1024];
		
		int len = isr.read(cha);
		
		 System.out.println(new String(cha,0,len));
		  isr.close();
	}
	
	 public static void transReadByBuf() throws IOException {
		 InputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\replaceArea\\stat_channel.txt");
			InputStreamReader isr = new InputStreamReader(in);
			
		BufferedReader bufr = new BufferedReader(isr);
		
		String line;
		while((line = bufr.readLine())!= null){
			System.out.println(line);
		}
		 isr.close();
	 }

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		transReadNoBuf();
	}

}

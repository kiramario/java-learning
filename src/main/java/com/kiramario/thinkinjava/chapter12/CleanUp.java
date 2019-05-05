package com.kiramario.thinkinjava.chapter12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
class InputFile{
	private BufferedReader in;
	public InputFile(String fname) throws Exception{
		try{
			in = new BufferedReader(new FileReader(fname));
		}catch(FileNotFoundException e){
			System.out.println("can not find file");
			throw e;
		}catch(Exception e){
			try{
				in.close();
			}catch(IOException e2 ){
				System.out.println("close unsuccessful");
			}
			throw e;
		}finally{
			
		}
	}
	public String getLine(){
		String s = "";
		try{
			s = in.readLine();
		}catch(IOException e){
			throw new RuntimeException("readLine failed");
		}
		return s;
	}
	public void dispose(){
		try{
			in.close();
		}catch(IOException e2){
			throw new RuntimeException("dispose close unsuccessful");
		}
	}
}
public class CleanUp {
	
	public static void main(String[] args){
		try{
			InputFile in = new InputFile("CleanUp.java");
			try{
				String s;
				int i = 1;
				while((s=in.getLine()) != null){
					System.out.println(s);
				}
			}catch(Exception e){
				System.out.println("caught exception in main");
				e.printStackTrace(System.out);
			}finally{
				in.dispose();
			}
		}catch(Exception e){
			System.out.println("Inputfile constructor failed");
		}
	}
}

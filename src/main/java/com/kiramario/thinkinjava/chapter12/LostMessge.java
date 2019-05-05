package com.kiramario.thinkinjava.chapter12;


class VeryImportantException extends Exception{
	@Override
	public String toString(){
		return "i am VeryImportantException";
	}
}

class HoHumException extends Exception {
	@Override
	public String toString(){
		return "i am HoHumException";
	}
}
public class LostMessge {
	
	void f() throws VeryImportantException{
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException{
		throw new HoHumException();
	}
	
	public static void main(String[] args){
		/* 1 */
		try{
			LostMessge lm = new LostMessge();
			try{
				lm.f();
			}finally{
				lm.dispose();
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		/* 2 */
		try{
			throw new RuntimeException();
		}finally{
			return;
		}
	}
}

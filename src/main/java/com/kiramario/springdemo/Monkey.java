package com.kiramario.springdemo;

@Service
public class Monkey {
	 private String monkeyName = "MonkeyKing";
	    public void setMonkeyName(String monkeyName){
	    	this.monkeyName = monkeyName;
	    }
	    @Override
		public String toString()
	    {
	        return "MonkeyName:" + monkeyName;
	    }
}

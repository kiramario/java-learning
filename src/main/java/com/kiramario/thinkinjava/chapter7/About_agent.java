package com.kiramario.thinkinjava.chapter7;

public class About_agent {
	
	public static void main(String[] args){
		/*Cleanser x = new Cleanser();
		x.dilute();x.apply();x.scrub();
		System.out.println(x);*/
		
		CleanserDelegation c = new CleanserDelegation("delegation");
		c.dilute();c.apply();
		System.out.println(c);
	}
}


class Cleanser{
	private String s = "Cleanser";
	public void append(String a){
		s+=a;
	}
	public void dilute(){
		append(" dilute() ");
	}
	public void apply(){
		append(" apply() ");
	}
	public void scrub(){
		append(" scrub() ");
	}
	@Override
	public String toString(){
		return s;
	}
}

class CleanserDelegation{
	private String name;
	private Cleanser cleanser = new Cleanser();
	
	CleanserDelegation(String name){
		this.name = name;
	}
	public void dilute(){
		cleanser.dilute();
	}
	public void apply(){
		cleanser.apply();
	}
	@Override
	public String toString(){
		cleanser.append(name);
		return cleanser.toString();
	}
}
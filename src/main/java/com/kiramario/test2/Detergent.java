package com.kiramario.test2;


class Cleanser{
	private String s = "Cleanser";
	
	public void append(String a){
		s += a;
	}
	public void dilute(){
		append(" dilute");
	}
	public void apply(){
		append(" apply");
	}
	public void scrub(){
		append(" scrub");
	}
	@Override
	public String toString(){
		return s;
	}
	public static void main(String[] args){
		Cleanser x = new Cleanser();
		x.dilute();x.apply();x.scrub();
		System.out.println(x);
	}
}

public class Detergent extends Cleanser{
	@Override
	public void scrub(){
		append(" Detergent.scrub");
		super.scrub();
	}
	public void foma(){
		append(" foma");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Detergent d = new Detergent();
		d.dilute();
		d.apply();
		d.scrub();
		d.foma();
		System.out.println(d);
		/*System.out.println("Testing base class");
		Cleanser.main(args);*/
	}
	
}

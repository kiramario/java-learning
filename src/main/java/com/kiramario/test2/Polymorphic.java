package com.kiramario.test2;

public class Polymorphic{

	public static void main(String[] args){
		Parcel4 p = new Parcel4();
		Contents c = p.contents();
		Destination d = p.destination("sss");
	}
}


interface Destination{
	String readLabel();
}

interface Contents{
	int value();
}

class Parcel4{
	private class PContents implements Contents{
		private int i = 11;
		@Override
		public int value(){
			return i;
		}
	}
	protected class PDestination implements Destination{
		private String label;
		private PDestination(String whereto){
			label = whereto;
		}
		@Override
		public String readLabel(){
			return label;
		}
	}
	public Destination destination(String s){
		return new PDestination(s);
	}
	public Contents contents(){
		return new PContents();
	}
}
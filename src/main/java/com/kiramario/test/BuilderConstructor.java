package com.kiramario.test;

import com.kiramario.test.Person.Builder;

public class BuilderConstructor {

	public static void main(String[] args) {
		Person p = new Person.Builder(1,2,3).clothes(4).game(5).girl(6).build();
		System.out.println(p.air);
		System.out.println(p.water);
		System.out.println(p.food);
		System.out.println(p.clothes);
		System.out.println(p.gold);
		System.out.println(p.game);
		System.out.println(p.girl);

	}

}


class Person{
	public int air; // 必须
	public int water; //必须
	public int food; //必须
	
	public int clothes;
	public int gold;
	public int game;
	public int girl;
	
	
	private Person(Builder builder){
		this.air = builder.air;
		this.water = builder.water;
		this.food = builder.food;
		this.clothes = builder.clothes;
		this.gold = builder.gold;
		this.game = builder.game;
		this.girl = builder.girl;
	}
	
	public static class Builder{
		private int air; // 必须
		private int water; //必须
		private int food; //必须
		
		private int clothes;
		private int gold;
		private int game;
		private int girl;
		
		public Builder(int air, int water,int food){
			this.air = air;
			this.water = water;
			this.food = food;
		}
		
		public Person build(){
			return new Person(this);
		}
		
		public Builder clothes(int clothes){
			this.clothes = clothes;
			return this;
		}
		public Builder gold(int gold){
			this.gold = gold;
			return this;
		}
		public Builder game(int game){
			this.game = game;
			return this;
		}
		public Builder girl(int girl){
			this.girl = girl;
			return this;
		}
	}
}
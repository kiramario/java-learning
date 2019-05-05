package com.kiramario.test;


enum Day{
	 MONDAY(1, "星期一", "星期一各种不在状态"){
		 @Override
		 public Day getNext(){
			 return TUESDAY;
		 }
	 }, 
	 TUESDAY(2, "星期二", "星期二依旧犯困"){
		 @Override
		 public Day getNext(){
			 return WEDNESDAY;
		 }
	 }, 
	 WEDNESDAY(3, "星期三", "星期三感觉半周终于过去了"){
		 @Override
		 public Day getNext(){
			 return THURSDAY;
		 }
	 }, 
	 THURSDAY(4, "星期四", "星期四期待这星期五"){
		 @Override
		 public Day getNext(){
			 return FRIDAY;
		 }
	 },
	 FRIDAY(5, "星期五", "星期五感觉还不错"){
		 @Override
		 public Day getNext(){
			 return SATURDAY;
		 }
	 }, 
	 SATURDAY(6, "星期六", "星期六感觉非常好"){
		 @Override
		 public Day getNext(){
			 return SUNDAY;
		 }
	 }, 
	 SUNDAY(7, "星期日", "星期日感觉周末还没过够。。。"){
		 @Override
		 public Day getNext(){
			 return TUESDAY;
		 }
	 };
	
	Day(int index, String name, String value){
		this.index = index;
		this.name = name;
		this.value = value;
	}
	
	private int index;
	private String name;
	private String value;
	private Day curDay;
	
	public abstract Day getNext();

	
	public int getIndex() { return index; } 
	public void setIndex(int index) { this.index = index; } 
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; } 
	public String getValue() { return value; } 
	public void setValue(String value) { this.value = value; }
	public Day getDay(int index) { 
		Day curDay = null;
		for(Day day : Day.values()){
			if(day.getIndex() == index){
				curDay = day;
				break;
			}
		}
		return curDay;
	} 
}

public class EnumClassTest {
	
	public static void test(){
		System.out.println(Day.MONDAY.getDay(1).getNext());
	}
	public static void  main(String[] args){
		test();
	}
}

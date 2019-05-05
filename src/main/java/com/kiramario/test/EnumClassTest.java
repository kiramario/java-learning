package com.kiramario.test;


enum Day{
	 MONDAY(1, "����һ", "����һ���ֲ���״̬"){
		 @Override
		 public Day getNext(){
			 return TUESDAY;
		 }
	 }, 
	 TUESDAY(2, "���ڶ�", "���ڶ����ɷ���"){
		 @Override
		 public Day getNext(){
			 return WEDNESDAY;
		 }
	 }, 
	 WEDNESDAY(3, "������", "�������о��������ڹ�ȥ��"){
		 @Override
		 public Day getNext(){
			 return THURSDAY;
		 }
	 }, 
	 THURSDAY(4, "������", "�������ڴ���������"){
		 @Override
		 public Day getNext(){
			 return FRIDAY;
		 }
	 },
	 FRIDAY(5, "������", "������о�������"){
		 @Override
		 public Day getNext(){
			 return SATURDAY;
		 }
	 }, 
	 SATURDAY(6, "������", "�������о��ǳ���"){
		 @Override
		 public Day getNext(){
			 return SUNDAY;
		 }
	 }, 
	 SUNDAY(7, "������", "�����ոо���ĩ��û����������"){
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

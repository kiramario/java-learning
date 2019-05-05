package com.kiramario.springdemo;

public class ZooDemo {
	private static ApplicationContext wac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static void main(String[] args){
		Zoo zoo = (Zoo) wac.getBean("zoo");
		System.out.println(zoo);
		
		CarFactory cf = (CarFactory) wac.getBean("carFactory");
	}
}

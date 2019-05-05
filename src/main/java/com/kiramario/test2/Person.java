package com.kiramario.test2;
import java.io.*;

public class Person implements Serializable{
	private String name = null;
	private Integer age = null;
	private Gender gender = null;
	
	private static class InstanceHolder{
		private static final Person instance = new Person("John", 31, Gender.MALE);
	}
	
	public static Person getInstance(){
		return InstanceHolder.instance;
	}
	
	 private Object readResolve() throws ObjectStreamException {
        return InstanceHolder.instance;
    }
	
	public Person(){
		System.out.println("none-arg constructor");
	}
	
	public Person(String name, Integer age, Gender gender){
		System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
	}
	

	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }
}

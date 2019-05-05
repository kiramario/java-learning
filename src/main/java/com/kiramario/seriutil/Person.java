package com.kiramario.seriutil;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	private String name;                                 //����  
    private int year;                                    //����  
    private String city;                                 //����  
    private Date birth;                                  //����  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
        this.year=year;  
        this.city=city;  
    }  
    public int getYear() {  
        return year;  
    }  
    public void setYear(int year) {  
        this.year = year;  
    }  
    public String getCity() {  
        return city;  
    }  
    public void setCity(String city) {  
        this.city = city;  
    }  
      
      
    public Date getBirth() {  
        return birth;  
    }  
    public void setBirth(Date birth) {  
        this.birth = birth;  
    }  
    /*  
     * (non-Javadoc)  
     * @see java.lang.Object#toString()  
     * ��дtoString����Ȼ���л�֮����ʾ�����ڴ��ַ  
     */  
    @Override
	public String toString(){  
        return this.name+" "+this.year+" "+this.city+" "+this.birth.toString();  
    }  
}

package com.kiramario.seriutil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizeableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("���л�֮ǰ");
		Blip b = new Blip("This String is " , 47);
		System.out.println(b);
		
		System.out.println("���л�������writeObject");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(b);
		
		System.out.println("�����л�֮��,readObject");
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(in);
		
		Blip bb = (Blip)ois.readObject();
		System.out.print(bb);
		
	}

}


class Blip implements Externalizable{
	private int i ;
	private String s;
	
	public Blip(){
		//Ĭ�Ϲ��캯�������У����ұ�����public
		System.out.println("BlipĬ�Ϲ��캯��");
	}
	
	public Blip(String s,Integer i){
		System.out.println("Blip���������캯��");
        this.s = s;
        this.i = i;
	}
	
	public String toString() {
        return s  + i ;
    }
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("����writeExternal��������");
		out.writeObject("good");
		out.writeInt(i);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("����readExternal��������");
		s = (String)in.readObject();
		i = in.readInt();
	}

}



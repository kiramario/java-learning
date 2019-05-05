package com.kiramario.test2;

import java.io.*;

public class SimpleSerial {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		 File file = new File("person.out");
		 
		 ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		 oout.writeObject(Person.getInstance());
		 oout.close();
		 
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newPerson = oin.readObject();
		oin.close();
		System.out.println(newPerson);
		  System.out.println(Person.getInstance() == newPerson);
	}

}

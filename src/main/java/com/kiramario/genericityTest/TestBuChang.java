package com.kiramario.genericityTest;

import java.util.ArrayList;
import java.util.List;

public class TestBuChang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<? extends Fruit> list = new ArrayList<>();
		/*list.add(new Apple());
		list.add(new Orange());
		list.add(new Fruit());*/
		
		//? extends ����set  add �� �������������˽����ﵽ����Ҫ����Fruit��������
		// list.get(0)�ܹ�ִ������Ϊ����item�ڴ�list����ʱ���������ܹ�ȷ������Apple�����࣬�����ܹ���ȫ��á�
		
		 list.add(null);
		 list.contains(new Apple());
		 list.indexOf(new Apple());
		 Apple apple = (Apple) list.get(0);
		 
		 
		 List<? super Apple> list2 = new ArrayList<>();
		 list2.add(new Apple());
	     list2.add(new Apple1());
//	     list2.add(new Fruit());
	     Object ap = list.get(0);
	}

}


class Fruit{}
class Apple extends Fruit{}
class Orange extends Fruit{}

class Apple1 extends Apple{}
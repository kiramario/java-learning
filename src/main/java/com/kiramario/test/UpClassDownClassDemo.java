package com.kiramario.test;

public class UpClassDownClassDemo {

	public static void main(String[] args) {
		 Human h = new Male();// ����ת��
		 System.out.println(h.name);
		 System.out.println(h.getName());
		 if(h instanceof Male){
			 Male m = (Male)h;
			 m.speak();
		 }
	}

}
class Human {
    String name = "Human";
    public String getName(){
        return this.name;
    }
   public void sleep() {
       System.out.println("Human sleep..");
   }
}

class Male extends Human {
   String name = "Male";
   public String getName(){
       return this.name;
   }
   @Override
   public void sleep() {
       System.out.println("Male sleep..");
   }

   public void speak() {
       System.out.println("I am Male");
   }
}

/*
ע�⣺����ת�Ͳ�Ҫǿ��ת�͡�
1 ����ת�ͺ����������ָ��������Ǹ�������ԣ�
2 ���������д�˸���ķ�������ô��������ָ��Ļ��ߵ��õķ���������ķ���,����ж�̬�󶨡�
3 ����ת�ͺ������ò��ܵ��������Լ��ķ��������Ǹ���û�е�������ķ�����������ò��ܱ���ͨ�������������speak������
4 ��Ҫ��������������أ����������ת�;���Ҫ����Ҫ������дgetter������
*/

/*
����ת��   
 ����ת����Ҫ���ǰ�ȫ�ԣ�����������õĶ����Ǹ��౾��
 ��ô������ת�͵Ĺ������ǲ���ȫ�ģ����벻�������������ʱ�����java.lang.ClassCastException����
 ������ʹ��instanceof����������������ܷ�����ת�ͣ�
 ֻ���Ⱦ�������ת�͵Ķ�����ܼ�������ת�͡�
*/


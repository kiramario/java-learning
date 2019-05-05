package com.kiramario.test;
//https://blog.csdn.net/qq_33824312/article/details/62858138

class ParentClass {
	public static String staticField = "����--��̬����";

    public String field = "����--��ͨ����";
    
    // ��̬��
    static {
        System.out.println(staticField);
        System.out.println("����--��̬��");
    }
    
    // ��ʼ����
    {
        System.out.println(field);
        System.out.println("����--��ͨ��");
    }
    
    // ������
    public ParentClass() {
        System.out.println("����--������");
    }
}

class SubClass extends ParentClass {
	// ��̬����
    public static String sstaticField = "����--��̬����";
    // ����
    public String sField = "����--����";

    // ��̬��
    static {
        System.out.println(sstaticField);
        System.out.println("����--��̬��");
    }

    // ��ʼ����
    {
        System.out.println(sField);
        System.out.println("����--��ͨ��");
    }

    // ������
    public SubClass() {
        System.out.println("����--������");
    }
    
    public static void t() {}
}
 

public class ClassInitOrder3 {
/*	public static String staticField = "����--��̬����";

    public String field = "����--��ͨ����";
    
    // ��̬��
    static {
        System.out.println(staticField);
        System.out.println("����--��̬��");
    }
    
    // ��ʼ����
    {
        System.out.println(field);
        System.out.println("����--��ͨ��");
    }*/
    
	public static void main(String[] args) {
		/* System.out.println("˳��:" + "��һ��new SubClass");
	     SubClass sub = new SubClass();
	     System.out.println("˳��:" + "�ڶ���new SubClass");
	     new SubClass();*/
		
		SubClass.t();
	}

}

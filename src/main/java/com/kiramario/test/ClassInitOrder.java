package com.kiramario.test;

public class ClassInitOrder {
	public static int k = 0;
	public static ClassInitOrder t1 = new ClassInitOrder("t1");
//	public static ClassInitOrder t2 = new ClassInitOrder("t2");
	public static int i = print("i");
	public static int n = 99;
	
	public int j = print("j");
	
	{
        print("����� 1");
    }
	
    static {
        print("��̬�� 2");
    }

    public ClassInitOrder(String str) {
    	System.out.println("class init order");
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str) {
    	System.out.println("print+++");
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }
    
    
	public static void main(String[] args) {
//		ClassInitOrder t = new ClassInitOrder("init");
	}
	
	
}
/*
1. ��ʼ����

��ʼ����ͨ��д����Ĺ��췽��֮ǰ���ɻ�������������ͨ�������Գ�Ա���Խ��г�ʼ������䣻

��ʼ�����Ϊinstance��ʼ�����static��ʼ���飬��ʼ�����ڹ��췽��ִ��֮ǰ��ִ�У�

static��ʼ���鲻�ܷ��ʷ�statci��Ա��Ҳ���ܵ��÷�static����������ֻ�������ʱִ��һ�Σ�

��ʼ����ͨ��������ȡ������췽���еĹ������롣

2. ��ʼ����ִ��˳��

��1���ڳ���newһ��Child�����ʱ���������и��࣬���ȼ���Parent�࣬�ټ���Child�ࡣ

��2������Parent�ࣺ

      ��ʼ��Parent���static���ԣ���Ĭ��ֵ��

      ִ��Parent���static��ʼ���飻

��3������Child�ࣺ

  ��ʼ��Child���static���ԣ���Ĭ��ֵ��

ִ��Child���static��ʼ���飻

��4������Parent�����

      ��ʼ��Parent��ķ�static���ԣ���Ĭ��ֵ��

  ִ��Parent���instance��ʼ���飻

�� ִ��Parent��Ĺ��췽����

��5������Child�����

  ��ʼ��Child��ķ�static���ԣ���Ĭ��ֵ��

ִ��Child���instance��ʼ���飻

  ִ��Child��Ĺ��췽����

�����ٴ���Child�����ʱ���Ͱ���˳��ִ�У�4����5��������*/

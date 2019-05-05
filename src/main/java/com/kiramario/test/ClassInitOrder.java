package com.kiramario.test;

public class ClassInitOrder {
	public static int k = 0;
	public static ClassInitOrder t1 = new ClassInitOrder("t1");
//	public static ClassInitOrder t2 = new ClassInitOrder("t2");
	public static int i = print("i");
	public static int n = 99;
	
	public int j = print("j");
	
	{
        print("构造块 1");
    }
	
    static {
        print("静态块 2");
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
1. 初始化块

初始化块通常写在类的构造方法之前，由花括号括起来，通常包含对成员属性进行初始化的语句；

初始化块分为instance初始化块和static初始化块，初始化块在构造方法执行之前被执行；

static初始化块不能访问非statci成员，也不能调用非static方法，并且只在类加载时执行一次；

初始化块通常用于提取多个构造方法中的公共代码。

2. 初始化的执行顺序

（1）在初次new一个Child类对象时，发现其有父类，则先加载Parent类，再加载Child类。

（2）加载Parent类：

      初始化Parent类的static属性，赋默认值；

      执行Parent类的static初始化块；

（3）加载Child类：

  初始化Child类的static属性，赋默认值；

执行Child类的static初始化块；

（4）创建Parent类对象：

      初始化Parent类的非static属性，赋默认值；

  执行Parent类的instance初始化块；

　 执行Parent类的构造方法；

（5）创建Child类对象：

  初始化Child类的非static属性，赋默认值；

执行Child类的instance初始化块；

  执行Child类的构造方法；

后面再创建Child类对象时，就按照顺序执行（4）（5）两步。*/

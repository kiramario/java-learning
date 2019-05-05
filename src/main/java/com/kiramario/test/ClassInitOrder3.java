package com.kiramario.test;
//https://blog.csdn.net/qq_33824312/article/details/62858138

class ParentClass {
	public static String staticField = "父类--静态变量";

    public String field = "父类--普通变量";
    
    // 静态块
    static {
        System.out.println(staticField);
        System.out.println("父类--静态块");
    }
    
    // 初始化块
    {
        System.out.println(field);
        System.out.println("父类--普通块");
    }
    
    // 构造器
    public ParentClass() {
        System.out.println("父类--构造器");
    }
}

class SubClass extends ParentClass {
	// 静态变量
    public static String sstaticField = "子类--静态变量";
    // 变量
    public String sField = "子类--变量";

    // 静态块
    static {
        System.out.println(sstaticField);
        System.out.println("子类--静态块");
    }

    // 初始化块
    {
        System.out.println(sField);
        System.out.println("子类--普通块");
    }

    // 构造器
    public SubClass() {
        System.out.println("子类--构造器");
    }
    
    public static void t() {}
}
 

public class ClassInitOrder3 {
/*	public static String staticField = "父类--静态变量";

    public String field = "父类--普通变量";
    
    // 静态块
    static {
        System.out.println(staticField);
        System.out.println("父类--静态块");
    }
    
    // 初始化块
    {
        System.out.println(field);
        System.out.println("父类--普通块");
    }*/
    
	public static void main(String[] args) {
		/* System.out.println("顺序:" + "第一次new SubClass");
	     SubClass sub = new SubClass();
	     System.out.println("顺序:" + "第二次new SubClass");
	     new SubClass();*/
		
		SubClass.t();
	}

}

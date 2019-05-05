package com.kiramario.test;

public class UpClassDownClassDemo {

	public static void main(String[] args) {
		 Human h = new Male();// 向上转型
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
注意：向上转型不要强制转型。
1 向上转型后父类的引用所指向的属性是父类的属性，
2 如果子类重写了父类的方法，那么父类引用指向的或者调用的方法是子类的方法,这个叫动态绑定。
3 向上转型后父类引用不能调用子类自己的方法，就是父类没有但是子类的方法，如果调用不能编译通过，比如子类的speak方法。
4 非要调用子类的属性呢？如果不向下转型就需要给需要的属性写getter方法。
*/

/*
向下转型   
 向下转型需要考虑安全性，如果父类引用的对象是父类本身，
 那么在向下转型的过程中是不安全的，编译不会出错，但是运行时会出现java.lang.ClassCastException错误。
 它可以使用instanceof来避免出错此类错误即能否向下转型，
 只有先经过向上转型的对象才能继续向下转型。
*/


package com.kiramario.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

abstract class Client{
	public abstract int outSourcing();
}
class Limei extends Client{

	@Override
	public int outSourcing() {
		int finish_statu = 1;
		System.out.println("Doing the PS");
		return finish_statu;
	}
	
}

class Zhangli extends Client{
	@Override
	public int outSourcing() {
		int finish_statu = 1;	
		System.out.println("Selling TV");
		return finish_statu;
	}
	
}

abstract class Corporation{
	public abstract int ownJob();
}

class Hxzq extends Corporation{

	@Override
	public int ownJob() {
		int finish_statu = 1;	
		System.out.println("doing the coding");
		return finish_statu;
	}
	
}
class Kiramario{
	private Object client;
	public Kiramario(Object client){
		this.client = client;
	}
	
	private void doMyJob(){
		System.out.println("advertisement");
	}
	public void doJob(){
		doMyJob();
//		this.client.outSourcing();
	}
}

//class Prox{
//	public static Object newI(Class clazz){
//		Object o = o;
//		return o;
//	}
//}

public class ProxyDemo1 {

	public static void main(String[] args){
		/*Limei lm = new Limei();
		Kiramario kr = new Kiramario(lm);
		
		Class limei_clazz = Limei.class;
		
		Method[] methods = limei_clazz.getMethods();
		
		for(int i = 0; i < methods.length; i++){
			System.out.println(methods[i]);
		}*/
		
		LogHandler logHandler = new LogHandler();
		UserManager userManager = (UserManager)logHandler.newProxyInstance(new UserManagerImpl());
		userManager.findUser("a","b");
	}
}


class LogHandler implements InvocationHandler{
	private Object targetObject; //��Ҫ����Ķ��󱣴�Ϊ��Ա����
	
	public Object newProxyInstance(Object targetObject){
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), 
				targetObject.getClass().getInterfaces(), this);
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start-->>" + method.getName());//����ִ��ǰ�Ĳ���
		for (int i=0; i<args.length; i++) {
            System.out.println(args[i]);
        }
		Object ret = null;
		try{
			//����Ŀ�귽�������Ŀ�귽���з���ֵ������ret,���û���׳��쳣
			ret = method.invoke(targetObject, args);
			System.out.println("success-->>" + method.getName()); //����ִ�к����
		}catch(Exception e){
			e.printStackTrace();
            System.out.println("error-->>" + method.getName());//�����쳣ʱ�Ĳ���
            throw e;
		}
		return ret;
	}
	
}
interface UserManager{
	public void findUser(String a, String b);
}

class UserManagerImpl implements  UserManager{
	public void findUser(String a, String b){
		System.out.println("UserManager find user");
	}
}
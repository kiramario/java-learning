package com.kiramario.guavatest;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusTest1 {

	public static void main(String[] args) {
		EventBus eb = new EventBus("test");
		
		eb.register(new MyEventListener());
		eb.post(new MyE1());
		eb.post(new MyE2());
	}

}


abstract class MyEvent{
	protected abstract void hand();
};

class MyE1 extends MyEvent{

	@Override
	public void hand() {
		// TODO Auto-generated method stub
		System.out.println("MyE1");
	}
	
}

class MyE2 extends MyEvent{

	@Override
	public void hand() {
		System.out.println("MyE2");
	}
	
}

class MyEventListener{
	@Subscribe
	public void doListen(MyEvent e){
		e.hand();
	}
}
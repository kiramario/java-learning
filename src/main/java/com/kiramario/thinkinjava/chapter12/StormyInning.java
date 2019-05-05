package com.kiramario.thinkinjava.chapter12;

class BaseBallException extends Exception{}
class Foul extends Exception{}
class Strike extends Exception{}

abstract class Inning{
	public Inning() throws BaseBallException{}
	public void event() throws BaseBallException{}
	public abstract void atBat() throws Strike,Foul;
	public void walk(){};
}

class StormException extends Exception{}
class RainedOut extends Exception{}
class PopFoul extends Foul{}

interface Storm{
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
	public StormyInning() throws RainedOut,BaseBallException{}
	public StormyInning(String s) throws Foul,BaseBallException{}
	@Override
	public void rainHard() throws RainedOut{}
	@Override
	public void event(){}
	@Override
	public void atBat() throws PopFoul{}
	public static void main(String[] args){
		try{
			StormyInning si = new StormyInning();
			si.atBat();
		}catch(PopFoul e){
			System.out.println("Pop foul");
		}
		catch(RainedOut e){
			System.out.println("RainedOut");
		}
		catch(BaseBallException e){
			System.out.println("BaseBallException");
		}
		
		
		try{
			Inning i = new StormyInning();
			i.atBat();
		}catch(Strike e){
			System.out.println("Strike");
		}
		catch(Foul e){
			System.out.println("Foul");
		}
		catch(RainedOut e){
			System.out.println("RainedOut");
		}
		catch(BaseBallException e){
			System.out.println("BaseBallException");
		}
	}
	
}

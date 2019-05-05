package com.kiramario.thinkinjava.chapter12;

class NeedsCleanUp{
	private static long counter=1;
	private final long id = counter++;
	public void dispose(){
		System.out.println("NeedsCleanUp " + id + " dispose" );
	}
}

class ContructionException extends Exception{}

class NeedsCleanUp2 extends NeedsCleanUp{
	public NeedsCleanUp2() throws ContructionException{};
}

public class CleanUpIdiom {
	public static void main(String[] args){
		NeedsCleanUp nc1 = new NeedsCleanUp();
		nc1.dispose();
		NeedsCleanUp nc2 = new NeedsCleanUp();
		NeedsCleanUp nc3 = new NeedsCleanUp();
		nc3.dispose();
		nc2.dispose();
		
		try{
			NeedsCleanUp2 nc4 = new NeedsCleanUp2();
			
			try{
				NeedsCleanUp2 nc5 = new NeedsCleanUp2();
				
				try{
					
				}finally{
					nc5.dispose();
				}
			}catch(ContructionException e){	// nc5 constructor exception
				System.out.println(e);
			}finally{
				nc4.dispose();
			}
		}catch(ContructionException e){ 	// nc4 constructor exception
			System.out.println(e);
		}
		
		
	}
}

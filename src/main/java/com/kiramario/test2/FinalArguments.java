package com.kiramario.test2;


class Gizmo{
	public void spin(){
		
	}
}

public class FinalArguments {
	
	void with(final Gizmo g){

	}
	void without(Gizmo g){
		g = new Gizmo();
		g.spin();
	}
	
	int g(final int i){
		return i + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalArguments bf = new FinalArguments();
		bf.with(null);
		bf.without(null);
	}

}

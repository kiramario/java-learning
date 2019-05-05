package com.kiramario.springdemo;

import javax.annotation.Resource;

public class Zoo {
	@Autowired(required = false)
	private Tiger tiger;
	
	@Resource(name = "monkey",type=Monkey.class)
	private Monkey monkey;
	@Override
	public String toString() {
		return "Zoo [tiger=" + tiger + ", monkey=" + monkey + "]";
	}
	
	
}

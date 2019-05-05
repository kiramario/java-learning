package com.kiramario.springdemo;

@Service
public class BMW implements Car{
	@Override
	public String carName()
    {
        return "BMW car";
    }
}

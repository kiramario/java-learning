package com.kiramario.springdemo;

@Service
public class Benz implements Car{
	@Override
	public String carName()
    {
        return "Benz car";
    }
}

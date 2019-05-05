package com.kiramario.springdemo;

@Service
public class CarFactory {
	@Autowired
	@Qualifier("BMW")
    private Car car;
    
    @Override
	public String toString()
    {
        return car.carName();
    }
}

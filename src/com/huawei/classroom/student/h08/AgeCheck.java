package com.huawei.classroom.student.h08;

public class AgeCheck implements AgeCheckInterface {
	
    @Override
    public void checkAge(int age) {
    	if(age >= 0 && age <= 200) {
    		return;
    	}
    	else {
    		throw new RuntimeException();
    	}
    }
}


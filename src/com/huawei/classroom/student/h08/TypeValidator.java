package com.huawei.classroom.student.h08;

public class TypeValidator extends Exception{
	public TypeValidator() {
		
	}
	public void validate(String str) {
		
	}
	public void validate(Object obj) throws Exception {
		if(obj instanceof String) {
			return;
		}
		else {
			throw new Exception();
		}
	}
}

package com.huawei.classroom.student.h08;

public class LoginUtil {
	private String username;
	private String password;
	
    public LoginUtil(){
    	this.username = "a";
    	this.password = "a";
    }

    public void login(String username, String password) throws InvalidUserException{
    	if(username.equals(this.username) && password.equals(this.password)) return;
    	else {
    		throw new InvalidUserException();
    	}
    }
}

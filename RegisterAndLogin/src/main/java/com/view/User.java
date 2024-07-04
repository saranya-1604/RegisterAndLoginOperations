package com.view;

public class User {
String name, email, password;
int age;
public User(String name, int age, String email, String password) {
	super();
	this.name = name;
	this.age = age;
	this.email = email;
	this.password = password;
	
}
public String getName() {
	return name;
}
public String getEmail() {
	return email;
}
public String getPassword() {
	return password;
}
public int getAge() {
	return age;
}
public User(String email,String password) {
	this.email=email;
	this.password=password;
	
}

public String getemail() {
	return email;
}
public String getpassword() {
	return password;
}

}

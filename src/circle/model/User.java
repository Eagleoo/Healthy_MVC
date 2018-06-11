package circle.model;

public class User {
private int user_id;
 private String username;
 private String user_password;
 private String sex;
 private double user_tall;
private double user_weight;
 private int user_age;
private String portrait;
 
public User() {
	
	
}
public User(String user_name, String user_password, String user_sex,
double user_tall,double user_weight ,int user_age) {
	super();
	
	this.username = user_name;
	this.user_password = user_password;
	this.sex = user_sex;
	this.user_tall = user_tall;
    this.user_weight = user_weight;
	this.user_age = user_age;
	
}
public User(int user_id,String user_name,  String user_sex,
double user_tall,double user_weight ,int user_age,String user_adress) {
	super();
	this.user_id=user_id;
	this.username = user_name;
	this.sex = user_sex;
	this.user_tall = user_tall;
    this.user_weight = user_weight;
	this.user_age = user_age;
	
}



public String getPortrait() {
	return portrait;
}
public void setPortrait(String portrait) {
	this.portrait = portrait;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}



public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public double getUser_tall() {
	return user_tall;
}
public void setUser_tall(double user_tall) {
	this.user_tall = user_tall;
}
public double getUser_weight() {
	return user_weight;
}
public void setUser_weight(double user_weight) {
	this.user_weight = user_weight;
}
public int getUser_age() {
	return user_age;
}
public void setUser_age(int user_age) {
	this.user_age = user_age;
}

 
}
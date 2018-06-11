package circle.model;

public class Review {
private int id;
private String username;
private int consult_id;
private String content;
private String imag;

public Review() {
	super();
	// TODO Auto-generated constructor stub
}
public Review(String username, int consult_id, String content) {
	super();
	this.username = username;
	this.consult_id = consult_id;
	this.content = content;
}

public String getImag() {
	return imag;
}
public void setImag(String imag) {
	this.imag = imag;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getConsult_id() {
	return consult_id;
}
public void setConsult_id(int consult_id) {
	this.consult_id = consult_id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}


}

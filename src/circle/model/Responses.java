package circle.model;

public class Responses {
private int id;
private String username;
private String responsename;
private String responsecon;
private int reviewid;

public Responses() {
	super();
	// TODO Auto-generated constructor stub
}
public Responses(String username, String responsename, String responsecon, int reviewid) {
	super();
	this.username = username;
	this.responsename = responsename;
	this.responsecon = responsecon;
	this.reviewid = reviewid;
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
public String getResponsename() {
	return responsename;
}
public void setResponsename(String responsename) {
	this.responsename = responsename;
}
public String getResponsecon() {
	return responsecon;
}
public void setResponsecon(String responsecon) {
	this.responsecon = responsecon;
}
public int getReviewid() {
	return reviewid;
}
public void setReviewid(int reviewid) {
	this.reviewid = reviewid;
}

}

package circle.model;

public class Dynamics {
private int id;
private String describe;
private String title;
private String content;
private String author;


public Dynamics() {
	super();
	// TODO Auto-generated constructor stub
}

public Dynamics(String describe, String title, String content, String author) {
	super();
	this.describe = describe;
	this.title = title;
	this.content = content;
	this.author = author;
}

public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getDescribe() {
	return describe;
}
public void setDescribe(String describe) {
	this.describe = describe;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

}

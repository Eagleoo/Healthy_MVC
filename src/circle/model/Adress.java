package circle.model;



public class Adress {
private int id;
private String clientname;
private String sender;
private String clienttel;
private String clientaddress;

public Adress() {
	
}
public Adress(String clientname, String sender,String clienttel, String clientaddress) {
	super();
	this.clientname = clientname;
	this.sender=sender;
	this.clienttel = clienttel;
	this.clientaddress = clientaddress;
}
public Adress(int id, String sender,String clienttel, String clientaddress) {
	super();
	this.id=id;
	this.sender=sender;
	this.clienttel = clienttel;
	this.clientaddress = clientaddress;
}
public Adress(String sender,String clienttel, String clientaddress) {
	super();
	
	this.sender=sender;
	this.clienttel = clienttel;
	this.clientaddress = clientaddress;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getClientname() {
	return clientname;
}
public void setClientname(String clientname) {
	this.clientname = clientname;
}

public String getSender() {
	return sender;
}
public void setSender(String sender) {
	this.sender = sender;
}
public String getClienttel() {
	return clienttel;
}
public void setClienttel(String clienttel) {
	this.clienttel = clienttel;
}
public String getClientaddress() {
	return clientaddress;
}
public void setClientaddress(String clientaddress) {
	this.clientaddress = clientaddress;
}

}

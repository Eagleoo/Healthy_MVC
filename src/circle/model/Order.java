package circle.model;

public class Order {
	
private int mall_id;
private String mall_name;
private String mall_describe;
private String mall_price;
private String mall_img;
private String mall_detail_img;
private String mall_type;
private int order_id;
private String consigee;
private String cellnumber;
private String address;

public Order() {
	super();
	// TODO Auto-generated constructor stub
}

public String getConsigee() {
	return consigee;
}

public void setConsigee(String consigee) {
	this.consigee = consigee;
}

public String getCellnumber() {
	return cellnumber;
}

public void setCellnumber(String cellnumber) {
	this.cellnumber = cellnumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getOrder_id() {
	return order_id;
}

public void setOrder_id(int order_id) {
	this.order_id = order_id;
}

public int getMall_id() {
	return mall_id;
}
public void setMall_id(int mall_id) {
	this.mall_id = mall_id;
}
public String getMall_name() {
	return mall_name;
}
public void setMall_name(String mall_name) {
	this.mall_name = mall_name;
}
public String getMall_describe() {
	return mall_describe;
}
public void setMall_describe(String mall_describe) {
	this.mall_describe = mall_describe;
}
public String getMall_price() {
	return mall_price;
}
public void setMall_price(String mall_price) {
	this.mall_price = mall_price;
}
public String getMall_img() {
	return mall_img;
}
public void setMall_img(String mall_img) {
	this.mall_img = mall_img;
}
public String getMall_detail_img() {
	return mall_detail_img;
}
public void setMall_detail_img(String mall_detail_img) {
	this.mall_detail_img = mall_detail_img;
}
public String getMall_type() {
	return mall_type;
}
public void setMall_type(String mall_type) {
	this.mall_type = mall_type;
}

}

package dao.vo;
public class Address {
    private String consigneer;
    private String cellnumber;
    private String address;

    public Address() {
    }

    public String getConsigneer() {
        return consigneer;
    }

    public void setConsigneer(String consigneer) {
        this.consigneer = consigneer;
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
}

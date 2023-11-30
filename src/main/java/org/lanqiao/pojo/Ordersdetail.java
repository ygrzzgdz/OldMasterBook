package org.lanqiao.pojo;

public class Ordersdetail {
    private Long did;
    private int num;
    private double price;
    private String oid;
    private Books bid;

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Books getBid() {
        return bid;
    }

    public void setBid(Books bid) {
        this.bid = bid;
    }

    public Ordersdetail(Long did, int num, double price, String oid, Books bid) {
        this.did = did;
        this.num = num;
        this.price = price;
        this.oid = oid;
        this.bid = bid;
    }

    public Ordersdetail() {
    }

    @Override
    public String toString() {
        return "Ordersdetail{" +
                "did=" + did +
                ", num=" + num +
                ", price=" + price +
                ", oid='" + oid + '\'' +
                ", bid=" + bid +
                '}';
    }
}

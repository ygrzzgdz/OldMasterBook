package org.lanqiao.pojo;


import java.util.Date;

public class Orders {
    private String oid;
    private int count;
    private double totalprice;
    private Users uid;
    private int state;
    private Date createtime;
    private Date modiftime;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Users getUid() {
        return uid;
    }

    public void setUid(Users uid) {
        this.uid = uid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModiftime() {
        return modiftime;
    }

    public void setModiftime(Date modiftime) {
        this.modiftime = modiftime;
    }

    public Orders(String oid, int count, double totalprice, Users uid, int state, Date createtime, Date modiftime) {
        this.oid = oid;
        this.count = count;
        this.totalprice = totalprice;
        this.uid = uid;
        this.state = state;
        this.createtime = createtime;
        this.modiftime = modiftime;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "orders{" +
                "oid='" + oid + '\'' +
                ", count=" + count +
                ", totalprice=" + totalprice +
                ", uid=" + uid +
                ", state=" + state +
                ", createtime=" + createtime +
                ", modiftime=" + modiftime +
                '}';
    }
}

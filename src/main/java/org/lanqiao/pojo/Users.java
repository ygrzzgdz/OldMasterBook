package org.lanqiao.pojo;

public class Users {
    private Long uid;
    private String username;
    private String password;
    private String contact;
    private String mobilephone;
    private String address;
    private String email;
    private Integer type;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(Long uid, String username, String password, String contact, String mobilephone, String address, String email, Integer type) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.mobilephone = mobilephone;
        this.address = address;
        this.email = email;
        this.type = type;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contact='" + contact + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }
}

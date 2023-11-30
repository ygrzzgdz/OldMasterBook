package org.lanqiao.pojo;

public class Books {
    private Long bid;
    private String name;
    private String author;
    private double price;
    private String image;
    private String description;
    private int stock;
    private Category cid;

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCid() {
        return cid;
    }

    public void setCid(Category cid) {
        this.cid = cid;
    }

    public Books(Long bid, String name, String author, double price, String image, String description, int stock, Category cid) {
        this.bid = bid;
        this.name = name;
        this.author = author;
        this.price = price;
        this.image = image;
        this.description = description;
        this.stock = stock;
        this.cid = cid;
    }

    public Books() {
    }

    @Override
    public String toString() {
        return "Books{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", cid=" + cid +
                '}';
    }
}

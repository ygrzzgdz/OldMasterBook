package org.lanqiao.pojo;

public class Category {
    private Long cid;
    private String name;
    private String description;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(Long cid, String name, String description) {
        this.cid = cid;
        this.name = name;
        this.description = description;
    }

    public Category(Long cid) {
        this.cid = cid;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

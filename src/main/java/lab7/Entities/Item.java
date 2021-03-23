package lab7.Entities;

import lab7.Annotations.Column;
import lab7.Annotations.Entity;

@Entity(name = "Item")
public class Item {
    @Column(name = "name")
    public String name;
    @Column(name = "id_category")
    public Categories id_category;
    @Column(name = "price")
    public Double price;
    @Column(name = "info")
    public String info;

    public Item(String name, Double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public void setId_category(Categories id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public Categories getId_category() {
        return id_category;
    }

    public Double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }
}

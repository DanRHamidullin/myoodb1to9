package lab7.Entities;

import lab7.Annotations.Column;
import lab7.Annotations.Entity;

@Entity(name = "Categories")
public class Categories {
    @Column(name = "name")
    public String name;

    public Categories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

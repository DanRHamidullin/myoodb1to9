package lab6.lab6.Entities;

import lab6.lab6.Annotations.Column;
import lab6.lab6.Annotations.Entity;

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

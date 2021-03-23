package lab8.classes;


import lab8.annotation.*;

import java.util.Collection;
import java.util.TreeSet;

@Entity
public class Shop {
    @Id
    Long id;
    @Column
    String name;


    @ManyToMany
    Collection<Orders> orders = new TreeSet<>();

    public Shop() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

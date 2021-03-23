package lab6.lab6.Entities;

import lab6.lab6.Annotations.Column;
import lab6.lab6.Annotations.Entity;
import lab6.lab6.Annotations.ManyToOne;
import lab6.lab6.Annotations.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Orders")
public class Orders {
    @Column(name = "time")
    public String time;
    @Column(name = "status")
    public String status;
    @Column(name = "items")
    @OneToMany(rightSide = Item.class)
    public List<Item> items = new ArrayList<>();
    @Column(name = "user")
    @ManyToOne(rightClass = Users.class)
    public Users user;

    public void setItems(List<Item> items1) {
        for (int i = 0; i < items1.size(); i++) {
            items.add(items1.get(i));
        }
    }

    public Orders(String time, Users user) {
        this.time = time;
        setStatus("Accept");
        this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void getItems() {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println("ORDER ~ " + time + ": " + this.items.get(i).name + " ~ $" + this.items.get(i).price);
        }
    }
}

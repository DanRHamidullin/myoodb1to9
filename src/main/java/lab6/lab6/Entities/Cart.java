package lab6.lab6.Entities;

import lab6.lab6.Annotations.Column;
import lab6.lab6.Annotations.Entity;
import lab6.lab6.Annotations.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Cart")
public class Cart {
    @Column(name = "items")
    @OneToMany(rightSide = Item.class)
    List<Item> items = new ArrayList<>();

    public void makeOrder(Shop shop, String time, Users user) {
        Orders orders = new Orders(time, user);
        orders.setItems(items);
        shop.orders.add(orders);
        items.clear();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void getItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).name + " ~ $" + items.get(i).price);
        }
    }
}

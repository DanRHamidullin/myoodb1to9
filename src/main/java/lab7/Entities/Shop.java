package lab7.Entities;

import lab7.Annotations.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Shop")
public class Shop {
    @Column(name = "name")
    public String name = "ExampleName";
    @Column(name = "title")
    public String title = "ExampleTitle";
    @Column(name = "users")
    @ManyToMany(rightSide = Users.class)
    List<Users> users = new ArrayList<>();
    @Column(name = "categories")
    @OneToMany(rightSide = Categories.class)
    List<Categories> categories = new ArrayList<>();
    @Column(name = "items")
    @OneToMany(rightSide = Item.class)
    List<Item> items = new ArrayList<>();
    @Column(name = "carts")
    @ManyToOne(rightClass = Cart.class)
    List<Cart> carts = new ArrayList<>();
    @Column(name = "orders")
    @ManyToOne(rightClass = Orders.class)
    List<Orders> orders = new ArrayList<>();

    public void addCategory(String name) {
        System.out.println("Добавлена категория: " + name);
        categories.add(new Categories(name));
    }

    public boolean isItExists(String name) {
        for (int i = 0; i < this.categories.size(); i++) {
            if (categories.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addItem(String name, Double price, String info, String category) {
        if (isItExists(category)) {
            items.add(new Item(name, price, info));
            Item item = items.get(items.size() - 1);
            System.out.println("Добавлен товар: " + item.name);
            for (int i = 0; i < this.categories.size(); i++) {
                if (this.categories.get(i).name.equals(category)) {
                    item.setId_category(this.categories.get(i));
                }
            }
        } else {
            addCategory(category);
            items.add(new Item(name, price, info));
            Item item = items.get(items.size() - 1);
            System.out.println("Добавлен товар: " + item.name);
            item.setId_category(this.categories.get(this.categories.size() - 1));
        }
    }

    public Users addUser(String email, String password, String address, boolean isAdmin) {
        Users user = new Users(email, password, address, isAdmin);
        users.add(user);
        Cart cart = user.cart;
        carts.add(cart);
        return user;
    }

    public void makeOrder(Shop shop, Users user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                user.cart.makeOrder(shop, String.valueOf(new Date()), user);
            }
        }
    }

    public Users findUserByEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).email.equals(email)) {
                System.out.println("Пользователь с email: " + email + " найден! Адрес: " + users.get(i).address);
                return users.get(i);
            }
        }
        System.out.println("Пользователь с email: " + email + " не найден!");
        return null;
    }

    public void getSortedCategories() {
        List<String> out = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            out.add(categories.get(i).name);
        }
        System.out.println("\n~ Сортированный список: ");
        out.stream().sorted().forEach(s -> System.out.println(s));
        System.out.println("\n~ Несортированный список: ");
        out.stream().forEach(s -> System.out.println(s));
    }
}

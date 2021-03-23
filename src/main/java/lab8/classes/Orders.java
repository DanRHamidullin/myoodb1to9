package lab8.classes;

import lab8.annotation.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Orders implements Comparable<Orders> {
    @Id
    Long id;

    @Column
    @ManyToOne
    Users users;

    @Column
    @ManyToOne
    Category category;

    @Column
    String title;


    @Column
    String dateofpublishing;
    @Column
    Double price;

    @ManyToMany
    Collection<Shop> shop;

    public String getDateofpublishing() {
        return dateofpublishing;
    }

    public void setDateofpublishing(String dateofpublishing) {
        this.dateofpublishing = dateofpublishing;
    }

    //пустой конструктор тк ругается при чтении из файла
    //Class.forName( имя  класса).newInstance().
    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", usrs=" + users +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", dateOfPublishing='" + dateofpublishing + '\'' +
                ", price=" + price +
                ", Shop=" + shop +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Shop> getShop() {
        return shop;
    }

    public void setShop(Collection<Shop> Shop) {
        this.shop = shop;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    // переопредлили equals и hashCode, чтобы нельзя было добавить книги со всеми одинковыми параметрами
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Double.compare(orders.price, price) == 0 &&
                category.equals(orders.category) &&
                Objects.equals(title, orders.title) &&
                Objects.equals(users, orders.users) &&
                Objects.equals(dateofpublishing, orders.dateofpublishing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, title, users, dateofpublishing, price);
    }

    //метод для сравнения в сортировке
    @Override
    public int compareTo(Orders o) {
        return (int) (this.getPrice() - o.getPrice());
    }
}




package lab6.lab6.Entities;

import lab6.lab6.Annotations.Column;
import lab6.lab6.Annotations.Entity;
import lab6.lab6.Annotations.ManyToOne;

@Entity(name = "Users")
public class Users {
    @Column(name = "email")
    public String email;
    @Column(name = "password")
    public String password;
    @Column(name = "address")
    public String address;
    @Column(name = "isAdmin")
    public boolean isAdmin;
    @Column(name = "cart")
    @ManyToOne(rightClass = Cart.class)
    public Cart cart;

    public Users(String email, String password, String address, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.isAdmin = isAdmin;
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void addItem(Item item) {
        cart.addItem(item);
    }
}

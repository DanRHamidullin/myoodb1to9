package lab8.classes;



import lab8.annotation.*;


import java.util.List;
import java.util.Objects;

@Entity(name = "Users")
public class Users extends Person {
    @Id
    Long id;

    @Column
    String info;


    @OneToMany
    List<Orders> orders;


    //пустой конструктор тк ругается при чтении из файла
    public Users() {
    }

    public Users(String name, String otchestvo, String lastName, String info) {
        super(name, otchestvo, lastName);
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public String getFullName() {
        return name + " " + otchestvo + " " + lastname;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", book=" + orders +
                ", name='" + name + '\'' +
                ", otchestvo='" + otchestvo + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users Users = (Users) o;
        return Objects.equals(info, Users.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}

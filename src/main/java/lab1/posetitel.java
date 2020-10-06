package lab1;

public class posetitel {
    private String firstName;
    private String lastName;
    private String mail;
    private String adress_dostavk;

    public posetitel() {
    }

    public posetitel(String firstName, String lastName, String mail, String adress_dostavk) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.adress_dostavk = adress_dostavk;
    }

    @Override
    public String toString() {
        return "Клиент " +
                "Имя = " + firstName + '\'' +
                " Фамилия = " + lastName + '\'' +
                " Электронная почта :" + mail + '\'' +
                " Адрес доставки " + adress_dostavk + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdress_dostavk() {
        return adress_dostavk;
    }

    public void setAdress_dostavk(String adress_dostavk) {
        this.adress_dostavk = adress_dostavk;
    }
}
package lab1;

import java.util.List;

public class Client extends posetitel {

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Client() {
    }

    private List<reustarant_accaunt> accounts;

    public List<reustarant_accaunt> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<reustarant_accaunt> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Посетитель: " + getLastName() +
                "  заказа=" + accounts +
                '\n';
    }
}

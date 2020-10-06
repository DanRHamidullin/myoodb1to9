package lab1;

import java.util.List;

public class reustarant {

    private String numberorder;

    private List<Client> visitor;

    private List<sum> sum;

    private List<reustarant_accaunt> waiter;

    public String getorder() {
        return numberorder;
    }

    public void setorder(String name) {
        this.numberorder = name;
    }

    public List<Client> getVisitor() {
        return visitor;
    }

    public void setVisitor(List<Client> visitor) {
        this.visitor = visitor;
    }

    public List<sum> getSum() {
        return sum;
    }

    public void setSum(List<sum> sum) {
        this.sum = sum;
    }

    public List<reustarant_accaunt> getWaiter() {
        return waiter;
    }

    public void setWaiter(List<reustarant_accaunt> waiter) {
        this.waiter = waiter;
    }

    @Override
    public String toString() {
        return "Ресторан: " +
                "Номер заказа " + numberorder + '\n' +
                " Посетитель: " + visitor + '\n' +
                " Сумма: " + sum + '\n' +
                " Официант:  " + waiter;
    }
}
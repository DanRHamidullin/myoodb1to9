package lab1;

import java.util.Date;

public class sum {

    private reustarant_accaunt reustarant_accaunt;

    private Date datemenu;

    private posetitel posetitel;

    private double amount;

    public sum(reustarant_accaunt reustarant_accaunt, posetitel posetitel, double amount) {
        this.reustarant_accaunt = reustarant_accaunt;
        this.datemenu = new Date();
        this.posetitel = posetitel;
        this.amount = amount;
        if (amount > 0) {
            increaseBalance(amount);
        } else {
            reduceBalance(amount);
        }
    }

    public sum() {
    }

    private void increaseBalance(double amount) {
        reustarant_accaunt.increaseBalance(amount);
    }

    private boolean reduceBalance(double amount) {
        return reustarant_accaunt.reduceBalance(amount);
    }

    public reustarant_accaunt getReustarant_accaunt() {
        return reustarant_accaunt;
    }

    public void setReustarant_accaunt(reustarant_accaunt reustarant_accaunt) {
        this.reustarant_accaunt = reustarant_accaunt;
    }

    public Date getDatemenu() {
        return datemenu;
    }

    public void setDatemenu(Date datemenu) {
        this.datemenu = datemenu;
    }

    public posetitel getPosetitel() {
        return posetitel;
    }

    public void setPosetitel(posetitel posetitel) {
        this.posetitel = posetitel;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

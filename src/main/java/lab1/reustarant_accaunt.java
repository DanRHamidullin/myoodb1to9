package lab1;

public class reustarant_accaunt {

    private long id_ofic;

    private double balance;

    public reustarant_accaunt(long id_ofic) {
        this.id_ofic = id_ofic;
        this.balance = 0;
    }

    public reustarant_accaunt() {
    }

    long getId_ofic() {
        return id_ofic;
    }

    double getBalance() {
        return balance;
    }

    public void setId_ofic(long id_ofic) {
        this.id_ofic = id_ofic;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    protected void increaseBalance(double cash) {
        this.balance += cash;
    }

    protected boolean reduceBalance(double cash) {
        if (balance < cash) {
            return false;
        } else {
            this.balance -= cash;
            return true;
        }
    }

    @Override
    public String toString() {
        return " Аккаунт официанта " +
                " Id официанта =" + id_ofic +
                " Наличие(шт) " + balance +
                '\n';
    }
}
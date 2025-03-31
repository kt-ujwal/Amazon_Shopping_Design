package amazon;

public interface Payment {
    public boolean processPayment(double amount);

    public boolean refund(double totalAmount);
}

package amazon;

public class CardPayment implements Payment{
    Cards card;
    CardPayment(Cards card){
        this.card = card;
    }
    @Override
    public boolean processPayment(double amount) {
        return true;
    }

    @Override
    public boolean refund(double totalAmount) {
        return true;
    }
}

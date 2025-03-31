package amazon;

import java.util.Map;

public class Order {
    private final String orderId;
    private final User user;
    private OrderStatus status;
    private final double totalAmount;
    private final Map<ProductItem,Integer> checkoutItems;


    Order(String orderId, User user) {
        this.orderId = orderId;
        this.user = user;
        this.checkoutItems = user.cart.getItems();
        this.totalAmount = calculateTotalAmounts();
    }

    private double calculateTotalAmounts() {
        double totalAmount = 0;
        for (Map.Entry<ProductItem,Integer> manyItems: checkoutItems.entrySet()) {
            ProductItem items = manyItems.getKey();
            double count = manyItems.getValue();
            totalAmount += count * items.getPrice();
        }
        return totalAmount;
    }

    public OrderStatus processOrder(User user, Payment payment) {
        for(Map.Entry<ProductItem,Integer> manyItems: checkoutItems.entrySet()) {
            int count = manyItems.getValue();
            ProductItem items = manyItems.getKey();
            items.updateQuantity(-count);
        }
        if(payment.processPayment(totalAmount)) {
            this.setStatus(OrderStatus.PENDING);
        }
        else{
            this.setStatus(OrderStatus.CANCELED);
            for(Map.Entry<ProductItem,Integer> manyItems: checkoutItems.entrySet()) {
                int count = manyItems.getValue();
                ProductItem items = manyItems.getKey();
                items.updateQuantity(count);
            }
        }
        return status;

    }



    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean cancelOrder(User user, Payment payment) {
        if(this.status == OrderStatus.PENDING) {

            this.setStatus(OrderStatus.CANCELED);
            return payment.refund(totalAmount);
        }
        System.out.println("Order can't be canceled now");
        return false;
    }
}

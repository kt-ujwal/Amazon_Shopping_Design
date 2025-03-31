package amazon;

public abstract class Customer {
    private Cart cart;
    private Order order;

    public abstract Cart getShoppingCart();
    public abstract boolean addItemToCart();
    public abstract boolean removeItemFromCart();

}

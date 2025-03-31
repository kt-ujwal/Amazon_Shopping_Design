package amazon;

public class User extends Customer{
    public Cart cart;
    public String productName;
    public Catalog catalog;
    private Order order;
    private Account account;
    private String userId;
    public boolean registerAccount(){
        return true;
    }

    @Override
    public Cart getShoppingCart() {
        return cart;
    }

    @Override
    public boolean addItemToCart() {
        ProductItem addItem = catalog.getProductItem(productName);
        if(addItem == null){ return false; }
        else return cart.addItem(addItem);
    }

    @Override
    public boolean removeItemFromCart() {
        ProductItem removeItem = catalog.getProductItem(productName);
        if(removeItem == null){ return false; }
        return cart.removeItem(removeItem);
    }

    public OrderStatus placeOrder(Order order){
        Payment cardPayment = new CardPayment(this.account.getCard(0)) ;
        return order.processOrder(this,cardPayment );
    }

    public void addNewShippingAddress(Address newAddress){
        account.updateShippingAddress(newAddress);
    }

    public void cancelOrder(){
        Payment cardPayment = new CardPayment(this.account.getCard(0)) ;
        order.cancelOrder(this, cardPayment );
    }

    public String getId() {
        return this.userId;
    }

    public Cards getPayment(int selectedCard){
        return this.account.getCard(selectedCard);
    }
}

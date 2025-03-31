package amazon;


public class Guest extends Customer {
    public Cart cart;
    public String productName;
    public Catalog catalog;
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
}

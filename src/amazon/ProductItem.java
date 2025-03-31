package amazon;

public class ProductItem {
    private final Product product;
    private int productQuantity;

    ProductItem(Product product, int productQuantity) {
        this.product = product;
        this.productQuantity = productQuantity;
    }
    public void updateQuantity(int quantity){
        this.productQuantity += quantity;
    }

    public int getQuantity(){
        return this.productQuantity;
    }

    public double getPrice(){
        return this.product.getPrice();
    }
}

package amazon;

public class Product {
    private String productID;
    private String name;
    private String description;
    private double price;
    private Category category;
    private int availableItemCount;
    private Account seller;
    private ProductItem productitem;

    public int getAvailableCount(){
            return availableItemCount;
}

    public boolean updatePrice(double newPrice) {
        this.price = newPrice;
        return true;
    }
    public double getPrice(){
        return this.price;
    }

    public String getId() {
        return this.productID;
    }

    public String getName() {
        return this.name;
    }

    public ProductItem getProductItem() {
        return productitem;
    }
}

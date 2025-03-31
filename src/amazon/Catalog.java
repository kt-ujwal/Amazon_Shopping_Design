package amazon;

import java.util.List;
import java.util.Map;

public class Catalog implements search{

    List<Product> products;
    Map<String,List<Product>> productNames;
    Map<Category,List<Product>> productCategories;

    public Category[] getCategory() {
        return Category.values();
    }
    @Override
    public List<Product> searchByProductCategory(String productName) {
        productName = productName.toUpperCase();
        switch (productName){
            case "ELECTRONICS":
                return productCategories.get(Category.ELECTRONICS);
                case "FOOD":
                    return productCategories.get(Category.FOOD);
                    case "FURNITURE":
                        return productCategories.get(Category.FURNITURE);
                            default:
                                return productCategories.get(Category.OTHER);
        }
    }

    @Override
    public List<Product> searchByProductName(String productName) {
       return productNames.getOrDefault(productName.toUpperCase(),null);
    }

    public ProductItem getProductItem(String productName) {
        List<Product> productList = productNames.getOrDefault(productName.toUpperCase(),null);
        if(productList == null){ return null; }
        for(Product product : productList){
            if(product.getName().equals(productName)){
                return product.getProductItem();
            }
        }
        return null;
    }
}

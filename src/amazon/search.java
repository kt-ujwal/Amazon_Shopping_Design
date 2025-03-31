package amazon;

import java.util.List;

public interface search {
    public List<Product> searchByProductCategory(String productName);
    public List<Product> searchByProductName(String productName);
}

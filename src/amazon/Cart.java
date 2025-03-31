package amazon;

import java.util.Map;

public class Cart {
    public Map<ProductItem,Integer> items;

    public boolean addItem(ProductItem item) {
        items.put(item, items.getOrDefault(item,0)+1);
        return true;
    }

    public boolean removeItem(ProductItem item) {
        if(items.containsKey(item)) {
            items.remove(item);
            return true;
        }
        return false;

    }
    public boolean updateItemQuantity(ProductItem item, int quantity) {
        items.putIfAbsent(item, quantity);
        return true;
    }

    public Map<ProductItem,Integer> getItems() {
        return items;
    }

    public void clearCart(){
        this.items.clear();
    }

    // stub
    public boolean checkout() {return true;}
}

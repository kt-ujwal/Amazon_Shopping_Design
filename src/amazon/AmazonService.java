package amazon;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AmazonService {
    private static AmazonService instance;
    private final Map<String, User> users;
    private final Map<String, Product> products;
    private final Map<String, Order> orders;

    private AmazonService() {
        users = new ConcurrentHashMap<>();
        products = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
    }

    public static AmazonService getInstance() {
        if (instance == null) {
            synchronized(AmazonService.class) {
                if (instance == null) {
                    instance = new AmazonService();
                }
            }
        }
        return instance;
    }

    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public synchronized Order placeOrder(User user, Order order) {
        Payment payment = new CardPayment(user.getPayment(0));
        String orderId = generateOrderId();
        order = new Order(orderId,user);
        if(order.processOrder(user,payment) == OrderStatus.PENDING){
            user.cart.clearCart();
        }
        return order;

    }

    private String generateOrderId() {
        return UUID.randomUUID().toString();
    }



}

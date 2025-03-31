package amazon;

import java.util.List;

public class Account {
    public String name;
    public String password;
    public Address shippingAddress;
    public List<Cards> cards;
    public List<Banks> banks;
    AccountStatus status;
    public boolean addProductReview(ProductReview review){
        return true;
    };

    public boolean addProduct(Product product){
        return true;
    }
    public boolean resetPassword(){return true;}

    public List<Cards> getCards(){
        return this.cards;
    }

    public Cards getCard(int index){
        return this.cards.get(index);
    }

    public List<Banks> getBanks(){
        return this.banks;
    }

    public void updateShippingAddress(Address newAddress) {
        this.shippingAddress = newAddress;
    }
}

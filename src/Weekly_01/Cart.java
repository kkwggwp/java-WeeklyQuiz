package Weekly_01;

public class Cart {
    Product[] products;

    Cart(Product[] products) {

        this.products = products;
    }

    int calculateDeliveryCharge() {
        int deliveryCharge = 0;
        double totalWeight = 0;
        int totalPrice = 0;

        for (Product product : products) {
            totalWeight += product.getWeight();
            totalPrice += product.getPrice() - product.getDiscountAmount();
        }

        if (totalWeight >= 10) {
            deliveryCharge = 10000;
        } else if (totalWeight >= 3) {
            deliveryCharge = 5000;
        } else {
            deliveryCharge = 1000;
        }

        if (totalPrice >= 100000) {
            deliveryCharge = 0;
        } else if (totalPrice >= 30000) {
            deliveryCharge -= 1000;
        }

        return deliveryCharge;
    }

}

package Weekly_02;

public class Product implements Promotion {
    private String name;
    private int price;
    private Double weight;

    Product(String name, int price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public int getDiscountAmount() {
        return switch (name) {
            case "grocery" -> 2000;
            case "beauty" -> 10000;
            case "largeAppliance" -> 0;
            default -> 0;
        };
    }
}
package main;

public class GadgetProduct extends Product {
    public GadgetProduct(int id, String name, int price) {
        this.product_id = id;
        this.product_name = name;
        this.product_category = "Gadgets";
        this.product_price = price;
    }
}

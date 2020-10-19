package main;

public class SportProduct extends Product {
    public SportProduct(int id, String name, int price) {
        this.product_id = id;
        this.product_name = name;
        this.product_category = "Sport";
        this.product_price = price;
    }
}

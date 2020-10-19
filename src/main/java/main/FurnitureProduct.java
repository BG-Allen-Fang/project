package main;

public class FurnitureProduct extends Product {
    public FurnitureProduct(int id, String name, int price) {
        this.product_id = id;
        this.product_name = name;
        this.product_category = "Furniture";
        this.product_price = price;
    }
}

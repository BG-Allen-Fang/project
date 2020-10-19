package main;

public abstract class Product implements ProductInterface{
    protected int product_id;
    protected String product_name;
    protected String product_category;
    protected int product_price;

    @Override
    public String getProductInfo() {
        return String.format("Product id: "+getProduct_id()+"\nProduct name: "+getProduct_name()+"\nProduct category: "+getProduct_category()+"\nProduct price: %v",getProduct_price());
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_category() {
        return product_category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_price() {
        return product_price;
    }
}

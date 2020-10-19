package main;

import java.util.*;

public class ProductsController {
    private HashSet<SportProduct> sportProducts;
    private Queue<GadgetProduct> gadgetProducts;
    private LinkedList<FurnitureProduct> furnitureProducts;
    private ArrayList<ClotheProduct> clotheProducts;
    private ArrayList<Product> allProducts;

    public ProductsController() {
        this.sportProducts = new HashSet<>();
        this.gadgetProducts = new ArrayDeque<>();
        this.furnitureProducts = new LinkedList<>();
        this.clotheProducts = new ArrayList<>();
        this.allProducts = new ArrayList<>();

//        Creating products
        Product product1 = new SportProduct(1,"Basketball ball", 25);
        Product product2 = new SportProduct(2,"Soccerball ball", 15);
        Product product3 = new SportProduct(3,"Volleyball ball", 35);
        sportProducts.add((SportProduct) product1);
        sportProducts.add((SportProduct) product2);
        sportProducts.add((SportProduct) product3);

        Product product4 = new GadgetProduct(4,"Smartphone", 525);
        Product product5 = new GadgetProduct(5,"TV", 3000);
        Product product6 = new GadgetProduct(6,"Laptop", 1000);
        gadgetProducts.add((GadgetProduct) product4);
        gadgetProducts.add((GadgetProduct) product5);
        gadgetProducts.add((GadgetProduct) product6);

        Product product7 = new FurnitureProduct(7,"Table", 325);
        Product product8 = new FurnitureProduct(8,"Chair", 40);
        Product product9 = new FurnitureProduct(9,"Sofa", 720);
        furnitureProducts.add((FurnitureProduct) product7);
        furnitureProducts.add((FurnitureProduct) product8);
        furnitureProducts.add((FurnitureProduct) product9);

        Product product10 = new ClotheProduct(10,"T-shirt", 10);
        Product product11 = new ClotheProduct(11,"Jeans", 35);
        Product product12 = new ClotheProduct(12,"Jacket", 90);
        clotheProducts.add((ClotheProduct) product10);
        clotheProducts.add((ClotheProduct) product11);
        clotheProducts.add((ClotheProduct) product12);

        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);
        allProducts.add(product4);
        allProducts.add(product5);
        allProducts.add(product6);
        allProducts.add(product7);
        allProducts.add(product8);
        allProducts.add(product9);
        allProducts.add(product10);
        allProducts.add(product11);
        allProducts.add(product12);
    }

    public Product getProductById(int id){
        int cnt = 0;
        while(allProducts.get(cnt) != null){
            Product prd = allProducts.get(cnt);
            if(prd.getProduct_id() == id)
            {
                return prd;
            }
            cnt++;
        }
        return null;
    }

    public HashSet<SportProduct> getSportProducts() {
        return sportProducts;
    }

    public Queue<GadgetProduct> getGadgetProducts() {
        return gadgetProducts;
    }

    public LinkedList<FurnitureProduct> getFurnitureProducts() {
        return furnitureProducts;
    }

    public ArrayList<ClotheProduct> getClotheProducts() {
        return clotheProducts;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }
}

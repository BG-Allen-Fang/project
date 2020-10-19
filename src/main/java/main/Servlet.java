package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    int id_counter = 0;
    ProductsController productsController = new ProductsController();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Get all products
        if(request.getParameter("all") != null){
            request.setAttribute("products", productsController.getAllProducts());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
//        Get sport products
        if(request.getParameter("sport") != null){
            request.setAttribute("products", productsController.getSportProducts());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
//        Get gadgets products
        if(request.getParameter("gadgets") != null){
            request.setAttribute("products", productsController.getGadgetProducts());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
//        Get furniture products
        if(request.getParameter("furniture") != null){
            request.setAttribute("products", productsController.getFurnitureProducts());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
//        Get clothes products
        if(request.getParameter("clothes") != null){
            request.setAttribute("products", productsController.getClotheProducts());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("delete") != null){
            Cookie[] cookies = request.getCookies();
            for(Cookie c: cookies) {
                if(c.getName().contains("id")){
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if(request.getParameter("id") != null){
            request.setAttribute("cart", "true");
            int id = Integer.parseInt(request.getParameter("id"));
            Product findedProduct = productsController.getProductById(id);
            if(findedProduct != null){
                int findedId = findedProduct.getProduct_id();
                Cookie cookie = new Cookie("id"+id_counter, Integer.toString(findedId));
                id_counter++;
                response.addCookie(cookie);
            }
        }
        if(request.getParameter("cart") != null){
            Cookie[] cookies = request.getCookies();
            Map cart_products = new HashMap();
            int sum = 0, cnt = 0;
            for(Cookie c: cookies) {
                if(c.getName().contains("id")){
                    int p_id = Integer.parseInt(c.getValue());
                    Product findedItem = productsController.getProductById(p_id);
                    String p_name = findedItem.getProduct_name();
                    int p_price = findedItem.getProduct_price();
                    sum += p_price;
                    cnt++;
                    cart_products.put("<span style=\"display: none\";>"+cnt+"</span>"+p_name, p_price);
                }
            }
            request.setAttribute("cart_products", cart_products);
            request.setAttribute("total_sum", sum);
            request.getRequestDispatcher("cart.jsp?cart=").forward(request, response);
        }
        request.setAttribute("products", productsController.getAllProducts());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}

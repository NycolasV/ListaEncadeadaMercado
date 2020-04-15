package listas.atividade.estruturadedados.uam.controllers;

import java.util.ArrayList;
import listas.atividade.estruturadedados.uam.linkedlist.*;
import listas.atividade.estruturadedados.uam.models.*;

/**
 * @author NycolasVieira
 */
public class ProductController {
    
    private static LinkedList<Product> productList;

    public ProductController() {
        this.productList = new LinkedList<>();
    }
    
    public String showProductList(){
        return productList.showList();
    }
    
    public ArrayList<Product> getProductList(){
        return productList.getAllValues();
    }

    public Product getProduct(Product product){
        return productList.getValue(product);
    }
    
    public Product getProduct(int code){
        return getProductList()
                .stream()
                .filter(s -> s.getCode() == code)
                .findFirst().get();
    }
    
    public Product createProduct(Product product){
        if(product != null){
            product.setCode();
            var result = productList.insertStart(product);
            return (Product)result.value;
        }
        
        return null;
    }
    
    public void updateProduct(String name, String brand, double price, Sector sector, Product product) throws Exception{
        product.setName(name);
        product.setBrand(brand);
        product.setPrice(price);
        product.setSector(sector);
    }
    
    public void deleteProduct(int code){
        var product = getProduct(code);
        
        productList.removeNode(product);
    }
    
    public void deleteLastProduct(){
        productList.removeStart();
    }
}

package com.java.demo.dao;
import java.util.*;

import com.java.exception.CustomerNotFoundException;
import com.java.exception.OrderNotFoundException;
import com.java.exception.ProductNotFoundException;
import com.java.model.*;

public interface  OrderProcessorRepository {
	
	 boolean createProduct(Product product);

	 boolean createCustomer(Customer customer);

	 boolean deleteProduct(int productId) throws ProductNotFoundException ;

     boolean deleteCustomer(int customerId) throws CustomerNotFoundException;

     boolean addToCart(Customer customer, Product product, int quantity);

     boolean removeFromCart(Customer customer, Product product);

     List<Product> getAllFromCart(Customer customer);

     boolean placeOrder(Customer customer, List<Map<Product, Integer>> products, String shippingAddress);

     List<Map<Product, Integer>> getOrdersByCustomer(int customerId) throws CustomerNotFoundException, OrderNotFoundException;
}

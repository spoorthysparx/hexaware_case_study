package com.java.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import com.java.model.*;
import com.java.demo.dao.*;
import com.java.exception.CustomerNotFoundException;
import com.java.exception.ProductNotFoundException;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void createProductTest() {
		Product p = new Product();
		p.setName("test product");
		p.setDescription("desc");
		p.setProduct_id(200);
		p.setPrice(500.0);
		p.setStockQuantity(10);
		
		OrderProcessorRepositoryImpl o = new OrderProcessorRepositoryImpl();
		boolean isCreated = o.createProduct(p);
		
		assertTrue(isCreated);
		
	}
	
	@Test
	void createCartTest() {
		Product p = new Product();
		p.setName("test product");
		p.setDescription("desc");
		p.setProduct_id(200);
		p.setPrice(500.0);
		p.setStockQuantity(10);
		
		Customer c = new Customer();
		c.setCustomer_id(999);
		c.setEmail("spoorthy");
		c.setName("Spoorthy");
		c.setPassword("spoorthy123");
		
		
		OrderProcessorRepositoryImpl o = new OrderProcessorRepositoryImpl();
		boolean isCreated = o.addToCart(c, p, 1);
		
		assertTrue(isCreated);
	}
		
	@Test
	void placeOrderTest() {
		 int customer_id = 999;		
		 String shippingAddress = "chennai";
		 
		 OrderProcessorRepositoryImpl opri = new OrderProcessorRepositoryImpl();
		 Customer c = opri.getCustomerById(customer_id);
		 List<Map<Product,Integer>> productQuantityMap =  opri.getProductQuantityFromCart(c);
		 
		 boolean isOrderPlaced = opri.placeOrder(c, productQuantityMap, shippingAddress);
		 
		 assertTrue(isOrderPlaced);
	}
	
	@Test
	void checkExceptionForProduct() {
		int productId = 1000;
		OrderProcessorRepositoryImpl opri = new OrderProcessorRepositoryImpl();
		try {
			boolean isDeleted=opri.deleteProduct(productId);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void checkExceptionForCustomer() {
		int customerId = 1000;
		OrderProcessorRepositoryImpl opri = new OrderProcessorRepositoryImpl();
		try {
			boolean isDeleted=opri.deleteCustomer(customerId);
			System.out.println(isDeleted);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

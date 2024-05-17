package com.java.demo.service;
import com.java.model.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.demo.dao.OrderProcessorRepositoryImpl;
import com.java.exception.CustomerNotFoundException;
import com.java.exception.OrderNotFoundException;
import com.java.exception.ProductNotFoundException;


public class Ecomerceservice {
	Scanner sc;
	OrderProcessorRepositoryImpl opri;
	
	public Ecomerceservice()
	{
		sc= new Scanner(System.in);
		opri= new OrderProcessorRepositoryImpl();
	}
	

	 
	 public void createCustomer() {
		
		 //add(c)
		 Customer customer= new Customer();
		 System.out.println("enter customer id");
		 customer.setCustomer_id(sc.nextInt());
		 sc.nextLine();
		 System.out.println("enter name");
		 customer.setName(sc.nextLine());
		 sc.nextLine();
		 System.out.println("enter email");
		 customer.setEmail(sc.nextLine());
		 sc.nextLine();
		 System.out.println("enter password");
		 customer.setPassword(sc.nextLine());
		 opri.createCustomer(customer);
	 }
	 
	 public void createProduct() {
		 Product product= new Product();
		 System.out.println("enter product id");
		 product.setProduct_id(sc.nextInt());
		 sc.nextLine();
		 System.out.println("enter name");
		 product.setName(sc.nextLine());
		 sc.nextLine();
		 System.out.println("enter price");
		 product.setPrice(sc.nextDouble());
		 sc.nextLine();
		 System.out.println("enter description");
		 product.setDescription(sc.nextLine());
		 System.out.println("enter quantity");
		 product.setStockQuantity(sc.nextInt());
		 opri.createProduct(product);
	 }
	 
	 public void deleteProduct() throws ProductNotFoundException {
		 int productID;
		 System.out.println("enter product id");
		 productID=sc.nextInt();
		 opri.deleteProduct(productID);
	 }
	 
	 public void deleteCustomer() throws CustomerNotFoundException {
		 int customerID;
		 System.out.println("enter customer id");
		 customerID=sc.nextInt();
		 opri.deleteCustomer(customerID);
	 }
	 
	 public void addToCart() {
		 int customer_id,product_id,quantity;
		 System.out.println("enter customer id");
		 customer_id=sc.nextInt();
		 Customer c = opri.getCustomerById(customer_id);
		 System.out.println("enter product id");
		 product_id=sc.nextInt();
		 Product p = opri.getProductById(product_id);
		 System.out.println("enter quantity");
		 quantity=sc.nextInt();
		 opri.addToCart(c,p,quantity);
	 }
	 
	 public void removeFromCart() {
		 int customer_id,product_id;
		 System.out.println("enter customer id");
		 customer_id=sc.nextInt();
		 Customer c = opri.getCustomerById(customer_id);
		 System.out.println("enter product id");
		 product_id=sc.nextInt();
		 Product p = opri.getProductById(product_id);
		 opri.removeFromCart(c, p);
	 }
	 
	 public void getAllFromCart() {
		 int customer_id;
		 System.out.println("enter customer id");
		 customer_id=sc.nextInt();
		 Customer c = opri.getCustomerById(customer_id);
		 List<Product> products =  opri.getAllFromCart(c);
		 
		 for( Product p : products) {
			 System.out.println(p.toString());
		 }
	 }
	 
	 public void placeOrder() {
		 //Get product Quantity from Cart
		 int customer_id;
		 System.out.println("Enter customer id :");
		 customer_id = sc.nextInt();
		 sc.nextLine();
		 String shippingAddress;
		 System.out.println("Enter shippingAddress :");
		 shippingAddress = sc.nextLine();
		 
		 Customer c = opri.getCustomerById(customer_id);
		 List<Map<Product,Integer>> productQuantityMap =  opri.getProductQuantityFromCart(c);
		 System.out.println("productQuantityMap");
		 System.out.println(productQuantityMap);
		 opri.placeOrder(c, productQuantityMap, shippingAddress);
	 }
	 
	 public void getOrdersByCustomer() throws CustomerNotFoundException, OrderNotFoundException {
		 int customer_id;
		 System.out.println("Enter customer id :");
		 customer_id = sc.nextInt();
		 
		 List<Map<Product, Integer>> productQuantityMapList = opri.getOrdersByCustomer(customer_id);
		if(productQuantityMapList != null) {
		 for(Map<Product, Integer> i: productQuantityMapList) {
				for(Map.Entry<Product, Integer> entry : i.entrySet()) {
					Product p = entry.getKey();
					int q = entry.getValue();
					
					System.out.println("Product : " + p.toString() + ", Quantity : " + q);
				}
		}}
		
		 
	 }
}

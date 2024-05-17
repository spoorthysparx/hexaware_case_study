package com.java.client;
import java.util.Scanner;

import com.java.demo.service.Ecomerceservice;
import com.java.exception.CustomerNotFoundException;
import com.java.exception.OrderNotFoundException;
import com.java.exception.ProductNotFoundException;
import com.java.util.*;

public class Main {
	public static void main(String [] args) {
		Ecomerceservice eser=new Ecomerceservice();
		
		Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. register customer");
            System.out.println("2. create product");
            System.out.println("3. delete product");
            System.out.println("4. Add to cart");
            System.out.println("5. view cart");
            System.out.println("6. place order");
            System.out.println("7. view customer order");
            System.out.println("8. exit");
            System.out.println("Enter your choice");

            int ch = sc.nextInt();
            if(ch==1) {
            	eser.createCustomer();
            }
            else if(ch==2) {
            	eser.createProduct();
            }
            else if(ch==3) {
            	try {
					eser.deleteProduct();
				} catch (ProductNotFoundException e) {
					e.printStackTrace();
				}
            	
            }
            else if(ch==4) {
            	eser.addToCart();
            }
            else if(ch==5) {
				eser.getAllFromCart();
            }
            else if(ch==6) {
            	eser.placeOrder();
            }
            else if(ch==7) {
            	try {
					eser.getOrdersByCustomer();
				} catch (CustomerNotFoundException e) {
					e.printStackTrace();
				} catch (OrderNotFoundException e) {
					e.printStackTrace();
				}
            }
            else {
            	break;
            }
        }

		sc.close();
		
	}
}

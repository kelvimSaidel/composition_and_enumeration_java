package application;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat bdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);
		
		int OrderNumbers = 0;
		String name;
		String email;
		Date birthDate;
		OrderStatus orderStatus;
		
		System.out.println("Enter client Data:");
		System.out.print("Name:");
		name = read.nextLine();
		System.out.print("Email:");
		email = read.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY):");
		birthDate = bdf.parse(read.next());
		
	  	Client client = new Client(name, email, birthDate);
	  	
		System.out.println("Enter order data:");
		System.out.print("Status:");
		orderStatus = OrderStatus.valueOf(read.next());
		
		Order order = new Order(new Date(), orderStatus,client);
				
		System.out.print("How many items to this order?");
		OrderNumbers = read.nextInt();
		
		
		for (int i=1; i<=OrderNumbers; i++) {
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name:");
			read.nextLine();
			String productName = read.nextLine();
			System.out.print("Product price:");
			Double productPrice = read.nextDouble();
			System.out.print("Quantity:");
			int productQuantity = read.nextInt();
			
		    Product product = new Product(productName, productPrice);	
		    
			OrderItem orderItem = new OrderItem(productQuantity, productPrice,product);
			
			order.addItem(orderItem);
			
		}
		   System.out.println();
		   System.out.println(order);
	       
		
	    read.close();

	}

}

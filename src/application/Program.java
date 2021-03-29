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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate); // cliente instanciado com os dados digitados pelo usuário
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next()); //usuário digitiou em string, o programa leu em OrderStatus (valueOf converte o String para o valor correspondente no OrderStatus)
		
		Order order = new Order(new Date(), status, client); //instanciando o pedido
		
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		for (int i=0; i<N; i++) { 
			System.out.println("Enter #" + (i+1) + " item data:"); // i+1 pq o i ta começando com 0
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			//instanciar os objetos: o produto, depois o item de pedido associado ao produto e depois inserir o item no pedido
			
			Product product = new Product(productName, productPrice);
			
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			order.addItem(it);
				
		}
	
		System.out.println(order); 
		
		sc.close();
	}
}

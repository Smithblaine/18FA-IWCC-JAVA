/* Blaine Smith
 * Program 2, September 21,2018
 * NONE
 * This program will allow the user to enter in orders for sandwiches where it will then,
 * return the cost of individual items then it will display the total cost of the order.
 */
package bSmith_Prog2;
import java.util.Scanner;
public class SandwichOrders {
	
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		
		printWelcome();
		int number = getNumOrders();
		Sandwich [] sandwich = new Sandwich[number];
		
		for (int i = 0; i < number; i++)
		{
			sandwich[i] = makeSandwich(i);
			getCoupon(sandwich[i]);
			sandwich[i].printSandwich();
		}
		
		orderTotal(sandwich);
		scnr.close();
	}
	
	
	public static void printWelcome() 
	{
		System.out.println("Welcome to Sammy's Samwiches Online Ordering\n");
	}
	
	
	public static int getNumOrders()
	{
		System.out.print("How many sandwiches will be in this order?  ");
		int number = scnr.nextInt();
		scnr.nextLine();
		return number;
	}
	
	
	public static Sandwich makeSandwich(int orderNumber)
	{
			String bread = "";
			String filling = "";
			int size = 0;
			
			System.out.printf("\nFor order %d:",orderNumber+1);
			System.out.print("\nWhat bread would you like?  ");
			bread = scnr.nextLine();
			
			System.out.print("What filling would you like?  ");
			filling = scnr.nextLine();
			
			System.out.print("What size, in inches do you want your sandwich?  ");
			size = scnr.nextInt();
			scnr.nextLine();

			Sandwich sandwich = new Sandwich(bread, filling, size);
		return sandwich;
	}
	
	
	public static void getCoupon(Sandwich sandwich)
	{
		boolean coupons = false;
		
		System.out.print("Do you have a coupon (yes or no)?  ");
		String coupon = scnr.nextLine();
		
		while(!coupon.equalsIgnoreCase("yes") && !coupon.equalsIgnoreCase("no"))
		{
			System.out.println("I did not understand, please respond with yes or no.");
			System.out.print("Do you have a coupon (yes or no)?  ");
			coupon = scnr.nextLine();
		}
		
		if (coupon.equalsIgnoreCase("yes"))
		{
			coupons = true;
		}

		sandwich.setCoupon(coupons);
	}
	
	
	public static void orderTotal(Sandwich[] sandwich)
	{
		int i;
		double totalCost = 0.0;
		for (i = 0; i < sandwich.length; i++)
		{
			totalCost += sandwich[i].getPrice();
		}

		System.out.printf("\nThe total cost for %d sandwiches is $%.2f.\n\n", i, totalCost);
		System.out.println("Thank you for ordering with Sammy's Samwiches.");
	}
}

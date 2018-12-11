/* Blaine Smith
 * Program 3, October 16,2018
 * NONE
 * This program will allow the user to loan out money and from the information given it will either approve or deny the loan.
 */
package bSmith_Prog3;

import java.util.Scanner;

public class CreateLoans {

	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		int count = 0;
		String answer = "yes";
		Loan[] loans = new Loan[10];
		
		welcome();
		for (int i = 0; i < loans.length && answer.equalsIgnoreCase("yes"); i++)
		{
			count++;
			
			loans[i] = loanMaker(i);
			System.out.print("\nWould you like to setup another loan?  ");
			answer = scnr.nextLine();
			System.out.println();
		}
		for (int i = 0; i < count; i++)
		{
			System.out.println(loans[i].toString());
		}
		end();
		scnr.close();
	}
	
	public static void welcome()
	{
		System.out.println("Welcome to Blaine Smith Loan Office\n");
	}
	
	public static void end()
	{
		System.out.println("Thanks for doing business with Blaine Smith Loan Office");
	}
	
	public static Loan loanMaker(int index)
	{
		Loan loan;
		String type = getType();
		String name = getName(type);
		double loanAmount = getLoan();
		int term = getTerm();
		loan = type.equals("business") ? new BusinessLoan(name, index, loanAmount, term) : new PersonalLoan(name, index, loanAmount, term);
		
		return loan;
	}
	
	public static String getType()
	{
		String type;
		
		System.out.print("Are you appyling for a business or a personal loan?  ");
		type = scnr.nextLine();
		while (!(type.equalsIgnoreCase("business") || type.equalsIgnoreCase("personal")))
		{
			System.out.print("Incorrect data entered... Try again:  ");
			type = scnr.nextLine();
		}
		
		return type.equalsIgnoreCase("business") ? "business" : "per"; 
	}
	
	public static String getName(String type)
	{
		String name;
		
		System.out.printf("What is %s?  ", type.equals("business") ? "the name of your business" : "your name");
		name = scnr.nextLine();
		
		return name;
	}
	
	public static double getLoan()
	{
		double loanAmount;
		
		System.out.print("How much are you loaning?  ");
		loanAmount = scnr.nextDouble();
		while (loanAmount >  100000.0 || loanAmount <  0)
		{
			System.out.print("Incorrect data entered... Try again:  ");
			loanAmount = scnr.nextDouble();
		}
		
		return loanAmount;
	}
	
	public static int getTerm() 
	{
		int term;
		
		System.out.print("What is the term of this loan?  ");
		term = scnr.nextInt();
		scnr.nextLine();
		
		return term;
	}
}

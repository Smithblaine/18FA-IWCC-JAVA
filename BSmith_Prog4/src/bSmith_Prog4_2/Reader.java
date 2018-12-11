/* Blaine Smith 
 * Program 4 Due November 21st, 2018 
 * None
 * This program will allow a user to enter in items that will then be written to a text file.
 * After entering some items to the text file the user is then able to read from the file as to see what is in the text file.
*/
package bSmith_Prog4_2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader 
{
	public static Scanner scnr = new Scanner(System.in);

	
	public static void main()
	{
		greeting();
		int choice = searchTerms();
		try
		{
			printChoice(choice);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	
	public static void greeting() {
		System.out.println("\nYou have selected to read from the file.");
	}
	
	
	public static int searchTerms()
	{
		System.out.println("1.) Display the entire file\n"
						 + "2.) Display a customer by first name\n"
						 + "3.) Display a customer by last name\n"
						 + "4.) Display a customer by balance ranges");
		System.out.print("Enter your choice:  ");
		int userChoice = scnr.nextInt();
		scnr.nextLine();
		while(userChoice < 1 || userChoice > 4) {
			System.out.println("The selection that was made is not available. Try again.");
			System.out.print("Enter your choice:  ");
			userChoice = scnr.nextInt();
			scnr.nextLine();
		}
		return userChoice;
	}
	
	
	public static void printChoice(int userChoice) throws IOException
	{
		File file = new File("CustomerRecords.txt");
		int id = 0;
		String firstName = "";
		String lastName = "";
		int balance = 0;
		
		if(!file.exists())
		{
			System.out.println("File does not exist. Program ending");
			System.exit(1);
		}
		Scanner reader = new Scanner(file);
		
		switch(userChoice)
		{
			case 1:
				while(reader.hasNext())
				{
					id = reader.nextInt();
					firstName = reader.next();
					lastName = reader.next();
					balance = reader.nextInt();
					System.out.printf("\nID: %d\nFirst name: %s\nLast name: %s\nBalance owed: %d\n", id, firstName, lastName, balance);
				}
				break;
			case 2:
				System.out.print("\nEnter the first name:  ");
				String fname = scnr.nextLine();
				
				while(reader.hasNext())
				{
					id = reader.nextInt();
					firstName = reader.next();
					lastName = reader.next();
					balance = reader.nextInt();
					if(fname.equalsIgnoreCase(firstName))
					{
						System.out.printf("\nID: %d\nFirst name: %s\nLast name: %s\nBalance owed: %d\n", id, firstName, lastName, balance);
					}
				}
				break;
			case 3:
				System.out.print("\nEnter the last name:  ");
				String lname = scnr.nextLine();
				
				while(reader.hasNext())
				{
					id = reader.nextInt();
					firstName = reader.next();
					lastName = reader.next();
					balance = reader.nextInt();
					if(lname.equalsIgnoreCase(lastName))
					{
						System.out.printf("\nID: %d\nFirst name: %s\nLast name: %s\nBalance owed: %d\n", id, firstName, lastName, balance);
					}
				}
				break;
			case 4:
				System.out.print("\nEnter the first number range:  ");
				int rangeOne = scnr.nextInt();
				System.out.print("Enter the second number range:  ");
				int rangeTwo = scnr.nextInt();
				while(rangeTwo < rangeOne || rangeOne < 0 || rangeOne > 10000 || rangeTwo < 0 || rangeTwo > 10000) 
					{
						System.out.println("\nThe second number may not be larger than the first number.\nNumbers may not be less than 0 or greater than 10,000  Try again");
						System.out.print("\nEnter the first number range:  ");
						rangeOne = scnr.nextInt();
						System.out.print("Enter the second number range:  ");
						rangeTwo = scnr.nextInt();
					}
				while(reader.hasNext())
				{
					id = reader.nextInt();
					firstName = reader.next();
					lastName = reader.next();
					balance = reader.nextInt();
					
					if(rangeOne <= balance && rangeTwo >= balance)
					{
						System.out.printf("\nID: %d\nFirst name: %s\nLast name: %s\nBalance owed: %d\n", id, firstName, lastName, balance);
					}
				}
				break;
		}
		reader.close();
	}
}

/* Blaine Smith 
 * Program 4 Due November 21st, 2018 
 * None
 * This program will allow a user to enter in items that will then be written to a text file.
 * After entering some items to the text file the user is then able to read from the file as to see what is in the text file.
*/
package bSmith_Prog4_1;
import bSmith_Prog4_2.Reader;
import java.util.Scanner;
import java.io.*;

public class Writer 
{
	private static Scanner scnr = new Scanner(System.in);
	
	public static void main(String []args) throws IOException
	{
		String firstName;
		String lastName;
		int balanceOwed;
		boolean again = false;
		int id;
		
		String readOrWrite = Greeting();
		if(readOrWrite.equals("r")) 
		{
			Reader.main();
		}
		else{
			do
			{
				id = gatherId();
				firstName = firstName();
				lastName = lastName();
				balanceOwed = balanceOwed();
				if(again)
				{
					writerAppend(id, firstName, lastName, balanceOwed);
				}
				else
				{
					writerStart(id, firstName, lastName, balanceOwed);
				}
				again = addEntries();
			} while (again);
		enterReader();
		scnr.close();
		}
	}
	
	
	public static String Greeting() 
	{
		System.out.println("\nWelcome to the File Writer/Reader program.");
		System.out.println("Would you like to Write to the file or read from the file\n");
		System.out.println("Please enter (W) for writing to the file. \n"
						 + "Please enter (R) to read from the file.");
		System.out.print("\nSelect your choice:  ");
		String userInput = scnr.nextLine();
		return userInput.toLowerCase().trim();
	}
	
	
	public static int gatherId()
	{
		System.out.print("\nEnter your ID number:  ");
		int userId = scnr.nextInt();
		scnr.nextLine();
		
		while(String.valueOf(userId).length() > 4 || String.valueOf(userId).length() < 4)
		{
			System.out.println("\nSorry your ID number may not be Less than 4 digits or larger than 4 digits.  Try again.");
			System.out.print("\nEnter your ID number:  ");
			userId = scnr.nextInt();
			scnr.nextLine();
		}
		return userId;
	}
	
	
	public static String firstName() 
	{
		System.out.print("Enter the first name:  ");
		String firstName = scnr.nextLine();
		firstName.trim();
		return firstName;
	}
	
	
	public static String lastName() 
	{
		System.out.print("Enter the last name:  ");
		String lastName = scnr.nextLine();
		lastName.trim();
		return lastName;
	}
	

	public static int balanceOwed()
	{
		System.out.print("Enter your balance owed:  ");
		int balance = scnr.nextInt();
		scnr.nextLine();
		
		while(balance > 10000)
		{
			System.out.println("The loan amount may not be greater than 10,000.");
			System.out.print("Enter your balance owed:  ");
			balance = scnr.nextInt();
			scnr.nextLine();
		}
		return balance;
	}
	
	
	public static boolean addEntries()
	{
		boolean yes = false;
		System.out.print("\nWould you like to add another entry (Y or N)?  ");
		String again = scnr.nextLine();
		again.toLowerCase().trim();
		
		if (again.equals("y"))
		{
			yes = true;
		}
		return yes;
	}
	
	
	public static void writerStart(int id, String firstName, String lastName, int balanceOwed) throws IOException
	{
		try
		{
			File file = new File ("CustomerRecords.txt");
			PrintWriter output = new PrintWriter(file);
			output.printf("%d %s %s %d", id, firstName, lastName, balanceOwed);
			output.close();
		}
		catch(IOException ioe) 
		{
			System.out.println("Exception encountered:");
			ioe.printStackTrace();
		}
	}
	
	
	public static void writerAppend(int id, String firstName, String lastName, int balanceOwed)throws IOException
	{
		try
		{
			File file = new File("CustomerRecords.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			
			BufferedWriter buffWriter = new BufferedWriter(new FileWriter("CustomerRecords.txt",true));
			buffWriter.newLine();
			buffWriter.write(String.format("%d %s %s %d", id, firstName, lastName, balanceOwed));
			buffWriter.close();
		}
		catch(IOException ioe) 
		{
			System.out.println("Exception encountered:");
			ioe.printStackTrace();
		}
	}
	
	
	public static void enterReader() {
		System.out.println("\nWould you like to read from this file now? (Y) \nor would you like to end the program? (N)");
		System.out.print("Enter your choice:  ");
		String answer = scnr.nextLine();
		answer.toLowerCase().trim();
		
		if (answer.equals("y"))
		{
			Reader.main();
		}
	}
}

package bSmith_InheritancePractice;

import java.util.Scanner;
public class IWCCDriver 
{
	private static Scanner scnr = new Scanner(System.in); 
	
	public static void main (String [] args)
	{
		IWCCPerson [] people = new IWCCPerson [4];
		people [0] = new IWCCStudent("John Doe","jdoe123", 123456);
		people [1] = new IWCCStudent("Jonathan Doe","jdoe456", 123456);
		people [2] = new IWCCFaculty("John Magill","jmagill", 946678);
		people [3] = new IWCCStaff("Wonder Woman","wwoman", 785489);
		
		int choice;
		
		do 
		{
			printMenu();
			choice = getChoice();
			if (choice != 8)
			{
				determineAction(choice, people);
			}
		}while(choice != 8);
		scnr.close();
	}
	
	public static void printMenu()
	{
		System.out.println("1) Print all IWCCPeople\n2) Print all IWCCStudents\n3) Print all IWCCFaculty");
		System.out.println("4) Print all IWCCStaff\n5) Print Number of vacation days for all staff\n6) Print GPA of all students");
		System.out.println("7) Determine if any duplicates exist\n8) Quit\n");
	}
	
	public static int getChoice() 
	{
		int choice;
		
			System.out.print("Enter your choice:  ");
			choice = scnr.nextInt();
			while(choice <= 0 || choice > 8)
			{
				System.out.print("Not a valid option. Try again:  ");
				choice = scnr.nextInt();
			}
		
		return choice;
	}
	
	public static void determineAction(int choice, IWCCPerson [] temp)
	{
		switch(choice)
		{
			case 1:
				printAllPeople(temp);
				break;
			case 2:
				printAllStudents(temp);
				break;
			case 3:
				printAllFaculty(temp);
				break;
			case 4:
				printAllStaff(temp);
				break;
			case 5:
				printAllStaffVacation(temp);
				break;
			case 6:
				printAllGpas(temp);
				break;
			case 7:
				findDuplicates(temp);
				break;
		}
	}
	
	
	
	public static void printAllPeople(IWCCPerson [] temp)
	{
		for(IWCCPerson x : temp)
		{
			System.out.println(x);
		}
	}
	
	
	
	public static void printAllStudents(IWCCPerson [] temp)
	{
		for(IWCCPerson x : temp)
		{
			if (x instanceof IWCCStudent)
			{
				System.out.println(x);
			}
		}
	}
	
	
	
	public static void printAllFaculty(IWCCPerson [] temp)
	{
		for(IWCCPerson x : temp)
		{
			if (x instanceof IWCCFaculty)
			{
				System.out.println(x);
			}
		}
	}
	
	
	
	public static void printAllStaff(IWCCPerson [] temp)
	{
		for(IWCCPerson x : temp)
		{
			if (x instanceof IWCCStaff)
			{
				System.out.println(x);
			}
		}
	}
	
	
	
	public static void printAllGpas(IWCCPerson [] temp)
	{
		for(IWCCPerson x : temp)
		{
			if (x instanceof IWCCStudent)
			{
				System.out.printf("%s : %.2f\n", x.getName(), ((IWCCStudent)x).getGPA());
			}
		}
	}
	
	
	
	public static void printAllStaffVacation(IWCCPerson [] temp)
	{
		for(IWCCPerson x : temp)
		{
			if (x instanceof IWCCStudent)
			{
				System.out.println(x);
			}
		}
	}
	
	
	
	public static void printStaffVacation(IWCCPerson [] temp)
	{
		for(IWCCPerson x : temp)
		{
			if (x instanceof IWCCStaff)
			{
				System.out.printf("%s:  %.1f",x.getName(),((IWCCStaff)x).getVacationDaysAvailable());
			}
		}
	}
	
	
	
	public static void findDuplicates(IWCCPerson [] temp)
	{
		boolean found = false;
		for(int i = 1; i < temp.length && !found; i++)
		{
			if (temp[0].equals(temp[i]))
			{
				found = true;
				System.out.println("Found Duplicae\n");
			}
		}
	}
}

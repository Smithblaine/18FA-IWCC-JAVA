/* Blaine Smith
 * Program 1, September 4,2018
 * Matt Clark for the getData method
 * This program will allow the user to enter in as many decimal numbers as they want,
 * then it will display those values along with the Sum, Average, and smallest and largest value.
 */
package bSmith_Prog1;
import java.util.Scanner;
public class SimpleList {
	
	private final int ARRAY_LENGTH = 10;
	private double [] list;
	private double average =0;
	private double large =0;
	private double small =0;
	private double sum;
	private int count;
	
	public SimpleList() 
	{
	System.out.print("Welcome to the Simple List Class\n");
	count =0;
	sum =0;
	list = new double[ARRAY_LENGTH];
	}
	
	public void getData() 
	{
		Scanner scnr = new Scanner(System.in);
		String yesOrNo="";
		boolean nopeNotToday =false;
		for(int i=0;i<list.length;i++)
		{
			boolean valid=true;
			do
			{
				System.out.print("\nEnter a non-negative floating point value:  ");
				double userInput = scnr.nextDouble();
				valid = validInput(userInput);
				if (valid==true)
				{
					list[i]+=userInput;
					scnr.nextLine();
				}
				else
				{
					System.out.print("\nThat is not a valid number.  Try again.\n");
				}
			}while(valid==false);
			
			do
			{
				System.out.print("\nWould you like to input another number (Y or N)?  ");
				yesOrNo =scnr.nextLine();
				
				if(yesOrNo.equalsIgnoreCase("Y"))
				{
					break;
				}
				else if(!yesOrNo.equalsIgnoreCase("Y") && !yesOrNo.equalsIgnoreCase("N"))
				{
					System.out.print("\nI didn't understand your answer.\n");
				}
				else if(yesOrNo.equalsIgnoreCase("N"))
				{
					nopeNotToday = true;
				}
			}while(nopeNotToday == false);
			
			count++;
			
			if(nopeNotToday == true)
			{
				break;
			}
		}
		scnr.close();
	}
	
	public boolean validInput(double num)
	{
		boolean isValid=true;
		if(num < 0.0)
		{
			isValid = false;
		}
		else
		{
		
		}
		return isValid;
	}
	
	public void processData()
	{
		large=list[0];
		small=list[0];
		for(int i=0;i<list.length;i++)
		{
			sum+=list[i];
			average+=list[i]/count;
			if(large<list[i])
			{
				large=list[i];
			}
			if(small>list[i] && list[i]!=0.0)
			{
				small=list[i];
			}
		}
	}
	
	public void displayResults()
	{
		for(int i=0;i<count;i++)
		{
			if(list[i]>=0.0)
			{
				System.out.printf("\nValue %d = %.6f",i+1,list[i]);
			}
		}
		System.out.printf("\n\nSum of all values = %.6f\n",sum);
		System.out.printf("Average of all the values = %.6f\n",average);
		System.out.printf("Largest value = %.6f\n",large);
		System.out.printf("Smallest value = %.6f",small);
	}
}



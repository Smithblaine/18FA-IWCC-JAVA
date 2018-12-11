/* Blaine Smith
 * Program 3, October 16,2018
 * NONE
 * This program will allow the user to loan out money and from the information given it will either approve or deny the loan.
 */
package bSmith_Prog3;
import java.util.Scanner;

class PersonalLoan extends Loan implements LoanConstants
{
	private String name;
	
	public PersonalLoan(String companyName, int loanNumber, double loanAmount, int lengthOfLoan) 
	{
		super(companyName, loanNumber, loanAmount, lengthOfLoan);
		if (loanAmount <= super.getLOANMAXIMUM())
		{
			approveLoan();
		}
		setInterestRate(0.01 + RATE);
		name = companyName;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	@Override
	public void approveLoan()
	{
		Scanner scnr = new Scanner(System.in);
		double income;
		double expenses;
		
		System.out.print("Please submit your annual income:  ");
		income  = scnr.nextDouble();
		System.out.print("Please submit your monthly expenses:  ");
		expenses  = scnr.nextDouble();
		if (income < 20000 || (income / 12 - expenses) < 100)
		{
			setLoanApproved(false);
		}
		else 
		{
			setLoanApproved(true);
		}
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
}

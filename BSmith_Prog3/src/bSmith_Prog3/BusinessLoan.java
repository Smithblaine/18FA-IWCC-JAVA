/* Blaine Smith
 * Program 3, October 16,2018
 * NONE
 * This program will allow the user to loan out money and from the information given it will either approve or deny the loan.
 */
package bSmith_Prog3;
import java.util.Scanner;

public class BusinessLoan extends Loan implements LoanConstants 
{
	private String businessName;
	
	public BusinessLoan(String companyName, int loanNumber, double loanAmount, int lengthOfLoan) 
	{
		super(companyName, loanNumber, loanAmount, lengthOfLoan);
		if (loanAmount <= super.getLOANMAXIMUM())
		{
			approveLoan();
		}
		setInterestRate(0.01 + RATE);
		businessName = companyName;
	}
	
	public String getBusinessName() 
	{
		return businessName;
	}

	public void setBusinessName(String businessName) 
	{
		this.businessName = businessName;
	}

	@Override
	public void approveLoan()
	{
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Please submit your previous year's profit (Enter negative if it was a loss):  ");
		if (scnr.nextDouble() < 0)
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
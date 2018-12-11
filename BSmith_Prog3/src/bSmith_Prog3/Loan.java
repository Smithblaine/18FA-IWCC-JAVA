/* Blaine Smith
 * Program 3, October 16,2018
 * NONE
 * This program will allow the user to loan out money and from the information given it will either approve or deny the loan.
 */
package bSmith_Prog3;

public abstract class Loan {

	private String companyName;
	private int loanNumber;
	private final double LOANMAXIMUM = 100000.0;
	private double loanAmount;
	private double interestRate;
	private int lengthOfLoan;
	private boolean isLoanApproved;
	
	public Loan()
	{
		companyName = "Need Name";
		loanAmount = 0.0;
	}
	
	public Loan(String companyName, int loanNumber, double loanAmount, int lengthOfLoan) 
	{
		this.companyName = companyName;
		this.loanNumber = loanNumber;
		this.loanAmount = loanAmount;
		if (lengthOfLoan != 1 && lengthOfLoan != 3 && lengthOfLoan != 5)
		{
			this.lengthOfLoan = 1;
		}
		else
		{
			this.lengthOfLoan = lengthOfLoan;
		}
		
		if(loanAmount > LOANMAXIMUM)
		{
			System.out.printf("Loan cannot exceed the max amount of $%.2f\n", LOANMAXIMUM);
			isLoanApproved = false;
		}
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s\n%d: $%.2f, %%%.2f, %d term%s\n%s\n", companyName, loanNumber + 1, loanAmount, interestRate * 100, lengthOfLoan, lengthOfLoan != 1 ? "s" : "", isLoanApproved ? "Aprroved" : "Denied");
	}

	public String getCompanyName() 
	{
		return companyName;
	}

	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}

	public int getLoanNumber() 
	{
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) 
	{
		this.loanNumber = loanNumber;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) 
	{
		this.loanAmount = loanAmount;
	}

	public double getInterestRate() 
	{
		return interestRate;
	}

	public void setInterestRate(double interestRate) 
	{
		this.interestRate = interestRate;
	}

	public int getLengthOfLoan() 
	{
		return lengthOfLoan;
	}

	public void setLengthOfLoan(int lengthOfLoan) 
	{
		this.lengthOfLoan = lengthOfLoan;
	}

	public boolean isLoanApproved() 
	{
		return isLoanApproved;
	}

	public void setLoanApproved(boolean isLoanApproved) 
	{
		this.isLoanApproved = isLoanApproved;
	}

	public double getLOANMAXIMUM() 
	{
		return LOANMAXIMUM;
	}
}

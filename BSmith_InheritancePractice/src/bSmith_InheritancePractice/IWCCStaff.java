/*Blaine Smith, Inheritance Practice, Due September 24
none
This is code to be further built off of to understand polmorphism*/
package bSmith_InheritancePractice;

public class IWCCStaff extends IWCCPerson
{

	private String position;
	private double vacationDaysAvailable;
	private double salary;
	private double yearsOfService;
	
	
	public IWCCStaff ()
	{
		yearsOfService = 0.0;
		vacationDaysAvailable = 0.0;
	}
	
	
	public IWCCStaff (String name, String userName, int id)
	{
		super(name, userName, id);
		yearsOfService = 0.0;
		vacationDaysAvailable = 0.0;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s%s, %.2f\n", super.toString(),position, salary);
	}

	
	@Override
	public void gainKnowledge()
	{
		System.out.println("Go to a meeting.\n");
	}
	
	
	public void getRaise(double raiseRate) 
	{
		salary += salary * (raiseRate / 100);
	}
	
	
	public void takeVacation(double daysOffRequested)
	{
		if(daysOffRequested > 0 && daysOffRequested <= vacationDaysAvailable)
		{
			System.out.println("The days requested have now been deducted from your available vacation days.");
			vacationDaysAvailable -= daysOffRequested;
		}
		else if (daysOffRequested < 0)
		{
			System.out.println("Sorry you do not have that many days available.");
		}
		else
		{
			System.out.printf("Only have %.1f vacation days available. can not take %.1f", vacationDaysAvailable, daysOffRequested);
		}
	}
	
	
	public void increaseVacation(double days)
	{
		vacationDaysAvailable += 5;
	}
	
	
	public String getPosition() 
	{
		return position;
	}
	
	
	public void setPosition(String position) 
	{
		this.position = position;
	}
	
	
	public double getVacationDaysAvailable() 
	{
		return vacationDaysAvailable;
	}
	
	
	public void setVacationDaysAvailable(double vacationDaysAvailable) 
	{
		if(vacationDaysAvailable < 0)
		{
			this.vacationDaysAvailable = 0.0;
		}
		else
		{
			this.vacationDaysAvailable = vacationDaysAvailable;
		}	
	}
	
	
	public double getSalary() 
	{
		return salary;
	}
	
	
	public void setSalary(double salary) 
	{
		if (salary < 0.0)
		{
			this.salary = 0.0;
		}
		else
		{
			this.salary = salary;
		}
	}
	
	
	public double getYearsOfService() 
	{
		return yearsOfService;
	}
	
	
	public void setYearsOfService(double yearsOfService) 
	{
		if (yearsOfService < 0)
		{
			this.yearsOfService = 0.0;
		}
		else
		{
			this.yearsOfService = yearsOfService;
		}
	}
}

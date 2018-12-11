/*Blaine Smith, Inheritance Practice, Due September 24
none
This is code to be further built off of to understand polmorphism*/
package bSmith_InheritancePractice;

public class IWCCFaculty extends IWCCPerson
{

	private String title;
	private double personalDaysAvailable;
	private double salary;
	private boolean overload;
	
	public IWCCFaculty()
	{
		personalDaysAvailable = 2.0;
		title = "Instructor";
	}
	
	public IWCCFaculty(String name, String userName, int id)
	{
		super(name, userName, id);
		personalDaysAvailable = 2.0;
		title = "Instructor";
	}
	
	
	@Override
	public String toString()
	{
		return String.format("%s%s, %.2f\n ", super.toString(), title, salary);
	}

	
	@Override
	public void gainKnowledge()
	{
		System.out.println("Go to Conference.\n");
	}
	
	
	public void promotion()
	{
		if (title.equalsIgnoreCase("Instrucor"))
		{
			title = "Assistant Professor";
		}
		else if (title.equalsIgnoreCase("Assistant Professor"))
		{
			title = "Professor";
		}
	}
	
	public void giveRaise(double raiseRate) 
	{
		salary += salary * (raiseRate / 100);
	}
	
	
	public void takePersonalDay(double daysOffRequested)
	{
		if(daysOffRequested > 0 && daysOffRequested <= personalDaysAvailable)
		{
			System.out.println("The days requested have now been deducted from your available days.");
			personalDaysAvailable -= daysOffRequested;
		}
		else if (daysOffRequested < 0)
		{
			System.out.println("Sorry you do not have that many days available.");
		}
		else
		{
			System.out.printf("Only have %.1f personal days available. can not take %.1f", personalDaysAvailable, daysOffRequested);
		}
	}

	public String getTitle() 
	{
		return title;
	}

	
	public void setTitle(String title) 
	{
		this.title = title;
	}

	
	public double getPersonalDaysAvailable() 
	{
		return personalDaysAvailable;
	}

	
	public void setPersonalDaysAvailable(int personalDaysAvailable) 
	{
		if(personalDaysAvailable < 0)
		{
			this.personalDaysAvailable = 0.0;
		}
		else
		{
			this.personalDaysAvailable = personalDaysAvailable;
		}
	}

	
	public double getSalary() 
	{
		return salary;
	}

	
	public void setSalary(double salary) 
	{
		if(salary < 0)
		{
			this.salary = 0.0;
		}
		else
		{
			this.salary = salary;
		}
	}

	
	public boolean isOverload() 
	{
		return overload;
	}

	
	public void setOverload(boolean overload) 
	{
		this.overload = overload;
	}
}

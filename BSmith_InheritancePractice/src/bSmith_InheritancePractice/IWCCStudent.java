/*Blaine Smith, Inheritance Practice, Due September 24
none
This is code to be further built off of to understand polmorphism*/
package bSmith_InheritancePractice;

public class IWCCStudent extends IWCCPerson 
{

	private double GPA;
	private String major;
	private boolean onCampus;
	
	public IWCCStudent()
	{
		
		GPA = 0.0;
	}
	
	public IWCCStudent(String name, String userName, int id)
	{
		super(name, userName, id);
		GPA = 0.0;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s%s,  %.2f\n", super.toString(), major, GPA);
	}

	
	@Override
	public void gainKnowledge()
	{
		System.out.println("Go to Class.\n");
	}
	
	public void changeHousing()
	{
		onCampus = !onCampus;
	}
	
	
	public double getGPA() 
	{
		return GPA;
	}

	
	public void setGPA(double GPA) 
	{
		if(GPA < 0)
		{
			this.GPA = 0.0;
		}
		else
		{
			this.GPA = GPA;
		}
	}

	
	public String getMajor() 
	{
		return major;
	}
	

	public void setMajor(String major) 
	{
		this.major = major;
	}

	
	public boolean isOnCampus() 
	{
		return onCampus;
	}

	
	public void setOnCampus(String location) 
	{
		if(location.equalsIgnoreCase("Suites") || location.equalsIgnoreCase("Village") || location.equalsIgnoreCase("Tower"))
		{
			onCampus = true;
		}
		else
		{
			onCampus = false;
		}
	}
}

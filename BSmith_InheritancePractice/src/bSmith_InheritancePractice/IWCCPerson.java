/*Blaine Smith, Inheritance Practice, Due September 24
none
This is code to be further built off of to understand polmorphism*/
package bSmith_InheritancePractice;

public abstract class IWCCPerson 
{

	private String name;
	private int idNumber;
	private String rocUserName;
	private String rocEmail;
	private boolean parkingPass;
	
	public IWCCPerson()
	{
		name = "Need Name";
		idNumber = 0;
		rocUserName = "Need Name";
	}
	
	
	public IWCCPerson (String name, String rocUserName, int idNumber) 
	{
		parkingPass = false;
		this.rocUserName = rocUserName;
		setName(name);
		setIdNumber(idNumber);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s, ID:  %d\n", name, idNumber);
	}

	
	@Override
	public boolean equals (Object e)
	{
		boolean samePerson = false;
		if (this.idNumber == ((IWCCPerson)e).idNumber) 
		{
			samePerson = true;
		}
		return samePerson;
	}
	
	public String getName() 
	{
		return name;
	}

	
	public void setName(String name) 
	{
		this.name = name;
	}

	
	public int getIdNumber() 
	{
		return idNumber;
	}

	
	public void setIdNumber(int idNumber) 
	{
		if(idNumber > 0)
		{
			this.idNumber = idNumber;
		}
		else
		{
			System.out.print("That is not a valid number.");
		}
		
	}

	
	public String getRocUserName() 
	{
		return rocUserName;
	}

	
	public void setRocUserName(String rocUserName) 
	{
		this.rocUserName = rocUserName;
	}

	
	public String getRocEmail() 
	{
		return rocEmail;
	}

	
	public void setRocEmail(String rocEmail) 
	{
		this.rocEmail = rocEmail;
	}

	
	public boolean isParkingPass() 
	{
		return parkingPass;
	}

	
	public void setParkingPass(boolean parkingPass) 
	{
		this.parkingPass = parkingPass;
	}
	
	public abstract void gainKnowledge();
}

/* Blaine Smith
 * Program 2, September 21,2018
 * NONE
 * This program will allow the user to enter in orders for sandwiches where it will then,
 * return the cost of individual items then it will display the total cost of the order.
 */
package bSmith_Prog2;

public class Sandwich 
{
	private double price;
	private int size;
	private String bread;
	private String filling;
	private boolean coupon;
	private final double COST_PER_INCH = .50;
	
	public Sandwich ()
	{
		price = 0.0;
		size = 0;
		bread = "White";
		filling = "peanut butter jelly";
		coupon = false;
	}
	
	
	public Sandwich(String bread, String filling, int size)
	{
		this.price = 0.0;
		this.bread = bread;
		this.filling = filling;
		this.size = size;
		this.coupon = false;
	}
	
	
	public void calculatePrice()
	{
		double discount = 0.0;
		price = COST_PER_INCH * size;
		
		if(coupon == true) 
		{
			discount = price * 0.1;
			price = price - discount;
		}
	}
	
	
	public void printSandwich()
	{
		calculatePrice();
		if (coupon == true) 
		{
			System.out.printf("Your sandwich is a %d inch %s sandwich on %s bread and with coupon costs $%.2f.\n",size,filling,bread,price);
		}
		else if(coupon == false)
		{
			System.out.printf("Your sandwich is a %d inch %s sandwich on %s bread and without coupon costs $%.2f.\n",size,filling,bread,price);
		}
	}

	
	public void setPrice(double cost) 
	{
		this.price = cost;
	}

	
	public void setSize(int size) 
	{
		this.size = size;
	}

	
	public void setBread(String bread) 
	{
		this.bread = bread;
	}

	
	public void setFilling(String filling) 
	{
		this.filling = filling;
	}

	
	public void setCoupon(boolean coupon) 
	{
		this.coupon = coupon;
	}

	
	public double getPrice() 
	{
		return price;
	}

	
	public int getSize() 
	{
		return size;
	}

	
	public String getBread() 
	{
		return bread;
	}

	
	public String getFilling() 
	{
		return filling;
	}
	

	public boolean isCoupon() 
	{
		return coupon;
	}
}

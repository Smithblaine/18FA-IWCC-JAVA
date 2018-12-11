/*
 * Blaine Smith 
 * Program 5, Due Wednesday, December 12, 2018
 * NONE
 * This program will allow a user to select what size they would like for a pizza 
 * as well as the toppings then it will display the total for the user.
*/
package bSmith_Prog5;

public class implementBsmithPizza 
{
	public static void main(String [] args) 
	{
		BsmithPizza aFrame = new BsmithPizza();
		
		final int WIDTH = 300;
		final int HEIGHT = 350;
		aFrame.setSize(WIDTH,HEIGHT);
		aFrame.setVisible(true);
	}
}

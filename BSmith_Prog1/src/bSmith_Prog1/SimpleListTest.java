/* Blaine Smith
 * Program 1, September 4,2018
 * Matt Clark for the getData method
 * This program will allow the user to enter in as many decimal numbers as they want,
 * then it will display those values along with the Sum, Average, and smallest and larget value.
 */
package bSmith_Prog1;

public class SimpleListTest 
{
	public static void main(String [] args) 
	{
		SimpleList simpleList = new SimpleList();
		simpleList.getData();
		simpleList.processData();
		simpleList.displayResults();
	}
}

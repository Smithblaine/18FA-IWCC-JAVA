/*
 * Blaine Smith 
 * Program 5, Due Wednesday, December 12, 2018
 * NONE
 * This program will allow a user to select what size they would like for a pizza 
 * as well as the toppings then it will display the total for the user.
*/
package bSmith_Prog5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BsmithPizza extends JFrame implements ItemListener, ActionListener
{
	final int MEDIUM = 9;
	final int LARGE = 11;
	final int DELIVERY = 5;
	final int BASE_PRICE_SMALL = 7;
	final int EXTRA = 1;
	int sides = 0;
	int totalPrice = BASE_PRICE_SMALL;
	
	JLabel smiths = new JLabel("Welcome to Smith's Pizza");
	
	String [] sizes = {"Small $7","Medium $9","Large $11"};
	JComboBox sizeChoice = new JComboBox(sizes);
	
	JCheckBox pickup = new JCheckBox("Pickup",false);
	JCheckBox delivery = new JCheckBox("Delivery ($" + DELIVERY + " extra)",false);
	
	JLabel pizzaToppings = new JLabel("Toppings");
	JLabel extras = new JLabel("No Charge for Cheese. All other toppings, $1.");
	
	JCheckBox cheese = new JCheckBox("Cheese",true);
	JCheckBox pepperoni = new JCheckBox("Pepperoni",false);
	JCheckBox hamburger = new JCheckBox("Hamburger",false);
	JCheckBox sausage = new JCheckBox("Sausage",false);
	JCheckBox pinneapple = new JCheckBox("Pinneapple",false);
	
	JLabel empty = new JLabel("                                       ");
	JLabel empty2 = new JLabel("                                  ");
	JLabel empty3 = new JLabel("                                  ");
	
	JLabel ending = new JLabel("     Total Price");
	JTextField total = new JTextField(6);
	
	JButton finishOrder = new JButton("Send Your Order");
	JLabel thankYou = new JLabel("<html><br>Thank you for your business</html>");
	
	public BsmithPizza() 
	{
		super("Smith's Pizza Online Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		smiths.setFont(new Font("Arial",Font.BOLD, 18));
		pizzaToppings.setFont(new Font("Arial",Font.BOLD, 18));
		thankYou.setVisible(false);
		thankYou.setFont(new Font("Arial",Font.BOLD, 18));
		
		setLayout(new FlowLayout());
		add(smiths);
		add(sizeChoice);
		add(empty);
		add(pickup);
		add(delivery);
		add(pizzaToppings);
		add(extras);
		add(cheese);
		add(pepperoni);
		add(hamburger);
		add(sausage);
		add(pinneapple);
		add(empty2);
		add(ending);
		add(total);
		add(empty3);
		add(finishOrder);
		add(thankYou);
		
		
		sizeChoice.addItemListener(this);
		pickup.addItemListener(this);
		delivery.addItemListener(this);
		cheese.addItemListener(this);
		pepperoni.addItemListener(this);
		hamburger.addItemListener(this);
		sausage.addItemListener(this);
		pinneapple.addItemListener(this);
		total.setText("$"+ totalPrice);
		finishOrder.addActionListener((ActionListener)this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
    {  
		if(finishOrder.isEnabled())
		{
			thankYou.setVisible(true);
		}
    } 
	
	
	@Override
	public void itemStateChanged(ItemEvent event) {
		Object source = event.getSource();
		int selected = event.getStateChange();
		
		if (source == delivery) 
		{
			if(selected == ItemEvent.SELECTED) 
			{
				sides += DELIVERY;
				pickup.setSelected(false);
			}
			else 
			{
				sides -= DELIVERY;
			}
		}
		else if(source == pickup)
		{
			if(selected == ItemEvent.SELECTED) 
			{
				delivery.setSelected(false);
			}
		}
		else if (source == pepperoni) 
		{
			if(selected == ItemEvent.SELECTED) 
			{
				sides += EXTRA;
			}
			else 
			{
				sides -= EXTRA;
			}
		}
		else if(source == hamburger)
		{
			if(selected == ItemEvent.SELECTED) 
			{
				sides += EXTRA;
			}
			else 
			{
				sides -= EXTRA;
			}
		}
		else if(source == sausage)
		{
			if(selected == ItemEvent.SELECTED) 
			{
				sides += EXTRA;
			}
			else 
			{
				sides -= EXTRA;
			}
		}
		else if(source == pinneapple)
		{
			if(selected == ItemEvent.SELECTED) 
			{
				sides += EXTRA;
			}
			else 
			{
				sides -= EXTRA;
			}
		}

		if(source == sizeChoice)
		{
			if(sizeChoice.getSelectedItem().equals("Small $7")) 
			{
				totalPrice = BASE_PRICE_SMALL;
			}
		}
		
		if(source == sizeChoice)
		{
			if(sizeChoice.getSelectedItem().equals("Medium $9")) 
			{
				totalPrice = MEDIUM;
			}
		}
		
		if(source == sizeChoice)
		{
			if(sizeChoice.getSelectedItem().equals("Large $11")) 
			{
				totalPrice = LARGE;
			}
		}

		int headache = totalPrice + sides;
		total.setText("$"+ headache);
	}
}

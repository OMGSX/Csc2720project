/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dylan Monroe
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class VendingMachine1 extends JFrame {

	private JButton cokeButton;
	private JButton dietCokeButton;
	private JButton pepsiButton;
	private JButton SpecialPepsiButton;
	private JButton spriteButton;
	private JButton buyButton;
	private JButton refillButton;
	private JButton collectMoney;
		
	private int cokeQuantity;
	private int dietCokeQuantity;
	private int pepsiQuantity;
	private int SpecialPepsiQuantity;
	private int spriteQuantity;
        private int vending1;
	
	private double totalBill;
	private double totalMachineMoney;	
	
	private JTextField wantedQuantity;
	private JTextField paidMoney;
	
	private JLabel cokeInfo;
	private JLabel dietCokeInfo;
	private JLabel pepsiInfo;
	private JLabel SpecialPepsiInfo;
	private JLabel spriteInfo;
	private JLabel nullField1;
	private JLabel nullField2;
	private JLabel nullField3;
	private JLabel nullField4;
	private JLabel nullField5;
	private JLabel nullField6;
	private JLabel nullField7;
	private JLabel infoScreen;
	private JLabel enterQuantity;
	private JLabel enterMoney;
	
	
	private JPanel buyingOptions;
	private JPanel finishPayment;
	private JPanel screenPanel;
	
	
	
	public VendingMachine1()
	{
		cokeQuantity = 100;
		dietCokeQuantity = 100;
		pepsiQuantity = 100;
		SpecialPepsiQuantity = 100;
		spriteQuantity = 100;
		
		totalBill = 0;
		totalMachineMoney = 0;
		
		buyingOptions = new JPanel();
                getContentPane().setBackground(Color.RED);
		screenPanel = new JPanel();
                getContentPane().setBackground(Color.RED);
		
		cokeButton = new JButton("Coke");
		dietCokeButton = new JButton("Diet Coke");
		pepsiButton = new JButton("Pespi");
		SpecialPepsiButton = new JButton("Special Pepsi");
		spriteButton = new JButton("Sprite");
		buyButton = new JButton("Buy");
		refillButton = new JButton("Refill vending machine");
		collectMoney = new JButton("Money owed");
                getContentPane().setBackground(Color.RED);
		
		ActionListener cokeListener = new cokeHandler();
		cokeButton.addActionListener(cokeListener);
		
		ActionListener dietCokeListener = new dietCokeHandler();
		dietCokeButton.addActionListener(dietCokeListener);
		
		ActionListener pepsiListener = new pepsiHandler();
		pepsiButton.addActionListener(pepsiListener);
		
		ActionListener SpecialPepsiListener = new SpecialPepsiHandler();
		SpecialPepsiButton.addActionListener(SpecialPepsiListener);
                getContentPane().setBackground(Color.yellow);
		
		ActionListener spriteListener = new spriteHandler();
		spriteButton.addActionListener(spriteListener);
		
		ActionListener buyListener = new buyHandler();
		buyButton.addActionListener(buyListener);
		
		ActionListener collectListener = new collectHandler();
		collectMoney.addActionListener(collectListener);
		
		ActionListener refillListener = new refillHandler();
		refillButton.addActionListener(refillListener);
		
		cokeInfo = new JLabel("Quantity: " + cokeQuantity);
		dietCokeInfo = new JLabel("Quantity: " + dietCokeQuantity);
		pepsiInfo = new JLabel("Quantity: " + pepsiQuantity);
		SpecialPepsiInfo = new JLabel("Quantity: " + SpecialPepsiQuantity);
		spriteInfo = new JLabel("Quantity: " + spriteQuantity);
		nullField1 = new JLabel("");
		nullField2 = new JLabel("");
		nullField3 = new JLabel("");
		nullField4 = new JLabel("Operator Buttons");
		nullField5 = new JLabel("");
		nullField6 = new JLabel("");
		nullField7 = new JLabel("");
		
		infoScreen = new JLabel("");
		enterQuantity = new JLabel ("Enter Quantity: ");
		enterMoney = new JLabel ("Please Enter Money: ");
	        getContentPane().setBackground(Color.RED);
		wantedQuantity = new JTextField("");
		paidMoney = new JTextField("");
		getContentPane().setBackground(Color.RED);
		buyingOptions.setLayout(new GridLayout(40,6));
		buyingOptions.add(cokeButton);
		buyingOptions.add(cokeInfo);
		buyingOptions.add(dietCokeButton);
		buyingOptions.add(dietCokeInfo);
		buyingOptions.add(pepsiButton);
		buyingOptions.add(pepsiInfo);
		buyingOptions.add(SpecialPepsiButton);
		buyingOptions.add(SpecialPepsiInfo);
		buyingOptions.add(spriteButton);
		buyingOptions.add(spriteInfo);
		buyingOptions.add(enterMoney);
		buyingOptions.add(paidMoney);	
		buyingOptions.add(buyButton);
		buyingOptions.add(nullField2);
		buyingOptions.add(nullField3);
		buyingOptions.add(nullField1);
		buyingOptions.add(nullField4);
		buyingOptions.add(collectMoney);	
		buyingOptions.add(refillButton);
		buyingOptions.add(nullField5);
		buyingOptions.add(nullField6);
		buyingOptions.add(nullField7);
                getContentPane().setBackground(Color.RED);
		
		
		screenPanel.add(infoScreen);
                getContentPane().setBackground(Color.RED);
		
		this.add(buyingOptions, BorderLayout.NORTH);
		this.add(screenPanel, BorderLayout.SOUTH);
                getContentPane().setBackground(Color.RED);
		
		setTitle("The one and only Vending Machine");
		setSize(400, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
		
	public class cokeHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (cokeQuantity > 0)
			{
				cokeQuantity--;
				totalBill += .50;
				totalMachineMoney += .50;
				cokeInfo.setText("Quantity: " + cokeQuantity);
			}
			else
			{
				infoScreen.setText("Sorry, we're out of stock! Try again tomorrow.");
			}
		}
	}
	
	public class dietCokeHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {			
			if (dietCokeQuantity > 0)
			{
				dietCokeQuantity--;
				totalBill += .50;
				totalMachineMoney += .50;
				dietCokeInfo.setText("Quantity: " + dietCokeQuantity);
			}
			else
			{
				infoScreen.setText("Sorry, we're out of stock!");
			}
		}
	}
	
	public class pepsiHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (pepsiQuantity > 0)
			{
				pepsiQuantity--;
				totalBill += .50;
				totalMachineMoney += .50;
				pepsiInfo.setText("Quantity: " + pepsiQuantity);
			}
			else
			{
				infoScreen.setText("Sorry, we're out of stock!");
			}
		}
	}
	
	public class SpecialPepsiHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			if (SpecialPepsiQuantity > 0)
			{
				SpecialPepsiQuantity--;
				totalBill += .50;
				totalMachineMoney += 1;
				SpecialPepsiInfo.setText("Quantity: " + SpecialPepsiQuantity);
			}
			else
			{
				infoScreen.setText("Sorry, we're out of stock!");
			}
		}
	}
	
	public class spriteHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (spriteQuantity > 0)
			{
				spriteQuantity--;
				totalBill += .50;
				totalMachineMoney += .50;
				spriteInfo.setText("Quantity: " + spriteQuantity);
			}
			else
			{
				infoScreen.setText("Sorry, we're out of stock!");
			}
		}
	}
	
	
	public class buyHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int cent = 0;
			int nickel = 0;
			int dime = 0;
			int quarter = 0;
			double m = 100*(Double.parseDouble(paidMoney.getText()));
			double back = m - (totalBill*100);
			int backC = (int) back;
			if (backC < 0)
			{
				infoScreen.setText("Sorry, not enough money! Try entering another amount of money.");
			}
			else if (backC > 1500)
			{
				infoScreen.setText("Sorry, that's too much! Try entering another amount of money.");
			}
			else
			{
				quarter = backC/25;
				backC = backC %25;
				dime = backC / 10;
				backC = backC % 10;
				nickel = backC / 5;
				backC = backC % 5;
				cent = backC / 1;
				
				
				infoScreen.setText("You have received " +quarter + " quarter(s) " + dime + " dime(s) " + nickel + " nickel(s) and " + cent
						+ "cent(s) back as change.");
				
			}
		
		}
	}
	
	public class collectHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			infoScreen.setText("Your total is: "+ totalMachineMoney + ".");
			totalMachineMoney = 0;
                        getContentPane().setBackground(Color.RED);
			
		}
	}
	
	public class refillHandler implements ActionListener
                
	{
		public void actionPerformed(ActionEvent e)
		{
			cokeQuantity = 100;
			dietCokeQuantity = 100;
			pepsiQuantity = 100;
			SpecialPepsiQuantity = 100;
			spriteQuantity = 100;
			
			cokeInfo.setText("Quantity: " + cokeQuantity);
			dietCokeInfo.setText("Quantity: " + dietCokeQuantity);
			pepsiInfo.setText("Quantity: " + pepsiQuantity);
			SpecialPepsiInfo.setText("Quantity: " + SpecialPepsiQuantity);
			spriteInfo.setText("Quantity: " + spriteQuantity);
			
			infoScreen.setText("You have successfully refilled the machine.");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new VendingMachine1();
		
	}

}

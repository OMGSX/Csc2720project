/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dylan, Kristian, Drew, Megan, Omar, Timothy
 */
import java.awt.*;
import sun.audio.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class VendingMachine1 extends JFrame {

    private JButton cokeButton;
    private JButton dietCokeButton;
    private JButton pepsiButton;
    private JButton GrapeSodaButton;
    private JButton spriteButton;
    private JButton buyButton;
    private JButton refillButton;
    private JButton collectMoney;

    private int cokeQuantity;
    private int dietCokeQuantity;
    private int pepsiQuantity;
    private int GrapeSodaQuantity;
    private int spriteQuantity;
    private int vending1;

    private double totalBill;
    private double totalMachineMoney;

    private JTextField wantedQuantity;
    private JTextField paidMoney;

    private JLabel cokeInfo;
    private JLabel dietCokeInfo;
    private JLabel pepsiInfo;
    private JLabel GrapeSodaInfo;
    private JLabel spriteInfo;
    private JLabel nullField4;
    private JLabel infoScreen;
    private JLabel enterQuantity;
    private JLabel enterMoney;

    private JPanel buyingOptions;
    private JPanel finishPayment;
    private JPanel screenPanel;
    private final JLabel cost;

    public VendingMachine1() {
        cokeQuantity = 100;
        dietCokeQuantity = 100;
        pepsiQuantity = 100;
        GrapeSodaQuantity = 100;
        spriteQuantity = 100;

        totalBill = 0;
        totalMachineMoney = 0;

        buyingOptions = new JPanel();
        buyingOptions.setBackground(Color.RED);
        screenPanel = new JPanel();

        cokeButton = new JButton("Coke");
        cokeButton.setBackground(Color.BLACK);
        cokeButton.setIcon(new ImageIcon("C:\\Users\\krist\\Desktop\\Group Project\\Csc2720project\\Group Project\\src\\Coca-Cola-Can-icon (3).png"));

        dietCokeButton = new JButton("Diet Coke");
        dietCokeButton.setBackground(Color.BLACK);
        dietCokeButton.setIcon(new ImageIcon("C:\\Users\\krist\\Desktop\\Group Project\\Csc2720project\\Group Project\\src\\Diet-Coke-Can-icon.png"));
        pepsiButton = new JButton("Pespi");
        pepsiButton.setBackground(Color.BLACK);
        pepsiButton.setIcon(new ImageIcon("C:\\Users\\krist\\Desktop\\Group Project\\Csc2720project\\Group Project\\src\\Pepsi-Can-icon (1).png"));
        GrapeSodaButton = new JButton("GrapeSoda");
        GrapeSodaButton.setBackground(Color.BLACK);
        GrapeSodaButton.setIcon(new ImageIcon("C:\\Users\\krist\\Desktop\\Group Project\\Csc2720project\\Group Project\\src\\Special-Pepsi-Can-icon.png"));
        spriteButton = new JButton("Sprite");
        spriteButton.setBackground(Color.BLACK);
        spriteButton.setIcon(new ImageIcon("C:\\Users\\krist\\Desktop\\Group Project\\Csc2720project\\Group Project\\src\\Sprite-Can-icon.png"));
        buyButton = new JButton("Buy");
        buyButton.setBackground(Color.BLACK);
        refillButton = new JButton("Refill vending machine");
        refillButton.setBackground(Color.BLACK);
        collectMoney = new JButton("Money owed");
        collectMoney.setBackground(Color.WHITE);

        ActionListener cokeListener = new cokeHandler();
        cokeButton.addActionListener(cokeListener);

        ActionListener dietCokeListener = new dietCokeHandler();
        dietCokeButton.addActionListener(dietCokeListener);

        ActionListener pepsiListener = new pepsiHandler();
        pepsiButton.addActionListener(pepsiListener);

        ActionListener SpecialPepsiListener = new SpecialPepsiHandler();
        GrapeSodaButton.addActionListener(SpecialPepsiListener);

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
        GrapeSodaInfo = new JLabel("Quantity: " + GrapeSodaQuantity);
        spriteInfo = new JLabel("Quantity: " + spriteQuantity);
        nullField4 = new JLabel("Operator Buttons");
        cost = new JLabel("The cost of all Drinks is 50 Cents");

        infoScreen = new JLabel("");
        enterQuantity = new JLabel("Enter Quantity: ");
        enterMoney = new JLabel("Please Enter Money: ");
        wantedQuantity = new JTextField("");
        paidMoney = new JTextField("");
        paidMoney.setBackground(Color.WHITE);
        buyingOptions.add(cost);
        buyingOptions.setLayout(new GridLayout(40, 6));
        buyingOptions.add(cokeButton);
        buyingOptions.add(cokeInfo);
        buyingOptions.add(dietCokeButton);
        buyingOptions.add(dietCokeInfo);
        buyingOptions.add(pepsiButton);
        buyingOptions.add(pepsiInfo);
        buyingOptions.add(GrapeSodaButton);
        buyingOptions.add(GrapeSodaInfo);
        buyingOptions.add(spriteButton);
        buyingOptions.add(spriteInfo);
        buyingOptions.add(enterMoney);
        buyingOptions.add(paidMoney);
        buyingOptions.add(buyButton);
        buyingOptions.add(nullField4);
        buyingOptions.add(collectMoney);
        buyingOptions.add(refillButton);

        screenPanel.add(infoScreen);

        getContentPane().add(buyingOptions, BorderLayout.NORTH);
        getContentPane().add(screenPanel, BorderLayout.SOUTH);

        setTitle("The one and only Vending Machine");
        setSize(400, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static class AL implements ActionListener {

        public final void actionPerformed(ActionEvent e) {
            try {
                music();
            } catch (IOException ex) {
                Logger.getLogger(VendingMachine1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public class cokeHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (cokeQuantity > 0) {
                cokeQuantity--;
                totalBill += .50;
                totalMachineMoney += .50;
                cokeInfo.setText("Quantity: " + cokeQuantity);
            } else {
                infoScreen.setText("Sorry, we're out of stock! Try again tomorrow.");
            }
        }
    }

    public class dietCokeHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (dietCokeQuantity > 0) {
                dietCokeQuantity--;
                totalBill += .50;
                totalMachineMoney += .50;
                dietCokeInfo.setText("Quantity: " + dietCokeQuantity);
            } else {
                infoScreen.setText("Sorry, we're out of stock!");
            }
        }
    }

    public class pepsiHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pepsiQuantity > 0) {
                pepsiQuantity--;
                totalBill += .50;
                totalMachineMoney += .50;
                pepsiInfo.setText("Quantity: " + pepsiQuantity);
            } else {
                infoScreen.setText("Sorry, we're out of stock!");
            }
        }
    }

    public class SpecialPepsiHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (GrapeSodaQuantity > 0) {
                GrapeSodaQuantity--;
                totalBill += .50;
                totalMachineMoney += 1;
                GrapeSodaInfo.setText("Quantity: " + GrapeSodaQuantity);
            } else {
                infoScreen.setText("Sorry, we're out of stock!");
            }
        }
    }

    public static void music() throws IOException {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try {
            InputStream test = new FileInputStream("C:\\Users\\Dylan\\Desktop\\christmas.mp3");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
                    }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
    }
    }
            
    public class spriteHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (spriteQuantity > 0) {
                spriteQuantity--;
                totalBill += .50;
                totalMachineMoney += .50;
                spriteInfo.setText("Quantity: " + spriteQuantity);
            } else {
                infoScreen.setText("Sorry, we're out of stock!");
            }
        }
    }

    public class buyHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int cent = 0;
            int nickel = 0;
            int dime = 0;
            int quarter = 0;
            double m = 100 * (Double.parseDouble(paidMoney.getText()));
            double back = m - (totalBill * 100);
            int backC = (int) back;
            if (backC < 0) {
                infoScreen.setText("Sorry, not enough money! Try entering another amount of money");
            } else if (backC > 1500) {
                infoScreen.setText("Sorry, that's too much! Try entering another amount of money");
            } else {
                quarter = backC / 25;
                backC = backC % 25;
                dime = backC / 10;
                backC = backC % 10;
                nickel = backC / 5;
                backC = backC % 5;
                cent = backC / 1;

                infoScreen.setText("You have received " + quarter + " quarter(s) " + dime + " dime(s) " + nickel + " nickel(s) and " + cent
                        + " cent(s) back as change.");

            }

        }
    }

    public class collectHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            infoScreen.setText("Your total is: " + totalMachineMoney + ".");
            totalMachineMoney = 0;
        }
    }

    public class refillHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            cokeQuantity = 100;
            dietCokeQuantity = 100;
            pepsiQuantity = 100;
            GrapeSodaQuantity = 100;
            spriteQuantity = 100;

            cokeInfo.setText("Quantity: " + cokeQuantity);
            dietCokeInfo.setText("Quantity: " + dietCokeQuantity);
            pepsiInfo.setText("Quantity: " + pepsiQuantity);
            GrapeSodaInfo.setText("Quantity: " + GrapeSodaQuantity);
            spriteInfo.setText("Quantity: " + spriteQuantity);

            infoScreen.setText("You have successfully refilled the machine.");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new VendingMachine1();
         JButton button = new JButton("Click me");
         frame.add(button);
         button.addActionListener(new AL());
        frame.setVisible(true);
    }

}

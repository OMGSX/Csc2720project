/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dylan
 */
import java.awt.*;
import java.awt.event.*;
import static java.lang.System.exit;
import javax.swing.*;
import java.text.*;
import java.util.Scanner;

public abstract class Vending extends JPanel implements ActionListener {

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JTextField jTextField2;

    public static void main(String[] args) {        

   
    }

    boolean exit;
    String choice;
    String coin;
    String first = "You have choosen ";
    String second = ", please pay ";
    String third = " pence and type select when done; ";
    String coinsaccount = "Coins accepted: 1,2,5,10 and 20: ";
    String in = "Insert coin: ";
    String water1 = "water";
    String coca = "cola";
    String juicy = "juice";
    String thanks = "Thank you. No change.";
    String thank = "Thank you. Your change is: ";
    String back = " pence remaining.";
    String not = "Not enough paid ";
    String pence = " pence.";
    String select = "select";
    final int juice = 15;
    final int water = 10;
    final int cola = 12;

    Scanner console = new Scanner(System.in);
  
    
         { 
        System.out.println("Choose your drink ");
        System.out.println("Water press w ");
        System.out.println("Cola  press c ");
        System.out.println("Juice press j ");
        System.out.print("Your choice: ");
        choice = console.next();

        if (choice.equalsIgnoreCase("w")) {
            System.out.println(first + water1 + second + water + third);
            System.out.println(coinsaccount);
            int amount = 0;
            while (amount < 100000000) {
                System.out.println(in);
                coin = console.next();
                if (coin.equals("1")) {
                    amount += 1;
                } else if (coin.equals("2")) {
                    amount += 2;
                } else if (coin.equals("5")) {
                    amount += 5;
                } else if (coin.equals("10")) {
                    amount += 10;
                } else if (coin.equals("20")) {
                    amount += 20;

                } else if (!coin.equals("1") && !coin.equals("2") && !coin.equals("5")
                        && !coin.equals("10") && !coin.equals("20")
                        && !coin.equalsIgnoreCase(select)) {
                    System.exit(0);

                } else if (coin.equalsIgnoreCase(select) && amount == 10) {
                    System.out.println(thanks);
                } else if (coin.equalsIgnoreCase(select) && amount > 10) {
                    System.out.println(thank + (amount - water) + pence);
                } else if (coin.equalsIgnoreCase(select) && amount < 10) {
                    System.out.println(not + (water - amount) + back);
                    break;
                }

            }

        }
        if (choice.equalsIgnoreCase("c")) {
            System.out.println(first + coca + second + cola + third);
            System.out.print(coinsaccount);
            int amount = 0;
            while (amount < 100000000) {
                System.out.println(in);
                coin = console.next();

                if (coin.equals("1")) {
                    amount += 1;
                } else if (coin.equals("2")) {
                    amount += 2;
                } else if (coin.equals("5")) {
                    amount += 5;
                } else if (coin.equals("10")) {
                    amount += 10;
                } else if (coin.equals("20")) {
                    amount += 20;
                } else if (!coin.equals("1") && !coin.equals("2")
                        && !coin.equals("5") && !coin.equals("10")
                        && !coin.equals("20") && !coin.equalsIgnoreCase(select)) {
                    System.exit(0);
                } else if (coin.equalsIgnoreCase(select) && amount < 12) {
                    System.out.println(not + (cola - amount) + back);
                } else if (coin.equalsIgnoreCase(select) && amount == 12) {
                    System.out.println(thanks);
                } else if (coin.equalsIgnoreCase(select) && amount > 12) {
                    System.out.println(thank + (amount - cola) + pence);
                    break;
                }
            }
        }
        if (choice.equalsIgnoreCase("j")) {
            System.out.println(first + juicy + second + juice + third);
            System.out.print(coinsaccount);
            int amount = 0;
            while (amount < 100000000) {
                System.out.println(in);
                coin = console.next();
                if (coin.equals("1")) {
                    amount += 1;
                } else if (coin.equals("2")) {
                    amount += 2;
                } else if (coin.equals("5")) {
                    amount += 5;
                } else if (coin.equals("10")) {
                    amount += 10;
                } else if (coin.equals("20")) {
                    amount += 20;
                } else if (!coin.equals("1") && !coin.equals("2")
                        && !coin.equals("5") && !coin.equals("10")
                        && !coin.equals("20") && !coin.equalsIgnoreCase(select)) {
                    System.exit(0);
                } else if (coin.equalsIgnoreCase(select) && amount < 15) {
                    System.out.println(not + (juice - amount) + back);
                } else if (coin.equalsIgnoreCase(select) && amount == 15) {
                    System.out.println(thanks);
                } else if (coin.equalsIgnoreCase(select) && amount > 15) {
                    System.out.println(thank + (amount - juice) + pence);
                    break;

                }
            }
        } else if (choice.equalsIgnoreCase("terminate")) {
            System.out.print("Have a nice Day");
            exit = true;
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} 

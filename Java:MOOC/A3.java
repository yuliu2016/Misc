import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please Enter the Cost of the Item: ");
        double a= scan.nextDouble();
        
        System.out.println("Please Enter the Amount Paid: ");
        double b= scan.nextDouble();
        
        int cents = (int)Math.round(b * 100 -a * 100);
        double dc =cents/100.0;
        System.out.println("\nChange Owed: "+dc);

        int quarters = (cents - cents % 25 ) / 25;
        cents -= quarters * 25;
        int dimes = ( cents -cents % 10 ) / 10;
        cents -= dimes * 10;
        int nickels = (cents - cents % 5 ) / 5;
        cents -= nickels * 5;
        int pennies = cents;
        
        System.out.println("Quarters: "
            + quarters + "\nDimes: "
            + dimes + "\nNickels: "
            + nickels + "\nPennies: "
            +pennies);
        }
}
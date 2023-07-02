import java.util.Random;
import java.util.Scanner;

public class craps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        // Declare Variables
        int dice1 = 0;
        int dice2 = 0;
        int crapsRoll = 0;
        int thePoint = 0;
        String trash = "";
        boolean done = false;
        boolean playAgain = false;
        // Play again loop.
        do {

            System.out.println("\n     ******  Craps  ******");
            do {
                System.out.print("Lets Play - Enter R to Roll the Dice: ");
                if (in.hasNext("[Rr]")) {
                    dice1 = rnd.nextInt(6) + 1;
                    dice2 = rnd.nextInt(6) + 1;
                    crapsRoll = dice1 + dice2;
                    in.nextLine();
                    done = true;
                } else {
                    // Not Rr
                    trash = in.nextLine();
                    System.out.println("You entered: " + trash);
                }
            } while (!done);
            // Process for Win - Lose or Set the Point
            System.out.println("Die1 = " + dice1 + ", Die2 = " + dice2 + ", Total = " + crapsRoll);
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.print("You Crapped Out - You Lose.");
                done = true;
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Wow - You Win!");
                done = true;
            } else {
                thePoint = crapsRoll;
                System.out.println("The Point is: " + thePoint);
                done = false;
            }

            while (!done) {
                System.out.print("Enter R to Roll the dice ");
                if (in.hasNext("[Rr]")) {
                    dice1 = rnd.nextInt(6) + 1;
                    dice2 = rnd.nextInt(6) + 1;
                    crapsRoll = dice1 + dice2;
                    in.nextLine();
                    System.out.println("Dice1 = " + dice1 + ", Dice2 = " + dice2 + ", Total = " + crapsRoll);
                    if (crapsRoll == 7) {
                        System.out.print("You Crapped Out - You Lose.");
                        done = true;
                    } else if (crapsRoll == thePoint) {
                        System.out.println("We have a Winner - You Win!");
                        done = true;
                    }
                } else {
                    // Not Rr
                    trash = in.nextLine();
                    System.out.println("You entered: " + trash);
                }
            }
            System.out.print("\nWould you like to play again? [Y/N] ");
            if (in.hasNext("[Yy]")) {
                in.nextLine();// clears the newline from the buffer
                playAgain = true;
            } else {
                // Not Yy
                trash = in.nextLine();
                System.out.println("Good Bye!");
                System.exit(0);
            }
        } while (playAgain);
    }
}
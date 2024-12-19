import java.util.Random;
import java.util.Scanner;
public class HUSTLE {


    public static void main(String[] args) {
        System.out.println("Welcome to HUSTLE!");
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        String turn;
        boolean Turn = true;
        boolean game = true;

        int frame1 = 30;
        int frame2 = 50;
        winner(frame1,frame2);
    }

/*IDEA:
USE A LINKED LIST THAT STORES ALL CHARACTER DATA(NAME,MOVE FRAME DATA, MOVE NAME)
E.G LINK LIST CHARACTER
THIS.NAME = YUJI ITADORI/HAKARI KINJI
THIS.MOVE1NAME = BLACK FLASH/ROLL THE PUNCH
THIS.MOVE1FRAMES = 19/24
THIS.MOVE2NAME = DIVERGENT FIST/DROPKICK
THIS.MOVE2FRAMES 15/18
ETC
LONG AND TEDIOUS IF DECIDE TO DO 4 MOVES BUT ITS AN OPTION
THEN HAVE A METHOD TO EXTRACT THE DATA IN MOVE1FRAMES FOR BOTH YUJI NODE + HAKARI NODE
INSERT SAID EXTRACTED DATA INTO A COMPARER METHOD
COMPARER METHOD = WINNER()
PRINT OUT WHICH PLAYER/CHAR/YOUR MOTHER THAT WINS THE EXCHANGE

 */



    /*frame2 represents player 2
      frame1 = player1
     */
    public static void winner(int frame1,int frame2) {
        if (frame2 < frame1)
            System.out.println("PLAYER 1 LOSES EXCHANGE");

        else if (frame2 > frame1)
            System.out.println("PLAYER 2 LOSES EXCHANGE");

        else
            System.out.println("TIED");

    }
}
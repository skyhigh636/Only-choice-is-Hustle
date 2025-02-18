
public class HUSTLE {

public int frame1, frame2;
public HUSTLE first;
public HUSTLE next;
public String Rollpunch, Bflash,Mankick,Dropkick;

    public HUSTLE(int frame1,String Bflash)
    {
        this.frame1 = frame1;
        this.Bflash = Bflash;
        this.next = null;
    }

    public void add(int frame1,String Bflash)
    {
        HUSTLE newLink = new HUSTLE(frame1,Bflash);
        newLink.next = first;
        first = newLink;
    }

    public  void print () {
        HUSTLE current = first;
        while (current != null) {
            System.out.println("Frames: " + current.frame1 + "," + "Attack: " + current.Bflash);
            System.out.println("---------");
            current = current.next;// Move to the next

        }
    }

    public void decision()
    {
        int temp;
        HUSTLE current = first;
        while (current != null) {
            temp = current.frame1;
            current = current.next;
            if(temp == current.frame1)
                System.out.println(current.Bflash);

        }
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
    public static void main(String[] args) {
        System.out.println("Welcome to HUSTLE!");
        HUSTLE link = new HUSTLE(0,"N/A");
        int frame1 = 30;
        int frame2 = 50;
        String Rollpunch = "ROLL THE PUNCH!";
        String Bflash = "BLACK FLASH!";
        link.add(frame1,Bflash);
        link.add(frame2,Rollpunch);
        link.print();
        link.decision();
    }
}
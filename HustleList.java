// This class represents the linked list itself
public class HustleList {
    private HustleNode head;

    public HustleList() {
        head = null;
    }

    public void add(int frame, String moveName) {
        HustleNode newNode = new HustleNode(frame, moveName);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        HustleNode current = head;
        while (current != null) {
            System.out.println("Frames: " + current.frame + ", Attack: " + current.moveName);
            System.out.println("---------");
            current = current.next;
        }
    }

    public void decision() {
        HustleNode current = head;
        while (current != null && current.next != null) {
            if (current.frame == current.next.frame) {
                System.out.println("Match: " + current.next.moveName);
            }
            current = current.next;
        }
    }

    public static void winner(int frame1, int frame2) {
        if (frame2 < frame1)
            System.out.println("PLAYER 1 LOSES EXCHANGE");
        else if (frame2 > frame1)
            System.out.println("PLAYER 2 LOSES EXCHANGE");
        else
            System.out.println("TIED");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to HUSTLE!");

        HustleList list = new HustleList();
        int frame1 = 30;
        int frame2 = 50;
        String move1 = "BLACK FLASH!";
        String move2 = "ROLL THE PUNCH!";

        list.add(frame1, move1);
        list.add(frame2, move2);

        list.print();
        list.decision();

        // Compare moves
        winner(frame1, frame2);
    }
}

/**
 * @author Skyhigh636
 * @date 25/04/2025
 */

import java.lang.Math;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class HustleDataLoader {
    public static void main(String[] args) {
        Map<String, Character> characters = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("moves.txt"))) {
            /*
                first time actually using file readers
             */
            String line;
            while ((line = br.readLine()) != null) { // where line is the string line on the file make loop when it's not null
                String[] parts = line.split(","); // split the string into an array based on ","
                String charName = parts[0].trim(); // represents char name (trim on first pos of array?)
                String moveName = parts[1].trim(); // represents move name (trim on second pos)
                int frames = Integer.parseInt(parts[2].trim()); // parseInt frames (trim on third pos)

                characters.putIfAbsent(charName, new Character(charName));
                characters.get(charName).addMove(new move(moveName, frames));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }


        Character yuji = characters.get("Yuji Itadori");
        Character hakari = characters.get("Hakari Kinji");
        int i = 0;
        int yujilength = yuji.moves.size();
        int hakarilength = hakari.moves.size();
        int min = 0;
        int range = yujilength + 1 - 1;

        Fight(yuji, hakari, range, min, i, yujilength, hakarilength);
    }

    public static void Fight(Character yuji, Character hakari, int range, int min, int i, int yujilength, int hakarilength) {
        int j = 0;
        do {
            int random = (int) (Math.random() * range) + min;
            int random2 = (int) (Math.random() * range) + min;
            move yujiMove = yuji.moves.get(random);
            move hakariMove = hakari.moves.get(random2);

            System.out.println("NEUTRAL:");
            System.out.println(yuji.name + " - " + yujiMove.name + ": " + yujiMove.frames);
            System.out.println(hakari.name + " - " + hakariMove.name + ": " + hakariMove.frames);

            if (yujiMove.frames < hakariMove.frames) {
                System.out.println(yuji.name + " wins the exchange!");
                hakari.health = hakari.health - yujiMove.frames;
                System.out.println("Combo starts now!");
                System.out.println("******************");
                combo(yuji, j, yujiMove.frames);
            } else if (yujiMove.frames > hakariMove.frames) {
                System.out.println(hakari.name + " wins the exchange!");
                System.out.println("Combo starts now!");
                System.out.println("******************");
                combo(hakari, j, hakariMove.frames);
            } else {
                System.out.println("Exchange is tied!");
                System.out.println("******************");
            }
            if(yuji.health <= 0 || hakari.health <= 0){
                break;
            }
            j++;
        } while (yuji.health > 0|| hakari.health > 0);
    }


    public static void combo(Character character, int j, int frames) {
        int length = character.moves.size();
        int min = 0;
        int range = length + 1 - 1;
        if(frames < 10){
            frames = frames *2;
        }
        else
            frames = frames * 3;

        do {

            int random = (int) (Math.random() * range) + min;
            move charMove = character.moves.get(random);
            frames = frames - charMove.frames;
            character.health = character.health - frames;
            if(character.health <= 0)
                break;
            System.out.println(character.name + " - " + charMove.name);
            System.out.println("Health: " + character.health);


        } while (frames >= 0);
        System.out.println("Combo End");
        System.out.println("******************");

    }
}

/* TODO UP... IDK?
    JoptionPane for a GUI?
    Finish up character movesets?
    User input for character movesets?
    User input for amount of exchanges
    construct the character in a class?
 */
//math.random? -- DONE and working
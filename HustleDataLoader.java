/**
 * @author Skyhigh636
 * @date 25/04/2025
 *
 */

import java.io.*;
import java.util.*;

public class HustleDataLoader {
    public static void main(String[] args) {
        Map<String, Character> characters = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("moves.txt"))) {
            /*
                first time actually using file readers
             */
            String line;
            while ((line = br.readLine()) != null) { // where line is the string line on the file make loop when its not null
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

        // Example: Compare 1st move of two characters
        Character yuji = characters.get("Yuji Itadori");
        Character hakari = characters.get("Hakari Kinji");
        int i =0;
        int yujilength = yuji.moves.size();
        int hakarilength = hakari.moves.size();
        do{



            move yujiMove = yuji.moves.get(i);
            move hakariMove = hakari.moves.get(i);

            System.out.println("Comparing:");
            System.out.println(yuji.name + " - " + yujiMove.name + ": " + yujiMove.frames);
            System.out.println(hakari.name + " - " + hakariMove.name + ": " + hakariMove.frames);

            if (yujiMove.frames < hakariMove.frames)
                System.out.println(yuji.name + " wins the exchange!");
            else if (yujiMove.frames > hakariMove.frames)
                System.out.println(hakari.name + " wins the exchange!");
            else
                System.out.println("Exchange is tied!");
            i++;
        }while(yuji != null && hakari != null && i < yujilength && i< hakarilength);
    }
}
/* NEXT UP... IDK?
    as it stands itll read through the text file (long as its formatted correctly)
    but its a lot of typing to actually fill out a whole characters moveset,
    consequence of the idea i suppose.
    math.random? between 0 and the length of char
    but itll require a seperate count var thatll increment each time
    max run of 6 i suppose?
    Man i gotta figure out how to better send these files to github without manually uploading them
 */
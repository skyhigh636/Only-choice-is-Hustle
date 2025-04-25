import java.io.*;
import java.util.*;

public class HustleDataLoader {
    public static void main(String[] args) {
        Map<String, Character> characters = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("moves.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String charName = parts[0].trim();
                String moveName = parts[1].trim();
                int frames = Integer.parseInt(parts[2].trim());

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
        }while(yuji != null && hakari != null && i < 2);
    }
}

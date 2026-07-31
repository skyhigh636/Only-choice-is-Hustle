package create.character;

import java.util.ArrayList;
import java.util.List;
import create.move.move;
public class Character {
    public String name;

    public int health;
    public List<move> moves;

    public Character(String name) {
        this.health = 100;
        this.name = name;
        this.moves = new ArrayList<>();
    }

    public void addMove(move move) {
        moves.add(move);
    }
}
//Dont touch this code

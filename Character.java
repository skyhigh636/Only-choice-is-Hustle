import java.util.ArrayList;
import java.util.List;

public class Character {
    public String name;
    public List<move> moves;

    public Character(String name) {
        this.name = name;
        this.moves = new ArrayList<>();
    }

    public void addMove(move move) {
        moves.add(move);
    }
}
//Dont touch this code

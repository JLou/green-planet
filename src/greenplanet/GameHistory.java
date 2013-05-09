package greenplanet;

import greenplanetclient.Game;
import java.util.ArrayList;

/**
 * Save the game history Each turn and player state
 *
 * @author JLou
 */
public class GameHistory {

    private ArrayList<Turn> _turns;

    public GameHistory() {
        _turns = new ArrayList<>();
    }

    /**
     *
     * @param game save current turn
     */
    public void addTurn(Game g) {
        Turn t = new Turn(g);
        _turns.add(t);
    }

    /**
     *
     * @param index of the turn
     * @return the selected turn
     */
    public Turn getTurn(int index) {
        return _turns.get(index);
    }

    /**
     *
     * @return amount of turn saved
     */
    public int count() {
        return _turns.size();
    }

    /**
     *
     * @return current/last turn
     */
    public Turn getCurrentTurn() {
        return getTurn(_turns.size() - 1);
    }
}

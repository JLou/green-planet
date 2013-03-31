/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet;

import greenplanetclient.Game;
import java.util.ArrayList;

/**
 *
 * @author JLou
 */
public class GameHistory 
{
    private ArrayList<Turn> _turns;
    
    public GameHistory()
    {
        _turns = new ArrayList<>();
    }
    
    public void addTurn(Game g)
    {
        Turn t = new Turn(g);
        _turns.add(t);
    }
    
    public Turn getTurn(int index)
    {
        return _turns.get(index);
    }
    
    public Turn getCurrentTurn()
    {
        return getTurn(_turns.size() -1);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet;

import greenplanetclient.Event;
import greenplanetclient.Game;
import greenplanetclient.Player;
import greenplanetclient.PlayerStateEnum;
import java.util.ArrayList;

/**
 *
 * @author JLou
 */

public class Turn 
{
    protected ArrayList<Player> _players;
        
    private ArrayList<Integer> _eliminated;
    
    private ArrayList<Event>   _events;
    
    public ArrayList<Player> getPlayers()
    {
        return _players;
    }
    
    public ArrayList<Player> getAlivePlayers()
    {
        return _players;
    }
    
    public Player getPlayer(String name)
    {
        for(Player p : _players)
        {
            System.out.println("Playername:" + name + " reading "+p.getName());
            if(p.getName().equals(name))
                return p;
        }
        return _players.get(_players.size()-1);
    }
    public Turn(Game g)
    {
        _players = (ArrayList<Player>) g.getPlayers().clone();
        _eliminated = new ArrayList<>();
        for(Player p : _players)
        {
            if(p.getState() == PlayerStateEnum.DEAD)
                _eliminated.add(_players.indexOf(p));
        }
        
        _events = (ArrayList<Event>) g.getEvents().clone();
    }
    
}

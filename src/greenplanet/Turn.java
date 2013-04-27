/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet;

import greenplanet.data.PlayerInfo;
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
    protected ArrayList<PlayerInfo> _players;
        
    private ArrayList<Integer> _eliminated;
    
    private ArrayList<Event>   _events;
    
    private int _water;
    
    private int _sun;
    
    private int _wind;
    
    private float _energyPrice;
    
    public ArrayList<PlayerInfo> getPlayers()
    {
        return _players;
    }
    
    public ArrayList<PlayerInfo> getAlivePlayers()
    {
        return _players;
    }
    
    public PlayerInfo getPlayer(String name)
    {
        for(PlayerInfo p : _players)
        {
            if(p.getName().equals(name))
                return p;
        }
        return _players.get(_players.size()-1);
    }
    
    public float getEnergyPrice()
    {
        return _energyPrice;
    }
    public Turn(Game g)
    {
        _players = new ArrayList<>();
        _eliminated = new ArrayList<>();
        
        _sun = g.getLight();
        _water = g.getWater();
        _wind = g.getWind();
        
        for(Player p : g.getPlayers())
        {
            PlayerInfo pi = new PlayerInfo(p, this);
            _players.add(pi);
            if(p.getState() == PlayerStateEnum.DEAD)
                _eliminated.add(_players.indexOf(p));
        }
        
        _events = (ArrayList<Event>) g.getEvents().clone();
        
        _energyPrice = g.getPowerPrice();
    }

    /**
     * @return the _water
     */
    public int getWater() {
        return _water;
    }

    /**
     * @return the _sun
     */
    public int getSun() {
        return _sun;
    }

    /**
     * @return the _wind
     */
    public int getWind() {
        return _wind;
    }
    
}

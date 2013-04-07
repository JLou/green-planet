package greenplanet.data;

import greenplanetclient.Building;
import greenplanetclient.Player;

public abstract class BuildingArray
{
    private final int NB_BUILDING_TYPE = 5;
    
    public final int NUCLEAR = 0;
    public final int WATER = 1;
    public final int WIND = 2;
    public final int SOLAR = 3;
    public final int COAL = 4;
    
    protected int[] _buildings;
    
    protected Player _player;
    
    public BuildingArray(Player p)
    {
        _buildings = new int[NB_BUILDING_TYPE];
        _player = p;
    }
    
    public abstract void computeData();
    
    public int getBuildingValue(int type) throws Exception
    {
        if(type > 0 && type < NB_BUILDING_TYPE)
        {
            return _buildings[type];
        }
        throw new Exception("Incorrect building type");
    }
    
    public int getTotal()
    {
        int total = 0;
        for(int value : _buildings)
        {
            total += value;
        }
        return total;
    }
    
}
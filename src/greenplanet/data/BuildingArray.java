package greenplanet.data;

import greenplanetclient.Player;

/**
 * Structured data aiming to get easily information about every building
 * @author JLou
 */
public abstract class BuildingArray
{
    private final int NB_BUILDING_TYPE = 5;
    
    public static final int NUCLEAR = 0;
    public static final int WATER = 1;
    public static final int WIND = 2;
    public static final int SOLAR = 3;
    public static final int COAL = 4;
    
    protected int[] _buildings;
    
    protected Player _player;
    
    /**
     * Constructor
     * @param Player
     */
    public BuildingArray(Player p)
    {
        _buildings = new int[NB_BUILDING_TYPE];
        _player = p;
    }
    
    /**
     * Go through the player information and saves them appropriatly
     */
    public abstract void computeData();
    
    /**
     * 
     * @param type
     * @return value of the secific building
     * @throws Exception 
     */
    public int getBuildingValue(int type) throws Exception
    {
        if(type >= 0 && type < NB_BUILDING_TYPE)
        {
            return _buildings[type];
        }
        throw new Exception("Incorrect building type" + type);
    }
    
    /**
     * Associate the string to an index for the building
     * @param type
     * @return the index
     */
    public static int getIndex(String type)
    {
        switch(type)
            {
                case "water_turbine":
                    return WATER;
                case "wind_turbine":
                    return WIND;
                case "solar_plant":
                    return SOLAR;
                case "nuclear":
                    return NUCLEAR;
                case "coal_fired_plant":
                    return COAL;
            }
        return -1;
    }
    
    /**
     * 
     * @return sum of all the building values
     */
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
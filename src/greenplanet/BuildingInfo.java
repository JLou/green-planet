/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet;

import org.apache.http.protocol.HTTP;

/**
 * Handy values to quickly access parameters 
 * across all the program
 * @author JLou
 */
public enum BuildingInfo 
{
    /**
     * DO NOT TOUCH UNLESS RULES ARE MODIFIED
     * sD  = solarDependency
     * wD  = windDependency
     * waD = waterDependency
     * ORDER index   cost  bonus     prod    sD   wD    waD name     */
    NUCLEAR( 0,     1000, -100,     1000,    0,    0,    0, "nuclear"),
    WATER  ( 1,     500,   300,      300,    0,    0,   50, "water_turbine"),
    WIND   ( 2,     100,   100,      100,    0,  100,    0, "wind_turbine"),
    SUN    ( 3,     200,     0,      100,  100,    0,    0, "solar_plant"),
    COAL   ( 4,     400,  -200,      500,    0,    0,    0, "coal_fired_plant");
    // END OF DO NOT TOUCH
    
    private int _cost;
    
    private int _bonus;
    
    private int _prod;
    
    private int _solarDependency;
    
    private int _windDependency;
    
    private int _waterDependency;
    
    private String _name;
    
    private int _index;
    
    private static BuildingInfo[] _values = null;
    
    
    /**
     * Create building information
     * @param index
     * @param cost
     * @param bonus
     * @param prod
     * @param solarDependency
     * @param windDependency
     * @param waterDependency
     * @param name 
     */
    private BuildingInfo(int index, int cost, int bonus, int prod, int solarDependency,
                      int windDependency, int waterDependency,
                      String name)
    {
        
        _index = index;
        
        _cost = cost;
        
        _bonus = bonus;
        
        _prod = prod;
        
        _windDependency = windDependency;
        _solarDependency = solarDependency;
        _waterDependency = waterDependency;
        
        _name = name;
    }
    
    /**
     * Return building info based on his name
     * @see HTTP://green-planet-project.com for list of buildings and 
     * matching names
     * @param name
     * @return BuildingInfo matching building
     * @throws Exception No matching building was found
     */
    public BuildingInfo getBuilding(String name) throws Exception
    {
        for(BuildingInfo bi : BuildingInfo.values())
        {
            if(bi.getName().equals(name))
                return bi;
        }
        
        throw new Exception("No matching building");
    }

    
    /**
     * 
     * @return Array with all the building sorted by index order
     */
    public static BuildingInfo[] getValues()
    {
        if(_values == null)
            _values = new BuildingInfo[] { NUCLEAR, WATER, WIND, SUN, COAL };
        return _values;
    }
    
    
    public int getIndex() {
        return _index;
    }
    
    /**
     * @return the cost of the building
     */
    public int getCost() {
        return _cost;
    }

    /**
     * @return the green bonus the building has
     */
    public int getBonus() {
        return _bonus;
    }

    /**
     * @return the max production of a building
     */
    public int getProd() {
        return _prod;
    }

    /**
     * @return the solarDependency of the building
     */
    public int getSolarDependency() {
        return _solarDependency;
    }

    /**
     * @return the _windDependency
     */
    public int getWindDependency() {
        return _windDependency;
    }

    /**
     * @return the _waterDependency
     */
    public int getWaterDependency() {
        return _waterDependency;
    }

    /**
     * @return the _name
     */
    public String getName() {
        return _name;
    }
    
    
}

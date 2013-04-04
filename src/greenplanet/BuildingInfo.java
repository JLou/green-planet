/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet;

/**
 *
 * @author JLou
 */
public enum BuildingInfo 
{
    
    NUCLEAR(1000, -100, 1000, 0, 0, 0, "nuclear"),
    COAL(400, -200, 500, 0, 0, 0, "coal_fired_plant"),
    WIND(100, 100, 100, 0, 100, 0, "wind_turbine"),
    SUN(200, 0, 100, 100, 0, 0, "solar_plant"),
    WATER(500, 300, 300, 0, 0, 50, "water_turbine");
        
    private int _cost;
    
    private int _bonus;
    
    private int _prod;
    
    private int _solarDependency;
    
    private int _windDependency;
    
    private int _waterDependency;
    
    private String _name;
    private BuildingInfo(int cost, int bonus, int prod, int solarDependency,
                      int windDependency, int waterDependency,
                      String name)
    {
        _cost = cost;
        
        _bonus = bonus;
        
        _prod = prod;
        
        _windDependency = windDependency;
        _solarDependency = solarDependency;
        _waterDependency = waterDependency;
        
        _name = name;
    }
    
    public BuildingInfo getBuilding(String name) throws Exception
    {
        for(BuildingInfo bi : BuildingInfo.values())
        {
            if(bi.getName().equals(name))
                return bi;
        }
        
        throw new Exception("BADDDDDDDDDDDIE");
    }

    /**
     * @return the _cost
     */
    public int getCost() {
        return _cost;
    }

    /**
     * @return the _bonus
     */
    public int getBonus() {
        return _bonus;
    }

    /**
     * @return the _prod
     */
    public int getProd() {
        return _prod;
    }

    /**
     * @return the _solarDependency
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

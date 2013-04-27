/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.data;

import greenplanetclient.Building;
import greenplanetclient.Player;

/**
 *
 * @author JLou
 */
public class BuildingCount extends BuildingArray
{
    public BuildingCount(Player p)
    {
        super(p);
        computeData();

    }
    
    @Override
    public void computeData()
    {
        for(Building b : _player.getBuildings())
        {
            switch(b.getType())
            {
                case "water_turbine":
                    _buildings[WATER]++;
                    break;
                case "wind_turbine":
                    _buildings[WIND]++;
                    break;
                case "solar_plant":
                    _buildings[SOLAR]++;
                    break;
                case "nuclear":
                    _buildings[NUCLEAR]++;
                    break;
                case "coal_fired_plant":
                    _buildings[COAL]++;
                    break;           
            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.data;

import greenplanet.BuildingInfo;
import greenplanetclient.Building;
import greenplanetclient.Player;

/**
 *
 * @author JLou
 */
public class BuildingValue extends BuildingArray
{
    public BuildingValue(Player p)
    {
        super(p);
    }
    
    @Override
    public void computeData() 
    {
        for(Building b : _player.getBuildings())
        {
            switch(b.getType())
            {
                case "water_turbine":
                    _buildings[WATER] += BuildingInfo.WATER.getProd();
                    break;
                case "wind_turbine":
                    _buildings[WIND] += BuildingInfo.WIND.getProd();
                    break;
                case "solar_plant":
                    _buildings[SOLAR] += BuildingInfo.SUN.getProd();
                    break;
                case "nuclear":
                    _buildings[NUCLEAR] += BuildingInfo.NUCLEAR.getProd();
                    break;
                case "coal_fired_plant":
                    _buildings[COAL] += BuildingInfo.COAL.getProd();
                    break;           
            }
        }
    }
}

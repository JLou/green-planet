package greenplanet.data;

import greenplanet.BuildingInfo;
import greenplanet.Turn;
import greenplanetclient.Building;
import greenplanetclient.Player;

/**
 * Utility class to easily calculate the production of the several type of
 * building of a specific player
 *
 * @author JLou
 */
public class BuildingValue extends BuildingArray {

    private Turn _turn;

    public BuildingValue(Player p, Turn t) {
        super(p);
        _turn = t;

        computeData();

    }

    /**
     *
     * @param bi The building we want to analyse
     * @return int the production of the building
     */
    private int computeProduction(BuildingInfo bi) {
        //Split reliable and dependent prod
        int reliableProd = 100 - bi.getSolarDependency()
                - bi.getWaterDependency() - bi.getWindDependency();
        int a = bi.getProd()
                * (reliableProd + bi.getSolarDependency() * _turn.getSun() / 100
                + bi.getWaterDependency() * _turn.getWater() / 100
                + bi.getWindDependency() * _turn.getWind() / 100) / 100;
        return a;
    }

    @Override
    public void computeData() {
        for (Building b : _player.getBuildings()) {
            switch (b.getType()) {
                case "water_turbine":
                    _buildings[WATER] += computeProduction(BuildingInfo.WATER);
                    break;
                case "wind_turbine":
                    _buildings[WIND] += computeProduction(BuildingInfo.WIND);
                    break;
                case "solar_plant":
                    _buildings[SOLAR] += computeProduction(BuildingInfo.SUN);
                    break;
                case "nuclear":
                    _buildings[NUCLEAR] += computeProduction(BuildingInfo.NUCLEAR);
                    break;
                case "coal_fired_plant":
                    _buildings[COAL] += computeProduction(BuildingInfo.COAL);
                    break;
            }
        }
    }
}

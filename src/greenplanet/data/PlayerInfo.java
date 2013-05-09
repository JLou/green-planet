package greenplanet.data;

import greenplanet.Turn;
import greenplanetclient.Player;
import greenplanetclient.PlayerStateEnum;

/**
 * Save the information at a fixed point in time of a player
 *
 * @author JLou
 */
public class PlayerInfo {

    private BuildingCount _buildingsCount;
    private BuildingValue _buildingsValues;
    private int _totalEnergy = -1;
    private String _name;
    private boolean _isAlive;
    private Turn _turn;
    private float _cash;
    private int _ecoBonus;

    /**
     *
     * @param p Player to save
     * @param t Turn information, used to save meteorological values
     */
    public PlayerInfo(Player p, Turn t) {
        _buildingsCount = new BuildingCount(p);
        _buildingsValues = new BuildingValue(p, t);

        _cash = p.getCash();
        _name = p.getName();
        _ecoBonus = p.getPollution();
        _turn = t;
        _isAlive = p.getState() == PlayerStateEnum.ALIVE;
    }

    /**
     *
     * @return Total energy available to the player
     */
    public int getTotalEnergy() {
        if (_totalEnergy == -1) {
            _totalEnergy = getBuildingsValues().getTotal();
        }
        return _totalEnergy;
    }

    /**
     * Return the production of all the plant of one type
     *
     * @param buildingType Type of plant you want the production of
     * @return int The production of the buildings of this type
     * @throws Exception
     */
    public int getProduction(int buildingType) throws Exception {
        return getBuildingsValues().getBuildingValue(buildingType);
    }

    /**
     *
     * @return Player cash
     */
    public float getCash() {
        return _cash;
    }

    /**
     *
     * @return Player name
     */
    public String getName() {
        return _name;
    }

    /**
     * @return the Information about amount of building
     */
    public BuildingCount getBuildingsCount() {
        return _buildingsCount;
    }

    /**
     * @return the informations about values of production of the building
     */
    public BuildingValue getBuildingsValues() {
        return _buildingsValues;
    }

    /**
     * @return whether the player is alive
     */
    public boolean isAlive() {
        return _isAlive;
    }

    /**
     * @return the player eco bonus
     */
    public int getEcoBonus() {
        return _ecoBonus;
    }
}
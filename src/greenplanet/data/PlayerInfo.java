package greenplanet.data;

import greenplanet.Turn;
import greenplanetclient.Player;
import greenplanetclient.PlayerStateEnum;

/**
 *
 * @author JLou
 */
public class PlayerInfo 
{
    
    
    private BuildingCount _buildingsCount;
    
    private BuildingValue _buildingsValues;
    
    private int _totalEnergy = -1;
    
    private String _name;
    
    private boolean _isAlive;
    
    private Turn _turn;
    
    public PlayerInfo(Player p, Turn t)
    {
        _buildingsCount = new BuildingCount(p);
        _buildingsValues = new BuildingValue(p, t);
        
        _name = p.getName();
        _turn = t;
        _isAlive = p.getState() == PlayerStateEnum.ALIVE;
    }
    
    public int getTotalEnergy() 
    {
        if(_totalEnergy == -1)
            _totalEnergy = getBuildingsValues().getTotal();
        return _totalEnergy;
    }
    /**
     * Return the production of all the plant of one type
     * @param buildingType Type of plant you want the production of
     * @return int The production of the buildings of this type
     * @throws Exception 
     */
    public int getProduction(int buildingType) throws Exception
    {
        return getBuildingsValues().getBuildingValue(buildingType);
    }

    public String getName() {
        return _name;
    }

    /**
     * @return the _buildingsCount
     */
    public BuildingCount getBuildingsCount() {
        return _buildingsCount;
    }

    /**
     * @return buildingsValues
     */
    public BuildingValue getBuildingsValues() {
        return _buildingsValues;
    }

    /**
     * @return the _isAlive
     */
    public boolean isAlive() {
        return _isAlive;
    }
    
}
package greenplanet.data;

import greenplanetclient.Player;

/**
 *
 * @author JLou
 */
public class PlayerInfo 
{
    
    
    private BuildingCount _buildingsCount;
    
    private BuildingValue _buildingsValues;
    
    private int _totalEnergy = -1;
    
    
    public PlayerInfo(Player p)
    {
        _buildingsCount = new BuildingCount(p);
        _buildingsValues = new BuildingValue(p);
    }
    
    public int getTotalEnergy() 
    {
        if(_totalEnergy == -1)
            _totalEnergy = _buildingsValues.getTotal();
        return _totalEnergy;
    }
    
    public int getProduction(int buildingType) throws Exception
    {
        return _buildingsValues.getBuildingValue(buildingType);
    }
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart.turn;

import greenplanet.BuildingInfo;
import greenplanet.Turn;
import greenplanet.data.BuildingCount;
import greenplanet.data.BuildingValue;
import greenplanet.data.PlayerInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author JLou
 */
public final class GameEnergyRepartition extends AbstractTurnChart
{
    
    DefaultCategoryDataset dataset;
    
    public GameEnergyRepartition(Turn t)
    {
        super(t);
        createDataset();
        _chart = ChartFactory.createStackedBarChart("Energy Repartition", "Category", "Value",
                dataset, PlotOrientation.VERTICAL, true, true, false);
    }
    
    
    @Override
    protected CategoryDataset createDataset() 
    {
        dataset = new DefaultCategoryDataset();

        
        for(PlayerInfo p : _turn.getPlayers())
        {
            BuildingValue bc = p.getBuildingsValues();
            for(BuildingInfo bi : BuildingInfo.getValues())
            {
                try {
                    dataset.addValue(bc.getBuildingValue(bi.getIndex()), bi.getName(), p.getName());
                } catch (Exception ex) {
                    Logger.getLogger(GameEnergyRepartition.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return dataset;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart;

import greenplanet.Turn;
import greenplanetclient.Building;
import greenplanetclient.Player;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author JLou
 */
public final class GameEnergyRepartition extends AbstractChart
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

        
        for(Player p : _turn.getPlayers())
        {
            int[] buildings = new int[5];
            for(Building b : p.getBuildings())
            {
                switch(b.getType())
                {
                    case "water_turbine":
                        buildings[0]++;
                        break;
                    case "wind_turbine":
                        buildings[1]++;
                        break;
                    case "solar_plant":
                        buildings[2]++;
                        break;
                    case "nuclear":
                        buildings[3]++;
                        break;
                    case "coal_fired_plant":
                        buildings[4]++;
                        break;                    
                }
                for(int i = 0;i < 5; i++)
                {
                    dataset.addValue(buildings[i], Integer.toString(i), p.getName());
                }
                
            }
        }
        return dataset;
    }
}

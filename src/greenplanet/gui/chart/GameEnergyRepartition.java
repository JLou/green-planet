/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart;

import greenplanet.Turn;
import greenplanetclient.Building;
import greenplanetclient.Player;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author JLou
 */
public class GameEnergyRepartition 
{
    JFreeChart chart;
    DefaultCategoryDataset dataset;
    public GameEnergyRepartition(Turn t)
    {
        createDataset(t);
        chart = ChartFactory.createStackedBarChart("Energy Repartition", "Category", "Value",
                dataset, PlotOrientation.VERTICAL, true, true, false);
    }
    
    public ChartPanel getPanel()
    {
        return new ChartPanel(chart);
    }
    private CategoryDataset createDataset(Turn t) 
    {
        dataset = new DefaultCategoryDataset();

        
        for(Player p : t.getPlayers())
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
            /*
            dataset.addValue(1000, "Nuclear", "Player 1");
            dataset.addValue(800,   "Coal",   "Player 1");
            dataset.addValue(200,   "Water",  "Player 1" );
            dataset.addValue(600,   "Wind",   "Player 1");
            dataset.addValue(700,   "Sun",    "Player 1");

            dataset.addValue(0,    "Nuclear", "Player 2");
            dataset.addValue(600,   "Coal",   "Player 2");
            dataset.addValue(2000,   "Water",  "Player 2" );
            dataset.addValue(500,   "Wind",   "Player 2");
            dataset.addValue(200,   "Sun",    "Player 2");

            dataset.addValue(2000, "Nuclear", "Player 3");
            dataset.addValue(300,   "Coal",   "Player 3");
            dataset.addValue(200,   "Water",  "Player 3" );
            dataset.addValue(800,   "Wind",   "Player 3");
            dataset.addValue(900,   "Sun",    "Player 3");

            dataset.addValue(1000, "Nuclear", "Player 4");
            dataset.addValue(800,   "Coal",   "Player 4");
            dataset.addValue(300,   "Water",  "Player 4" );
            dataset.addValue(200,   "Wind",   "Player 4");
            dataset.addValue(5000,   "Sun",    "Player 4");

            dataset.addValue(6000, "Nuclear", "Player 5");
            dataset.addValue(100,   "Coal",   "Player 5");
            dataset.addValue(300,   "Water",  "Player 5" );
            dataset.addValue(500,   "Wind",   "Player 5");
            dataset.addValue(0,   "Sun",    "Player 5");
            */
        return dataset;
    }
}

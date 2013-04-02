/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart;

import greenplanet.Turn;
import greenplanetclient.Building;
import greenplanetclient.Player;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author JLou
 */
public final class PiePlayerEnergy extends AbstractChart
{
    
    JFreeChart chart;
    PieDataset dataset;
    private String _playername;
    
    public PiePlayerEnergy(Turn t, String playername)
    {
        super(t);
        _playername = playername;
        dataset = createDataset();
        chart = ChartFactory.createPieChart("Energy Repartition", dataset, true, true, Locale.FRENCH);
    }
    
    @Override
    public ChartPanel getPanel()
    {
        return new ChartPanel(chart);
    }
    
    @Override
    protected  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        
        Player p = _turn.getPlayer(_playername);
        
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
        }
        
        for(int i = 0;i < 5; i++)
        {
            result.setValue(i, (Number)buildings[i]);
        }
        
        return result;
        
    }
    
}

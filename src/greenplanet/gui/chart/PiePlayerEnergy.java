/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart;

import greenplanet.BuildingInfo;
import greenplanet.Turn;
import greenplanet.data.BuildingArray;
import greenplanet.data.PlayerInfo;
import greenplanetclient.Building;
import greenplanetclient.Player;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import sun.security.provider.certpath.BuildStep;

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
        chart = ChartFactory.createPieChart("Energy Repartition of Player " + playername, dataset, true, true, Locale.FRENCH);
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
        
        PlayerInfo pi = new PlayerInfo(p);
        
        
        for(BuildingInfo bi : BuildingInfo.getValues())
        {
            try {
                result.setValue(bi.getName(), 
                        (Number) pi.getProduction(
                        BuildingArray.getIndex(bi.getName())
                ));
            } catch (Exception ex) {
                System.out.println("fail" + ex);
            }
        }
        
        
        return result;
        
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart.turn;

import greenplanet.BuildingInfo;
import greenplanet.Turn;
import greenplanet.data.BuildingArray;
import greenplanet.data.PlayerInfo;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Energy repartition according to type of energy
 * @author JLou
 */
public final class PiePlayerEnergy extends AbstractTurnChart
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
        
        PlayerInfo pi = _turn.getPlayer(_playername);
        
        for(BuildingInfo bi : BuildingInfo.getValues())
        {
            try {
                System.out.println("JLou has " + pi.getBuildingsCount().getBuildingValue(bi.getIndex())
                        + bi.getName());
                System.out.println("It produces " + pi.getProduction(
                        BuildingArray.getIndex(bi.getName())));
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

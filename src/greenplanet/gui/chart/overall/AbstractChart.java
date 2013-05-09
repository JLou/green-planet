/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart.overall;

import greenplanet.GameHistory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

/**
 *
 * @author JLou
 */
public abstract class AbstractChart 
{
    protected JFreeChart _chart;
    protected GameHistory _gameHistory;
    
    
    public AbstractChart(GameHistory gh)
    {
        _gameHistory = gh;
    }
    
    public ChartPanel getPanel()
    {
        return new ChartPanel(_chart);
    }
    
    protected abstract Dataset createDataset(); 

}

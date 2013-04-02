/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart;

import greenplanet.Turn;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;

/**
 *
 * @author JLou
 */
public abstract class AbstractChart 
{
    protected JFreeChart _chart;
    protected Turn _turn;
    
    
    public AbstractChart(Turn t)
    {
        _turn = t;
    }
    
    public ChartPanel getPanel()
    {
        return new ChartPanel(_chart);
    }
    
    protected abstract Dataset createDataset(); 

}

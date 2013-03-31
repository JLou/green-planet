/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart;

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
public class PiePlayerEnergy
{
    
    JFreeChart chart;
    PieDataset dataset;
    public PiePlayerEnergy()
    {
        dataset = createDataset();
        chart = ChartFactory.createPieChart("Energy Repartition", dataset, true, true, Locale.FRENCH);
    }
    
    public ChartPanel getPanel()
    {
        return new ChartPanel(chart);
    }
    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Nuclear", 100);
        result.setValue("Eolienne", 300);
        result.setValue("Charbon", 500);
        return result;
        
    }
    
}

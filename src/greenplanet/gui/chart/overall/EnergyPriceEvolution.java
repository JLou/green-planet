/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart.overall;

import greenplanet.GameHistory;
import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author JLou
 */
public class EnergyPriceEvolution extends AbstractChart
{
    
    public EnergyPriceEvolution(GameHistory gh)
    {
        super(gh);
        XYDataset dataset = createDataset();
        _chart = ChartFactory.createTimeSeriesChart(
            "Legal & General Unit Trust Prices",  // title
            "Tour",             // x-axis label
            "Prix",   // y-axis label
            dataset,            // data
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
        );
    }

    @Override
    protected XYDataset createDataset() {
        DefaultXYDataset data = new DefaultXYDataset();
        
        double[] xValues, yValues;
        xValues = new double[_gameHistory.count()];
        yValues = new double[_gameHistory.count()];
        for (int i = 0; i < _gameHistory.count(); i++) {
            xValues[i] = i;
            yValues[i] = _gameHistory.getTurn(i).getEnergyPrice();
                    }
        data.addSeries("Power Price", new double[][] {xValues, yValues});
        
        return data;
    }
    
}

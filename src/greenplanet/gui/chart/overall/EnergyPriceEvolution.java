/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart.overall;

import greenplanet.GameHistory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
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
        _chart = ChartFactory.createXYLineChart(
            "Prix de l'énergie",  // title
            "Tour",             // x-axis label
            "Prix",   // y-axis label
            dataset,            // data
            PlotOrientation.VERTICAL,
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
        );
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, true);
        
        XYPlot plot = (XYPlot) _chart.getPlot();
        plot.setRenderer(renderer);
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

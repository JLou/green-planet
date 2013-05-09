package greenplanet.gui.chart;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

/**
 * End game Chart
 *
 * @author JLou
 */
public abstract class AbstractChart {

    protected JFreeChart _chart;
    protected Dataset _dataset;

    public ChartPanel getPanel() {
        return new ChartPanel(_chart);
    }

    protected abstract Dataset createDataset();
}

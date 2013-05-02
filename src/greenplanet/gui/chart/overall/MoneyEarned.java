package greenplanet.gui.chart.overall;

import greenplanet.GameHistory;
import greenplanet.Turn;
import greenplanet.data.PlayerInfo;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author JLou
 */
public class MoneyEarned extends AbstractChart {

    public MoneyEarned(GameHistory gh) {
        super(gh);
        XYDataset dataset = createDataset();
        _chart = ChartFactory.createXYLineChart(
                "Argent gagné",
                "Tour",
                "Argent en Euros",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }

    @Override
    protected final XYDataset createDataset() {
        DefaultXYDataset dataset = new DefaultXYDataset();

        HashMap<String, double[]> map = new HashMap<>();
        Turn t = _gameHistory.getCurrentTurn();
        int turnCount = _gameHistory.count();
        for (PlayerInfo p : t.getPlayers()) {
            map.put(p.getName(), new double[turnCount]);
        }
        for (int i = 1; i < turnCount; i++) {
            Turn prev = _gameHistory.getTurn(i - 1);
            Turn current = _gameHistory.getTurn(i);

            for (PlayerInfo p : current.getPlayers()) {
                float cash = p.getCash();
                float diff = cash - prev.getPlayer(p.getName()).getCash();
                if (map.containsKey(p.getName())) {
                    double[] data = map.get(p.getName());
                    data[i] = diff;
                    map.put(p.getName(), data);
                }
            }
        }
        
        for (Map.Entry<String, double[]> entry : map.entrySet()) {
            double[] turns = new double[turnCount];
            for (int i = 0; i < turnCount; i++) {
                turns[i] = i+1;
            }
            entry.getValue();
            dataset.addSeries(entry.getKey(), 
                    new double[][] { turns, entry.getValue() });
        }
        return dataset;
    }
}

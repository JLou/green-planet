package greenplanet.gui.chart.turn;

import greenplanet.BuildingInfo;
import greenplanet.Turn;
import greenplanet.data.BuildingValue;
import greenplanet.data.PlayerInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Repartition of the global energy in the turn
 *
 * @author JLou
 */
public class TotalEnergyRepartition extends AbstractTurnChart {

    DefaultPieDataset dataset;

    public TotalEnergyRepartition(Turn t) {
        super(t);
        dataset = createDataset();
        _chart = ChartFactory.createPieChart("Total Energy Repartition",
                dataset, true, true, false);
    }

    @Override
    protected final DefaultPieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();

        for (PlayerInfo p : _turn.getAlivePlayers()) {
            BuildingValue bc = p.getBuildingsValues();
            int total = 0;

            for (BuildingInfo bi : BuildingInfo.getValues()) {
                try {
                    total += bc.getBuildingValue(bi.getIndex());
                } catch (Exception ex) {
                    Logger.getLogger(TotalEnergyRepartition.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            result.setValue(p.getName(), total);
        }
        return result;
    }
}

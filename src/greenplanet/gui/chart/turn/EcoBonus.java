/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart.turn;

import greenplanet.BuildingInfo;
import greenplanet.Turn;
import greenplanet.data.BuildingValue;
import greenplanet.data.PlayerInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author JLou
 */
public class EcoBonus extends AbstractTurnChart {

    DefaultCategoryDataset dataset;
    
    public EcoBonus(Turn t)
    {
        super(t);
        createDataset();
        _chart = ChartFactory.createStackedBarChart("Eco bonus", "Joueur", "Bonus Eco",
                dataset, PlotOrientation.VERTICAL, true, true, false);
    }
    
    @Override
    protected Dataset createDataset() {
        
        dataset = new DefaultCategoryDataset();

        
        for(PlayerInfo p : _turn.getAlivePlayers())
        {
            try {
                dataset.addValue(p.getEcoBonus(), "", p.getName());
            } catch (Exception ex) {
                Logger.getLogger(GameEnergyRepartition.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dataset;
        
    }
    
}

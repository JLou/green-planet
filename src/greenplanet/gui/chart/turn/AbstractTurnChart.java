/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.chart.turn;

import greenplanet.Turn;
import greenplanet.gui.chart.AbstractChart;

/**
 * Chart displaying information about a specific turn
 *
 * @author JLou
 */
public abstract class AbstractTurnChart extends AbstractChart {

    protected Turn _turn;

    public AbstractTurnChart(Turn t) {
        _turn = t;
    }
}

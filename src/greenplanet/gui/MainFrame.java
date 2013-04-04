/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui;

import greenplanet.GameHistory;
import greenplanet.Turn;
import greenplanet.gui.chart.GameEnergyRepartition;
import greenplanet.gui.chart.PiePlayerEnergy;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author JLou
 */
public class MainFrame extends JFrame
{
    public MainFrame()
    {
        /*PiePlayerEnergy p = new PiePlayerEnergy();
        GameEnergyRepartition bars = new GameEnergyRepartition();
        ChartPanel chartPanel = p.getPanel();
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        add(chartPanel);
        add(bars.getPanel());*/

        FlowLayout layout = new FlowLayout();
        Button b = new Button("Play");        
        setLayout(layout);
        add(b);
    }
    
    public void update(GameHistory gh)
    {
        
        
        Turn t = gh.getCurrentTurn();
        GameEnergyRepartition bars = new GameEnergyRepartition(t);
        
        // add it to our application
        ChartPanel cp = bars.getPanel();
        cp.setPreferredSize(new Dimension(500,270));
        add(cp);
        
        PiePlayerEnergy pie = new PiePlayerEnergy(gh.getCurrentTurn(), "Galioadd");
        
        add(pie.getPanel());
        validate();
        
    }
}

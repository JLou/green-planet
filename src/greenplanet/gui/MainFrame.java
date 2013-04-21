package greenplanet.gui;

import greenplanet.GameHistory;
import greenplanet.Turn;
import greenplanet.gui.chart.GameEnergyRepartition;
import greenplanet.gui.chart.PiePlayerEnergy;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author JLou
 */
public class MainFrame extends JFrame
{
    
    JPanel current;
    public MainFrame()
    {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        current = new StartPanel(this);
        add(current);
        
        //add(new OfflineOptionsPanel());
    }
    
    public void update(GameHistory gh)
    {                
        remove(current);

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
    
    public void offlineMode()
    {
        remove(current);
        current = new OfflineOptionsPanel();
        add(current);
        validate();

    }
}

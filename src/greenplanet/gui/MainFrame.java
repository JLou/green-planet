package greenplanet.gui;

import greenplanet.GameHistory;
import greenplanet.Turn;
import greenplanet.gui.chart.turn.GameEnergyRepartition;
import greenplanet.gui.chart.turn.PiePlayerEnergy;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
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
        replacePanel(new OfflineOptionsPanel(this));
    }

    public void onlineMode() {
        replacePanel(new OnlineOptionsPanel());
        
    }
    private void replacePanel(JPanel p)
    {
        remove(current);
        current = p;
        add(current);
        validate();
    }
    public void afterGameMode(GameHistory gh)
    {
        replacePanel(new AfterGamePanel(gh));
    }
}
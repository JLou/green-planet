/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui;

import greenplanet.gui.events.OfflineButtonListener;
import greenplanet.gui.events.OnlineButtonListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author JLou
 */
public class StartPanel extends JPanel
{
    MainFrame _parent;
    
    JButton offlineButton;
    
    JButton onlineButton;
    
    public StartPanel(MainFrame parent)
    {
        super();
        _parent = parent;
        
        FlowLayout layout = new FlowLayout();
        
        setLayout(layout);
        
        offlineButton = new JButton("Play Offline");
        onlineButton = new JButton("Play Online");
        
        OfflineButtonListener list = new OfflineButtonListener(_parent);
        offlineButton.addMouseListener(list);
        
        onlineButton.addMouseListener(new OnlineButtonListener(_parent));
        add(offlineButton);
        add(onlineButton);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.events;

import greenplanet.gui.MainFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author JLou
 */
public class OnlineButtonListener extends MouseAdapter
{

    MainFrame _frame;
    public OnlineButtonListener(MainFrame frame)
    {
        _frame = frame;
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        _frame.onlineMode();
    }
    
}

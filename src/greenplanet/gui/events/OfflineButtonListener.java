/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.events;

import greenplanet.gui.MainFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author JLou
 */
public class OfflineButtonListener implements MouseListener {

    private MainFrame _frame;

    public OfflineButtonListener(MainFrame mf) {
        _frame = mf;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //_frame.update(gh);
        
        _frame.offlineMode();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    /*public int energyproduct(int wind, int nucl, int water, int charb, int sun, )
     {
     return(500*charb+1000*nucl+wind * );
     }*/
}

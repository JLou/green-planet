/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.events;

import greenplanet.GameHistory;
import greenplanet.gui.MainFrame;
import greenplanetclient.ClientException;
import greenplanetclient.ClientInterface;
import greenplanetclient.Game;
import greenplanetclient.GameStateEnum;
import greenplanetclient.OfflineClient;
import greenplanetclient.Order;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author JLou
 */
public class OfflineButtonListener implements MouseListener
{

    private MainFrame _frame;
    
    public OfflineButtonListener(MainFrame mf)
    {
        _frame = mf;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        GameHistory gh = new GameHistory();

        try 
        {
            // create client
            ClientInterface client; 
            client = new OfflineClient("JLou", 10, true); // offline client, 10 bots, verbose mode

            // wait for game to start
            Game game = client.waitForStart();

            // while game is running
            while (game.getState() == GameStateEnum.RUNNING) {
                // display some stufs
                System.out.println("Play turn #" + game.getTurn());
                
                // compute order (AI job)
                ArrayList l = new ArrayList();
                l.add("nuclear");
                Order order = new Order(-900, l);

                // give order, wait for next turn
                game = client.giveOrder(order);
                
                gh.addTurn(game);                
            }
        } catch (JAXBException ex) {
            Logger.getLogger(OfflineButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(OfflineButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClientException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(OfflineButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        _frame.update(gh);
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
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greenplanet.gui.events;

import greenplanet.GameHistory;
import greenplanet.Greenplanet;
import greenplanet.gui.MainFrame;
import greenplanetclient.Client;
import greenplanetclient.ClientException;
import greenplanetclient.ClientInterface;
import greenplanetclient.Game;
import greenplanetclient.GameStateEnum;
import greenplanetclient.OfflineClient;
import greenplanetclient.Order;
import greenplanetclient.Player;
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
        float cash;
        float energy;
        int nucl = 0, wind = 0,water = 0,sun = 0,charb = 0;
        try 
        {
            // create client
            ClientInterface client; 
           //client = new OfflineClient("JLou", 10, true); // offline client, 10 bots, verbose mode
            client = new Client(493,"JLou", true);

            // wait for game to start
            Game game = client.waitForStart();
            
            // while game is running
            while (game.getState() == GameStateEnum.RUNNING) {
                // display some stufs
                System.out.println("Play turn #" + game.getTurn());
                ArrayList l = new ArrayList();
                Order order;
                // compute order (AI job)
                Player us = game.getPlayers().get(0);
                for(Player p : game.getPlayers())
                {
                    if(p.getName().equals("JLou")) {
                        us = p;
                    }
                }
                cash = us.getCash();
                while ((cash > 600)&&(charb <5))
                {
                l.add("coal_fired_plant");
                l.add("wind_turbine");
                l.add("wind_turbine");
                charb++;
                wind = wind + 2;
                cash = cash - 600;
                }
                if (cash > 500)
                {
                l.add("water_turbine");
                water++;
                cash = cash - 500;
                }
                while((cash >100)&&(wind <15))
                {
                        l.add("wind_turbine");
                        wind++;
                        cash = cash - 100;
                }
                System.out.println("Cash:" + cash);
                for(Object s : l)
                    System.out.println(s);
                energy = us.getPowerAvailable()-us.getPowerNeed()/100*20;
                // give order, wait for next turn
                if (game.getTurn() != 1)
                {
                    order = new Order(-((int)energy), l);
                }
                else
                {
                    order = new Order(0,l);
                }
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
    
    /*public int energyproduct(int wind, int nucl, int water, int charb, int sun, )
    {
        return(500*charb+1000*nucl+wind * );
    }*/
    }


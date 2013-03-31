package greenplanet;

import greenplanet.gui.MainFrame;
import greenplanetclient.*;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
/**
 * MMDOFOFO
 * @author JLou
 */
public class Greenplanet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, JAXBException, InterruptedException {
        
        MainFrame frame = new MainFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        
        GameHistory gh = new GameHistory();
        
        try {
            // create client
            ClientInterface client = new OfflineClient("JLou", 10, true); // offline client, 10 bots, verbose mode

            // wait for game to start
            Game game = client.waitForStart();

            // while game is running
            while (game.getState() == GameStateEnum.RUNNING) {
                // display some stufs
                System.out.println("Play turn #" + game.getTurn());
                
                // compute order (AI job)
                ArrayList l = new ArrayList();
                l.add("nuclear");
                Order order = new Order(10, l);

                // give order, wait for next turn
                game = client.giveOrder(order);
                
                gh.addTurn(game);
                
                
            }
        } catch (ClientException ex) {
            System.out.println(ex);
        }
        frame.update(gh);
    }
}

package greenplanet;

import greenplanetclient.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
/**
 *
 * @author JLou
 */
public class Greenplanet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, JAXBException, InterruptedException {
        try {
            // create client
            ClientInterface client = new OfflineClient("JLou", 10, true); // offline client, 10 bots, verbose mode
            //ClientInterface client = new Client(3, "Michel"); // online client

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
            }
        } catch (ClientException ex) {
            System.out.println(ex);
        }
    }
}

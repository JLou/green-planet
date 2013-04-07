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
    }
}

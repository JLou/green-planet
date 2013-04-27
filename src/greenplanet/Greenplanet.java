package greenplanet;

import greenplanet.gui.MainFrame;
import greenplanet.gui.OfflineOptionsPanel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.bind.JAXBException;
/**
 * MMDOFOFO
 * @author JLou
 */
public class Greenplanet {

    /**
     * @param args the command line arguments
     */
    
    public static PrintStream ps;
    public static ByteArrayOutputStream boas;
    public static void main(String[] args) throws IOException, JAXBException, InterruptedException {
        
        
        //Get more handsome UI controls
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(OfflineOptionsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        boas = new ByteArrayOutputStream();
        ps = new PrintStream(boas);
        PrintStream stdout = System.out;
        System.setOut(ps);
        */
        
        MainFrame frame = new MainFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        
    }
}

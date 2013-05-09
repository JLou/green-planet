package greenplanet.gui;

import greenplanet.GameHistory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Program main frame
 *
 * @author JLou
 */
public class MainFrame extends JFrame {

    JPanel current;

    public MainFrame() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        current = new StartPanel(this);
        add(current);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void offlineMode() {
        replacePanel(new OfflineOptionsPanel(this));
    }

    public void onlineMode() {
        replacePanel(new OnlineOptionsPanel());

    }

    private void replacePanel(JPanel p) {
        remove(current);
        current = p;
        add(current);
        validate();
    }

    public void afterGameMode(GameHistory gh) {
        replacePanel(new AfterGamePanel(gh));
    }
}
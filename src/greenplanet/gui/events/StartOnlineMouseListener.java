package greenplanet.gui.events;

import greenplanet.gui.OnlineOptionsPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Start an online game
 *
 * @author JLou
 */
public class StartOnlineMouseListener extends MouseAdapter {

    OnlineOptionsPanel _panel;

    public StartOnlineMouseListener(OnlineOptionsPanel panel) {
        _panel = panel;
    }

    /**
     *
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int gameID = _panel.getGameID();
        String playerName = _panel.getPlayerName();

        //GO START A GAME MOFO
    }
}

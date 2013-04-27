package greenplanet.gui;

import greenplanet.GameHistory;
import greenplanet.Turn;
import greenplanet.data.PlayerInfo;
import greenplanet.gui.chart.overall.EnergyPriceEvolution;
import greenplanet.gui.chart.turn.GameEnergyRepartition;
import greenplanet.gui.chart.turn.PiePlayerEnergy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author JLou
 */
public class AfterGamePanel extends javax.swing.JPanel {

    private GameHistory _gameHistory;

    /**
     * Creates new form AfterGamePanel
     */
    public AfterGamePanel(final GameHistory gh) {
        initComponents();

        _gameHistory = gh;

        final DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        model.addElement("Tous");
        for (PlayerInfo pi : gh.getTurn(0).getPlayers()) {
            model.addElement(pi.getName());
        }

        playerComboBox.setModel(model);
        playerComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultComboBoxModel turnModel = new DefaultComboBoxModel();
                if (playerComboBox.getSelectedIndex() == 0) {
                    for (int i = 0; i < _gameHistory.count(); i++) {
                        turnModel.addElement(i+1);
                    }
                } else {
                    String playerName = model.getSelectedItem().toString();
                    PlayerInfo pi = gh.getTurn(0).getPlayer(playerName);
                    int i = 0;
                    //Only display turns where player is alive
                    while (pi.isAlive()) {
                        i++;
                        turnModel.addElement(new Integer(i));
                        pi = gh.getTurn(i).getPlayer(playerName);
                    }
                }
                turnCombobox.setModel(turnModel);

                turnCombobox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateGraphs();
                    }
                });

                turnCombobox.setSelectedIndex(0);
            }
        });

        //Trigger listeners
        playerComboBox.setSelectedIndex(0);
        turnCombobox.setSelectedIndex(0);

        //Overall charts
        EnergyPriceEvolution epe = new EnergyPriceEvolution(gh);
        OverviewTabbedPanel.addTab("Prix de l'énergie", epe.getPanel());
    }

    /**
     * Update graph panels to match user's choice in comboboxes
     */
    private void updateGraphs() {
        TurnTabbedPanel.removeAll();
        int turn = Integer.parseInt(turnCombobox.getSelectedItem().toString()) - 1;
        //All players
        if (playerComboBox.getSelectedIndex() == 0) {
            GameEnergyRepartition chart = new GameEnergyRepartition(_gameHistory.getTurn(turn));
            TurnTabbedPanel.add("Energy Repartition", chart.getPanel());
        } else {
            String playerName = playerComboBox.getSelectedItem().toString();

            PiePlayerEnergy pie = new PiePlayerEnergy(_gameHistory.getTurn(turn), playerName);
            TurnTabbedPanel.add("Energy Repartition", pie.getPanel());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChartTypeTabbedPanel = new javax.swing.JTabbedPane();
        TurnByTurnPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        playerComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        turnCombobox = new javax.swing.JComboBox();
        TurnTabbedPanel = new javax.swing.JTabbedPane();
        OverviewTabbedPanel = new javax.swing.JTabbedPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        ChartTypeTabbedPanel.setToolTipText("");
        ChartTypeTabbedPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TurnByTurnPanel.setLayout(new javax.swing.BoxLayout(TurnByTurnPanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(500, 60));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(69, 30));

        jLabel2.setText("Joueur :");
        jPanel1.add(jLabel2);

        playerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(playerComboBox);

        jLabel1.setText("Tour: ");
        jPanel1.add(jLabel1);

        turnCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(turnCombobox);

        TurnByTurnPanel.add(jPanel1);

        TurnTabbedPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TurnByTurnPanel.add(TurnTabbedPanel);

        ChartTypeTabbedPanel.addTab("Tour par Tour", TurnByTurnPanel);

        OverviewTabbedPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        ChartTypeTabbedPanel.addTab("Overview", OverviewTabbedPanel);

        add(ChartTypeTabbedPanel);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ChartTypeTabbedPanel;
    private javax.swing.JTabbedPane OverviewTabbedPanel;
    private javax.swing.JPanel TurnByTurnPanel;
    private javax.swing.JTabbedPane TurnTabbedPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox playerComboBox;
    private javax.swing.JComboBox turnCombobox;
    // End of variables declaration//GEN-END:variables
}

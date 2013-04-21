package greenplanet.gui;

import greenplanet.gui.events.StartOfflineButtonListener;
import javax.swing.JTextArea;

/**
 *
 * @author JLou
 */
public class OfflineOptionsPanel extends javax.swing.JPanel {

    /**
     * Creates new form OfflineOptionsPanel
     */
    public OfflineOptionsPanel() {
        
        initComponents();
        
        startGameButton.addMouseListener(new StartOfflineButtonListener(this));

    }
    
    public JTextArea getDebugArea()
    {
        return debugArea;
    }

    public String getPlayerName()
    {
        return playerNameField.getText();
    }
    
    public boolean isDebugActivated()
    {
        return debugCheckBox.isSelected();
    }
    
    public int getBotNumber()
    {
        return botNumberSlider.getValue();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        playerNameField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        botNumberSlider = new javax.swing.JSlider();
        jPanel4 = new javax.swing.JPanel();
        debugCheckBox = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        startGameButton = new javax.swing.JButton();
        debug = new javax.swing.JScrollPane();
        debugArea = new javax.swing.JTextArea();

        setAlignmentX(1.0F);
        setAlignmentY(50.0F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleLabel.setText("Creer une partie offline");
        add(titleLabel);

        jLabel1.setText("Nom du joueur :");
        jPanel1.add(jLabel1);

        playerNameField.setColumns(25);
        playerNameField.setText("JLou");
        playerNameField.setMinimumSize(new java.awt.Dimension(25, 20));
        jPanel1.add(playerNameField);

        add(jPanel1);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setText("Nombre de bots :");
        jPanel3.add(jLabel2);

        botNumberSlider.setMajorTickSpacing(1);
        botNumberSlider.setMaximum(9);
        botNumberSlider.setMinorTickSpacing(1);
        botNumberSlider.setPaintLabels(true);
        botNumberSlider.setPaintTicks(true);
        botNumberSlider.setSnapToTicks(true);
        botNumberSlider.setToolTipText("Bot number");
        botNumberSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botNumberSlider.setMinimumSize(new java.awt.Dimension(50, 50));
        botNumberSlider.setName("Nombre de Bots:"); // NOI18N
        botNumberSlider.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel3.add(botNumberSlider);

        add(jPanel3);

        debugCheckBox.setText("Activer le mode debug");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 181, Short.MAX_VALUE)
                .addComponent(debugCheckBox)
                .addGap(0, 182, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(debugCheckBox)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel4);

        startGameButton.setText("Lancer la partie");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 194, Short.MAX_VALUE)
                    .addComponent(startGameButton)
                    .addGap(0, 195, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(startGameButton)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(jPanel5);

        debugArea.setColumns(20);
        debugArea.setRows(5);
        debugArea.setText("aedqsedzqdqz");
        debugArea.setEnabled(false);
        debug.setViewportView(debugArea);

        add(debug);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider botNumberSlider;
    private javax.swing.JScrollPane debug;
    private javax.swing.JTextArea debugArea;
    private javax.swing.JCheckBox debugCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField playerNameField;
    private javax.swing.JButton startGameButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

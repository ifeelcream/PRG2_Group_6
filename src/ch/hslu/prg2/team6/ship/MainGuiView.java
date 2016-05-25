package ch.hslu.prg2.team6.ship;

/**
 * @author  Samuel Zurbriggen
 */
public class MainGuiView extends javax.swing.JFrame  
{ 
    
    /**
     * Creates new form MainGuiView1
     */
    public MainGuiView() {
        this.setTitle("Battleship");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jFrame = new javax.swing.JFrame();    
        NewGame = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        HomeBoard = new javax.swing.JPanel();
        EnemyBoard = new javax.swing.JPanel();
        Grundtext = new javax.swing.JLabel();
        jLabelPlayer1 = new javax.swing.JLabel();
        jLabelPlayer2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jFrame.setTitle(""); 

        NewGame.setText("new Game");
        NewGame.addActionListener(evt -> {
            NetworkGameGUI newNetworkGame = new NetworkGameGUI();
            newNetworkGame.setVisible(true);
        });

        Exit.setText("Exit");
        Exit.addActionListener(evt -> System.exit(0));

        HomeBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HomeBoard.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout HomeBoardLayout = new javax.swing.GroupLayout(HomeBoard);
        HomeBoard.setLayout(new java.awt.GridLayout(10,10));
        HomeBoardLayout.setHorizontalGroup(
            HomeBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        HomeBoardLayout.setVerticalGroup(
            HomeBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        EnemyBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EnemyBoard.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout EnemyBoardLayout = new javax.swing.GroupLayout(EnemyBoard);
        EnemyBoard.setLayout(new java.awt.GridLayout());
        EnemyBoardLayout.setHorizontalGroup(
            EnemyBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        EnemyBoardLayout.setVerticalGroup(
            EnemyBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        Grundtext.setText("Battleship 1.0");

        jLabelPlayer1.setText("Player 1");

        jLabelPlayer2.setText("Player 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grundtext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelPlayer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPlayer2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(HomeBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EnemyBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewGame)
                    .addComponent(Exit))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlayer2)
                    .addComponent(jLabelPlayer1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomeBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnemyBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(Grundtext, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        // create teh board squares
        

        pack();
    }// </editor-fold>                                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGuiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGuiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGuiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGuiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainGuiView().setVisible(true));
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JPanel HomeBoard;
    private javax.swing.JPanel EnemyBoard;
    private javax.swing.JButton Exit;
    private javax.swing.JLabel Grundtext;
    private javax.swing.JButton NewGame;
    private javax.swing.JLabel jLabelPlayer1;
    private javax.swing.JLabel jLabelPlayer2;
    private javax.swing.JButton Field;
    private javax.swing.JFrame jFrame;
    // End of variables declaration                   
}

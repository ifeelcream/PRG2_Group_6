package ch.hslu.prg2.team6.ship;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class creates the GUI and sends action from the GUI to the controller.
 *
 * @author Tim Egeli
 */
public class SinkShipView extends JFrame {

    /**
     * The controller which is used to perform actions
     */
    private SinkShipController sinkShipController;

    /**
     * The main panel
     */
    private final JPanel gui;

    /**
     * Client object needed to store the ID and shoot a field
     */
    Client player;
    

    /**
     * Initialize the components
     */
    private SinkShipView() {
        this.sinkShipController = new SinkShipController();
        this.gui = new JPanel(new BorderLayout());
        initializeGui();
    }

    /**
     * Place all components on the main panel
     */
    private void initializeGui() {
        JPanel homeBoard = createBoard(new JButton[8][8], new JPanel(new GridLayout(0, 9)));
        JLabel ownBoardLabel = new JLabel("Own Board");
        ownBoardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel enemyBoardLabel = new JLabel("Enemy Board");
        enemyBoardLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel enemyBoard = createBoard(new JButton[8][8], new JPanel(new GridLayout(0, 9)));
        JPanel IPField = getIPField();

        this.gui.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel gamePanel = new JPanel(new BorderLayout());
        JPanel boardTitlePanel = new JPanel(new GridLayout(1,2));
        JPanel boardPanel = new JPanel(new GridLayout(1,2));        
        boardTitlePanel.add(ownBoardLabel);
        boardTitlePanel.add(enemyBoardLabel);
        boardPanel.add(homeBoard);
        boardPanel.add(enemyBoard);
        gamePanel.add(IPField, BorderLayout.PAGE_START);

        //gamePanel.add(boardTitlePanel, BorderLayout.NORTH);


        gamePanel.add(boardPanel,BorderLayout.CENTER);
        gamePanel.add(boardTitlePanel, BorderLayout.PAGE_END);
        
        this.gui.add(gamePanel);
    }

    /**
     * Creates the field with the IP address
     * @return Field with IP address
     */
    private final JPanel getIPField() {
        JPanel panel = new JPanel(new GridLayout(1,2)); // 
        JTextField IPField = new JTextField(10);
        JButton button = new JButton("Connect to Server");

        //button.addActionListener(evt -> this.player = this.sinkShipController.startClient(IPField.getText()));
        button.addActionListener(evt -> {callbackClient(IPField.getText()); });
        panel.add(IPField);
        panel.add(button);

        return panel;
    }
    
    private void callbackClient(String server){        
        this.player = this.sinkShipController.startClient(server);
    }

    private void callbackShot(){}
    
    /**
     * Creates the game field with a board.
     * @param boardSquares JButton array to hold the fields
     * @param board JPanel on which the fields are placed
     * @return The created board
     */
    private final JPanel createBoard(JButton[][] boardSquares, JPanel board) {
        final String COLS = "ABCDEFGH";

        for (int i = 0; i < boardSquares.length; i++) {
            for (int j = 0; j < boardSquares[i].length; j++) {
                JButton button = new JButton();
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setSize(30, 30);
                button.setBackground(Color.BLUE);
                int x = j;
                int y = i;
                button.addActionListener(evt -> this.player.sendShotField((x + 1) + "" + (y + 1)));
                boardSquares[j][i] = button;
            }
        }

        board.add(new JLabel(""));

        for (int i = 0; i < 8; i++) {
            board.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        board.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
                    default:
                        board.add(boardSquares[j][i]);
                }
            }
        }

        return board;
    }

    /**
     * Create the menubar.
     * @return Created menubar
     */
    private final JMenuBar getCustomMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        JMenuItem startServer = new JMenuItem("Start Server");


        menuGame.add(startServer);

        menuBar.add(menuGame);

        startServer.addActionListener(evt -> this.player = this.sinkShipController.startServer());

        return menuBar;
    }

    /**
     * getter for the GUI.
     * @return The complete GUI.
     */
    private final JComponent getGui() {
        return this.gui;
    }

    /**
     * @param args
     */
    public static void main(String args[]) {
        JFrame jFrame = new JFrame("Sink Ships");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setSize(850, 400);
        jFrame.setResizable(false);
        SinkShipView sinkShipView = new SinkShipView();
        jFrame.add(sinkShipView.getGui());
        jFrame.setJMenuBar(sinkShipView.getCustomMenuBar());
        jFrame.setVisible(true);

        EventQueue.invokeLater(() -> new SinkShipView());
    }
}

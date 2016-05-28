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
        JPanel homeBoard = createBoard(new JButton[8][8], new JPanel(new GridLayout(0, 9)), "Own Board");
        JPanel enemyBoard = createBoard(new JButton[8][8], new JPanel(new GridLayout(0, 9)), "Enemy Board");
        JPanel IPField = getIPField();

        this.gui.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel gamePanel = new JPanel(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(0,2));
        boardPanel.add(homeBoard);
        boardPanel.add(enemyBoard);

        gamePanel.add(IPField, BorderLayout.NORTH);
        gamePanel.add(boardPanel,BorderLayout.CENTER);

        this.gui.add(gamePanel);
    }

    /**
     * Creates the field with the IP address
     * @return Field with IP address
     */
    private final JPanel getIPField() {
        JPanel panel = new JPanel(new GridLayout(0,2));
        JTextField IPField = new JTextField(1);
        JButton button = new JButton("Connect to Server");

        button.addActionListener(evt -> this.sinkShipController.startClient(IPField.getText()));
        panel.add(IPField);
        panel.add(button);

        return panel;
    }

    /**
     * Creates the game field with a board.
     * @param boardSquares JButton array to hold the fields
     * @param board JPanel on which the fields are placed
     * @param boardName The name of the board
     * @return The created board
     */
    private final JPanel createBoard(JButton[][] boardSquares, JPanel board, String boardName) {
        final String COLS = "ABCDEFGH";

        for (int i = 0; i < boardSquares.length; i++) {
            for (int j = 0; j < boardSquares[i].length; j++) {
                JButton button = new JButton();
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setBackground(Color.BLUE);
                int x = j;
                int y = i;
                button.addActionListener(evt -> this.player.sendShotField((x + 1) + "" + (y + 1)));
                boardSquares[j][i] = button;
            }
        }

        board.add(new JLabel(boardName));

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
        JMenuItem startClient = new JMenuItem("Start Client");


        menuGame.add(startServer);
        menuGame.add(startClient);

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

        SinkShipView sinkShipView = new SinkShipView();
        jFrame.add(sinkShipView.getGui());
        jFrame.setJMenuBar(sinkShipView.getCustomMenuBar());
        jFrame.pack();
        jFrame.setVisible(true);

        EventQueue.invokeLater(() -> new SinkShipView());
    }
}

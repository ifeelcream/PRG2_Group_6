package ch.hslu.prg2.team6.ship;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author  Samuel Zurbriggen
 */
public class SinkShipView extends JFrame {

    private SinkShipController sinkShipController;

    private final JPanel gui = new JPanel(new BorderLayout(4,4));

    private JButton[][] homeBoardSquares = new JButton[8][8];
    private JButton[][] enemyBoardSquares = new JButton[8][8];

    private JPanel homeBoard;
    private JPanel enemyBoard;

    private static final String COLS = "ABCDEFGH";

    public SinkShipView() {
        this.sinkShipController = new SinkShipController();
        initializeGui();
    }

    public void initializeGui() {
        this.gui.setBorder(new EmptyBorder(5,5,5,5));

        JPanel boardPanel = new JPanel(new GridLayout(0,2));

        this.homeBoard = new JPanel(new GridLayout(0,9));
        this.enemyBoard = new JPanel(new GridLayout(0,9));

        createHomeBoard();
        createEnemyBoard();

        boardPanel.add(this.homeBoard);
        boardPanel.add(this.enemyBoard);

        this.gui.add(boardPanel);
    }

    private void createHomeBoard() {
        for (int i = 0; i < this.homeBoardSquares.length; i++) {
            for (int j = 0; j < this.homeBoardSquares[i].length; j++) {
                JButton button = new JButton();
                button.setMargin(new Insets(0,0,0,0));
                ImageIcon icon = new ImageIcon(new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB));
                button.setIcon(icon);
                button.setBackground(Color.BLUE);
                this.homeBoardSquares[j][i] = button;
            }
        }

        this.homeBoard.add(new JLabel("Own Board"));

        for (int i = 0; i < 8; i++) {
            this.homeBoard.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        this.homeBoard.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
                    default:
                        this.homeBoard.add(this.homeBoardSquares[j][i]);
                }
            }
        }
    }

    private void createEnemyBoard() {
        for (int i = 0; i < this.enemyBoardSquares.length; i++) {
            for (int j = 0; j < this.enemyBoardSquares[i].length; j++) {
                JButton button = new JButton();
                button.setMargin(new Insets(0,0,0,0));
                ImageIcon icon = new ImageIcon(new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB));
                button.setIcon(icon);
                button.setBackground(Color.BLUE);
                this.enemyBoardSquares[j][i] = button;
            }
        }

        this.enemyBoard.add(new JLabel("Enemy Board"));

        for (int i = 0; i < 8; i++) {
            this.enemyBoard.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        this.enemyBoard.add(new JLabel("" + (i + 1), SwingConstants.CENTER));
                    default:
                        this.enemyBoard.add(this.enemyBoardSquares[j][i]);
                }
            }
        }
    }

    private void createFrame() {
        JLabel jLabelPlayer1 = new JLabel();
        JLabel jLabelPlayer2 = new JLabel();

        setLayout(new BorderLayout());

        add(jLabelPlayer1, BorderLayout.WEST);
        add(jLabelPlayer2, BorderLayout.EAST);

        jLabelPlayer1.setText("Player 1");
        jLabelPlayer2.setText("Player 2");


    }

    private final JComponent getGui() {
        return this.gui;
    }

    /**
     * Create the menubar
     */
    private JMenuBar getCustomMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        JMenuItem startServer = new JMenuItem("Start Server");
        JMenuItem startClient = new JMenuItem("Start Client");

        menuGame.add(startServer);
        menuGame.add(startClient);

        menuBar.add(menuGame);

        startServer.addActionListener(evt -> this.sinkShipController.startServer());
        startClient.addActionListener(evt -> this.sinkShipController.startClient());

        return menuBar;
    }

    private void createPlayerFields() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JFrame jFrame = new JFrame("Sink Ships");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        SinkShipView sinkShipView = new SinkShipView();
        jFrame.add(sinkShipView.getGui());
        jFrame.add(sinkShipView.getCustomMenuBar());
        jFrame.pack();
        jFrame.setVisible(true);

        EventQueue.invokeLater(() -> new SinkShipView());
    }
}

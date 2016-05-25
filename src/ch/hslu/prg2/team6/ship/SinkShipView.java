package ch.hslu.prg2.team6.ship;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Tim Egeli on 25/05/2016.
 */
public class SinkShipView extends JFrame {

    private SinkShipController sinkShipController;
    private final JPanel gui = new JPanel(new BorderLayout(4, 4));
    Client player;

    public SinkShipView() {
        this.sinkShipController = new SinkShipController();
        initializeGui();
    }

    public void initializeGui() {
        JPanel homeBoard = createBoard(new JButton[8][8], new JPanel(new GridLayout(0, 9)), "Own Board");
        JPanel enemyBoard = createBoard(new JButton[8][8], new JPanel(new GridLayout(0, 9)), "Enemy Board");

        this.gui.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel boardPanel = new JPanel(new GridLayout(0, 2));

        boardPanel.add(homeBoard);
        boardPanel.add(enemyBoard);

        this.gui.add(boardPanel);
    }

    private JPanel createBoard(JButton[][] boardSquares, JPanel board, String boardName) {
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

        startServer.addActionListener(evt -> {
            this.player = this.sinkShipController.startServer();
        });

        startClient.addActionListener(evt -> {
            this.player = this.sinkShipController.startClient();
        });

        return menuBar;
    }

    /**
     * @param args the command line arguments
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

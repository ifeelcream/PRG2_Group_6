package ch.hslu.prg2.team6.ship;

import java.io.*;
import java.net.*;
import java.util.HashMap;

/**
 * This class provides a TCP server to check the shot fields and proceed them.
 *
 * @author Tim Egeli
 */
public class Server implements Runnable {
    /**
     * The controller which is used to perform actions
     */
    SinkShipController sinkShipController;


    /**
     * Assigns the attributes
     */
    public Server() {
        this.sinkShipController = new SinkShipController();
        //this.battleField = this.sinkShipController.getUpdatedField();
    }

    /**
     * Run the server in a thread.
     */
    public void run() {
        try {
            int serverPort = 4020;
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while(true) {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                PrintWriter toClient = new PrintWriter(server.getOutputStream(),true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(server.getInputStream()));
                String line = fromClient.readLine();
                System.out.println("Server received: " + line);

                try {
                    int id = Integer.parseInt(line.substring(0, 1));

                    if (sinkShipController.hasTurn() == id) {
                        this.sinkShipController.shootField(id, line.substring(1, 3));
                        //Field that was hit toClient.println("lalal");
                        this.sinkShipController.incrementTurn();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch(UnknownHostException ex) {
            ex.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
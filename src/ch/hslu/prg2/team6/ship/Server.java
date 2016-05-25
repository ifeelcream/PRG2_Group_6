package ch.hslu.prg2.team6.ship;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

/**
 * Created by Tim Egeli on 22/05/2016.
 */
public class Server implements Runnable {
    SinkShipController sinkShipController;
    HashMap<Integer, int[][]> battleField;

    public Server() {
        this.sinkShipController = new SinkShipController();
        this.battleField = this.sinkShipController.getUpdatedField();
    }

    public void run() {
        try (DatagramSocket socket = new DatagramSocket(42321)) {
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] data = packet.getData();
                String receivedField = new String(data);

                try {
                    // Get the ID from the shooting machine
                    int id = Integer.parseInt(receivedField.substring(0, 1));

                    // Only shoot the field, when the player has his turn
                    if (sinkShipController.hasTurn() == id) {
                        this.sinkShipController.shootField(id, receivedField);
                        this.sinkShipController.incrementTurn();
                        // Field muss in bytes umgewandelt werden
                        packet = new DatagramPacket(this.battleField, this.battleField.length, address, port);
                        socket.send(packet);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
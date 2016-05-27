package ch.hslu.prg2.team6.ship;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

/**
 * This class provides a UDP server to check the shot fields and proceed them.
 *
 * @author Tim Egeli
 */
public class Server implements Runnable {
    /**
     * The controller which is used to perform actions
     */
    SinkShipController sinkShipController;

    /**
     * The initial battlefield
     */
    HashMap<Integer, int[][]> battleField;

    /**
     * Assigns the attributes
     */
    public Server() {
        this.sinkShipController = new SinkShipController();
        this.battleField = this.sinkShipController.getUpdatedField();
    }

    /**
     * Run the server in a thread.
     */
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
                        HashMap<Integer, int[][]> field = this.sinkShipController.getUpdatedField();

                        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
                        ObjectOutput oo = new ObjectOutputStream(bStream);
                        oo.writeObject(field);
                        byte[] buffer = bStream.toByteArray();

                        packet = new DatagramPacket(buffer, buffer.length, address, port);
                        socket.send(packet);
                        this.sinkShipController.incrementTurn();
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
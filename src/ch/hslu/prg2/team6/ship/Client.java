package ch.hslu.prg2.team6.ship;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

/**
 * This class provides a UDP client to send data to the server.
 *
 * @author Tim Egeli
 */
public class Client {
    /**
     * Id with which the client can be identified, must be unique.
     */
    private final int id;

    /**
     * IP Address of the server
     */
    private String IPAddress;

    /**
     * Assign the attributes
     * @param id The unique id
     * @param IPAddress The server IP address
     */
    public Client(int id, String IPAddress) {
        this.id = id;
        this.IPAddress = IPAddress;
    }

    /**
     * Sends the data from the client to the server.
     * @param data Data to send to the server
     */
    private void sendData(byte[] data) {

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(this.IPAddress);
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 42321);
            socket.send(packet);
            socket.receive(packet);
            byte[] receivedData = packet.getData();

            ByteArrayInputStream baos = new ByteArrayInputStream(receivedData);
            ObjectInputStream oos = new ObjectInputStream(baos);

            HashMap<Integer, int[][]> field = (HashMap<Integer, int[][]>)oos.readObject();
            System.out.println(field);

            //An Controller das Feld senden, dieser updated GUI mit neuen Daten und gibt repaint
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Sends the shot field to the server.
     * @param field The field that was clicked
     */
    public void sendShotField(String field) {
        sendData((this.id + field).getBytes());
    }

    /**
     * Gets the id from the client.
     * @return Client id
     */
    public int getId() {
        return this.id;
    }
}

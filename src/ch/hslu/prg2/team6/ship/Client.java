package ch.hslu.prg2.team6.ship;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;

/**
 * Created by Tim Egeli on 22/05/2016.
 */
public class Client {
    private int id;

    public Client(int id) {
        this.id = id;
    }

    public void sendShotField(String field) {
        try (DatagramSocket socket = new DatagramSocket()){
            InetAddress address = InetAddress.getByName("localhost");
            byte[] message = (field+id).getBytes();
            DatagramPacket packet = new DatagramPacket(message, message.length, address, 42321);
            socket.send(packet);
            socket.receive(packet);
            byte[] data = packet.getData();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

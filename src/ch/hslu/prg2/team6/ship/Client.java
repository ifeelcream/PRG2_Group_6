package ch.hslu.prg2.team6.ship;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Tim Egeli on 22/05/2016.
 */
public class Client {
    private int id;

    public Client(int id) {
        this.id = id;
    }

    private void sendData(byte[] data) {

        try (DatagramSocket socket = new DatagramSocket()){
            InetAddress address = InetAddress.getByName("192.168.1.198");
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 42321);
            socket.send(packet);
            socket.receive(packet);
            byte[] receivedData = packet.getData();
            //String message = new String(receivedData);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void sendShotField(String field) {
        sendData((this.id+field).getBytes());
    }
}

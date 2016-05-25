package ch.hslu.prg2.team6.ship;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

/**
 * Created by Tim Egeli on 22/05/2016.
 */
public class Client {
    private int id;
    private String IPAddress;

    public Client(int id, String IPAddress) {
        this.id = id;
        this.IPAddress = IPAddress;
    }

    private void sendData(byte[] data) {

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(this.IPAddress);
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 42321);
            socket.send(packet);
            socket.receive(packet);
            byte[] receivedData = packet.getData();
            // Daten nach HashMap umwandeln und mit id die Felder auslesen und anzeigen
            //HashMap<Integer, int[][]> updatedFields = new HashMap<Integer, int[][]>(receivedData);
            //An Controller das Feld senden, dieser updated GUI mit neuen Daten und gibt repaint
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void sendShotField(String field) {
        sendData((this.id + field).getBytes());
    }

    public int getId() {
        return this.id;
    }
}

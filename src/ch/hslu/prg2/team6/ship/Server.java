package ch.hslu.prg2.team6.ship;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Tim Egeli on 22/05/2016.
 */
public class Server {
    SinkShipController c;

    public Server() {
        this.c = new SinkShipController();
        this.c.createField(1);
        //Über Controller
        //Platzierung Clients schicken

        try (DatagramSocket socket = new DatagramSocket(42321)) {
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] data = packet.getData();


                /**if(c.hasTurn(data.id.toString())) {
                    this.c.shootField(data.field.toString());
                    // Hier dann an Controller Daten senden
                    //data =
                    // Verifikation?
                    packet = new DatagramPacket(data, data.length, address, port);
                    socket.send(packet);
                    c.hasTurn(false);
                }**/
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


}
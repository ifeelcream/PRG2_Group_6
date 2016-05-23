import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;

/**
 * Created by Tim Egeli on 22/05/2016.
 */
public class Client {

    public void sendShotField(String field) {
        try (DatagramSocket socket = new DatagramSocket()){
            InetAddress address = InetAddress.getByName("localhost");
            byte[] message = field.getBytes();
            DatagramPacket packet = new DatagramPacket(message, message.length, address, 42321); //byte, nicht string
            socket.send(packet);
            socket.receive(packet);
            byte[] data = packet.getData();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

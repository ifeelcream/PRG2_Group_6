import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Tim Egeli on 22/05/2016.
 */
public class Client {

    public static void main(final String[] args) {

        try (DatagramSocket socket = new DatagramSocket()){
            InetAddress address = InetAddress.getByName("localhost");
            byte[] raw = new byte[1024];
            DatagramPacket packet = new DatagramPacket(raw, raw.length, address, 42321);
            socket.send(packet);
            socket.receive(packet);
            byte[] data = packet.getData();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

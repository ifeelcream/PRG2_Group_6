package ch.hslu.prg2.team6.ship;

import java.io.*;
import java.net.*;
import java.util.HashMap;

/**
 * This class provides a TCP client to send data to the server.
 *
 * @author TE
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
    private void sendData(String data) {

        try {
            int serverPort = 4020;
            InetAddress host = InetAddress.getByName(this.IPAddress);
            System.out.println("Connecting to server on port " + serverPort);

            Socket socket = new Socket(host,serverPort);
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            PrintWriter toServer = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toServer.println(data);
            String line = fromServer.readLine();
            System.out.println("Client received: " + line + " from Server");
            // Todo: Update Gui, disable button in own field or change color in opponent field. 
            toServer.close();
            fromServer.close();
            socket.close();
        } catch(UnknownHostException ex) {
            ex.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Sends the shot field to the server.
     * @param field The field that was clicked
     */
    public void sendShotField(String field) {
        System.out.println("shooting");
        sendData((this.id + field));
    }

    /**
     * Gets the id from the client.
     * @return Client id
     */
    public int getId() {
        return this.id;
    }
}

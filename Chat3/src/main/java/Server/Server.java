package Server;

import java.io.IOException;
import java.net.*;


public class Server{

    public static void main(String[] args) throws IOException {
        try {
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            System.out.println("服务器IP：" + serverIP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        ServerSocket server = new ServerSocket(8848);
        new ServerFrame(server);
    }
}
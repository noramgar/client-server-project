import java.net.*;
import java.io.*;

public class MultiServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 4444;
        System.out.println("Server is running on port " + portNumber);
        ServerSocket serverSocket = new ServerSocket(portNumber);
        boolean listening = true;
        
        while (listening) {
            Socket clientSocket = serverSocket.accept();  
            new MultiServerThread(clientSocket).start();
        }

        serverSocket.close();
    }
}
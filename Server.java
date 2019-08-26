import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        
        int portNumber = 4444;
        System.out.println("Server is running on port " + portNumber);
        
        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();     
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            out.println("Server sends back " + inputLine);
        }
    }
}
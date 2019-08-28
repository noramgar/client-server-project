import java.io.*;
import java.net.*;
import java.util.*;
import java.text.DateFormat;

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
            //out.println("Server sends back " + inputLine);

            runCommand(Integer.parseInt(inputLine), out);
        }
    }

    static void runCommand(int command, PrintWriter out) throws IOException {
        
        String processCommand = null;
        
        switch (command) {
            case 1:
                processCommand = "date";
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
        
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(processCommand);
        BufferedReader commandResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
        
        String s = null;
        while ((s = commandResult.readLine()) != null) {
            out.println(s);
        }
    }
}
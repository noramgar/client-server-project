import java.net.*;
import java.io.*;

public class MultiServerThread extends Thread {
    private Socket clientSocket = null;

    public MultiServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    public void run() {

        // create readers and writers
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                runCommand(Integer.parseInt(inputLine), out);
            
            out.close();
            in.close();
            clientSocket.close();
        }
        catch (IOException e) {}
    }

    static void runCommand(int command, PrintWriter out) throws IOException {
        
        String processCommand = null;
        
        switch (command) {
            case 1:
                processCommand = "date";
                break;
            case 2:
                processCommand = "uptime";
                break;
            case 3:
                processCommand = "free";
                break;
            case 4:
                processCommand = "netstat";
                break;
            case 5:
                processCommand = "who";
                break;
            case 6:
                processCommand = "ps -e";
                break;
            case 7:
                return;
        }
        
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(processCommand);
        BufferedReader commandResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
       
        String line = null;
        while ((line = commandResult.readLine()) != null)
            out.println(line);

        out.println("end");
    }
}
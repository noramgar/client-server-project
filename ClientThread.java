import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientThread extends Thread {
    long time = -1;
    int command;

    public void run() {
        long startTime = System.currentTimeMillis();
        processRequest();
        long endTime = System.currentTimeMillis();
        time = endTime - startTime;
    }

    private void processRequest() {
        String serverHostname = "localhost";
        int serverPortNumber = 4444;
        
        Scanner in = null;
        Socket clientSocket = null;
        PrintWriter out = null;

        try {
            clientSocket = new Socket(serverHostname, serverPortNumber);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
            out.println(command);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder response = new StringBuilder();

        String line = null;
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (line.equals("end")) break;

            response.append(line + "\n");
        }

        //System.out.println(response.toString());

        out.close();
        in.close();
    }
}
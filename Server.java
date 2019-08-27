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

    static void runCommand(int command, PrintWriter out) {
        switch (command) {
            case 1:
                String dateAndTime = getDateAndTime();
                out.println(dateAndTime);
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
    }

    static String getDateAndTime() {
        Date currentDate = new Date();
        Locale currentLocale = new Locale("en", "US");
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
        String timeOutput = timeFormatter.format(currentDate);
        String dateOutput = dateFormatter.format(currentDate);
        return timeOutput + " - " + dateOutput;
    }
}
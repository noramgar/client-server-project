import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, UnknownHostException {

        if (args.length != 1) {
            System.out.println("Error: user must enter server hostname as command line argument");
            return;
        }

        String serverHostname = args[0];
        int portNumber = 4444;
        Scanner sc = new Scanner(System.in);
        
        Socket clientSocket = new Socket(serverHostname, portNumber);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {
            System.out.println();
            System.out.println("Commands:");
            System.out.println("-----------------------------");
            System.out.println("1. Host current date and time");
            System.out.println("2. Host uptime");
            System.out.println("3. Host memory use");
            System.out.println("4. Host Netstat");
            System.out.println("5. Host current users");
            System.out.println("6. Host running processes");
            System.out.println("7. Quit");
            System.out.println();
            System.out.print("Choose an option: ");
            String input = sc.next();

            if (input.equals("7"))
                break;
        }
    }
}
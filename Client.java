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
        int serverPortNumber = 4444;
        Scanner sc = new Scanner(System.in);
        
        Socket clientSocket = new Socket(serverHostname, serverPortNumber);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));

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
            
            String userInput = sc.nextLine();
            int commandNum = 0;

            try {
                commandNum = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {

            } finally {
                if (commandNum >= 1 && commandNum <= 7) {
                    out.println(commandNum);
                }
                else {
                    System.out.println("Error: invalid command");
                    continue;
                }
            }

            if (userInput.equals("7"))
                break;
            
            StringBuilder response = new StringBuilder();
            String line = null;
            while ( !(line = in.nextLine()).equals("end")) {
                response.append(line + "\n");
            }
            
            System.out.println("response:");
            System.out.println(response.toString());   
        }
    }
}
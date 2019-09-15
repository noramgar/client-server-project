import java.util.*;

public class ClientSimulation {
    public static void main(String[] args) throws InterruptedException {
        int[] clientCounts = new int[]{1, 5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};


        System.out.println("light load response times");
        // light load (date/time command)
        for (int count: clientCounts) {
            runClients(count, 1);
        }

        System.out.println("heavy load response times");
        // heavy load (date/time command)
        for (int count: clientCounts) {
            runClients(count, 4);
        }

        
    }

    static void runClients(int clientCount, int command) throws InterruptedException {
        long[] responseTimes = new long[clientCount];
        ClientThread[] clients = new ClientThread[clientCount];

        for (int i = 0; i < clientCount; i++) {
            clients[i] = new ClientThread();
        }

        for (ClientThread thread: clients) {
            thread.start();
        }

        for (ClientThread thread: clients) {
            thread.join();
        }

        for (int i = 0; i < clientCount; i++) {
            responseTimes[i] = clients[i].time;
        }

        System.out.println(Arrays.toString(responseTimes));
    }
}
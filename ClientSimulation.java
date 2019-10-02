import java.util.*;

public class ClientSimulation {
    public static void main(String[] args) throws InterruptedException {
        int[] clientCounts = new int[]{1, 5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println("light load response times");
        System.out.println("--------------------------");

        // light load (date/time command)
        for (int count: clientCounts)
            runClients(count, 1);

        System.out.println();
        System.out.println("heavy load response times");
        System.out.println("--------------------------");

        // heavy load (date/time command)
        for (int count: clientCounts)
            runClients(count, 4);

        System.out.println();
    }

    static void runClients(int clientCount, int command) throws InterruptedException {
        long[] responseTimes = new long[clientCount];
        ClientThread[] clients = new ClientThread[clientCount];

        for (int i = 0; i < clientCount; i++) {
            clients[i] = new ClientThread();
            clients[i].command = command;
        }

        for (ClientThread thread: clients)
            thread.start();

        for (ClientThread thread: clients)
            thread.join();

        for (int i = 0; i < clientCount; i++)
            responseTimes[i] = clients[i].time;

        long totalResponseTime = 0;
        for(long time: responseTimes)
            totalResponseTime += time;

        System.out.printf("%3d clients: %d ms\n", clientCount, totalResponseTime/clientCount);
    }
}
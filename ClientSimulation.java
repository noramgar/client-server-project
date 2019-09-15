import java.util.*;

public class ClientSimulation {
    public static void main(String[] args) throws InterruptedException {
        int clientCount = 10;

        long[] lightLoadResponseTimes = new long[clientCount];
        long[] heavyLoadResponseTimes = new long[clientCount];

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
            lightLoadResponseTimes[i] = clients[i].time;
        }

        System.out.println(Arrays.toString(lightLoadResponseTimes));
    }
}

class ClientThread extends Thread {
    long time;

    public void run() {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 130; i++)
            System.out.println("ayyyy");
        long endTime = System.currentTimeMillis();
        time = endTime - startTime;
    }
}
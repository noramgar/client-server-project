public class ClientThread extends Thread {
    long time;
    int command;

    public void run() {
        long startTime = System.currentTimeMillis();
        String s = "";
        for(int i = 0; i < 2222; i++)
            s += "ayyyy";
        long endTime = System.currentTimeMillis();
        time = endTime - startTime;
    }
}
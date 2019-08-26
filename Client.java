public class Client {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Error: user must enter server hostname as command line argument");
            return;
        }

        String serverHostname = args[0];
        System.out.println(serverHostname);
    }
}
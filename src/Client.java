import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Conectado ao servidor: " + socket);

            Game game = new Game(socket);
            Thread thread = new Thread(game);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

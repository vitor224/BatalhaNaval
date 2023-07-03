import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor iniciado. Aguardando conexões...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Novo jogador conectado: " + socket);

                Game game = new Game(socket);
                Thread thread = new Thread(game);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

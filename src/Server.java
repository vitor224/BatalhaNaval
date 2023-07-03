import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Aguardando conexão do adversário...");
        socket = serverSocket.accept();
        System.out.println("Conexão estabelecida com o adversário.");
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException {
        outputStream.writeObject(message);
        outputStream.flush();
    }

    public Message receive() throws IOException, ClassNotFoundException {
        return (Message) inputStream.readObject();
    }

    public void close() throws IOException {
        serverSocket.close();
        socket.close();
    }
}

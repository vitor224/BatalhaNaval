import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Client(String ipAddress, int port) throws IOException {
        socket = new Socket(ipAddress, port);
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
        socket.close();
    }
}

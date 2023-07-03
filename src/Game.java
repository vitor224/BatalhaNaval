import java.io.IOException;
import java.util.Scanner;

public class Game {
    private String ipAddress;
    private int port;

    public Game(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        try {
            Client client = new Client(ipAddress, port);
            Server server = new Server(port);
            boolean isClientTurn = true;

            while (true) {
                if (isClientTurn) {
                    System.out.print("Digite a coordenada do tiro: ");
                    String coordinate = scanner.nextLine();
                    // Lógica para processar o tiro e criar uma mensagem com as coordenadas
                    Message message = new Message(coordinate);
                    client.send(message);
                } else {
                    System.out.println("Aguardando tiro do adversário...");
                    Message receivedMessage = server.receive();
                    // Lógica para processar o tiro recebido e mostrar o resultado
                    System.out.println("O adversário atirou em: " + receivedMessage.getCoordinate());
                }

                isClientTurn = !isClientTurn;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

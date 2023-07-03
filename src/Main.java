import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o endereço IP do adversário: ");
        String ipAddress = scanner.nextLine();

        // Agora você pode usar a variável 'ipAddress' para estabelecer a conexão com o adversário
        // e iniciar o jogo

        // Exemplo de uso:
        // Game game = new Game(ipAddress);
        // game.start();

        scanner.close();
    }
}
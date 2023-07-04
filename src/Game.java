import java.util.Scanner;

public class Game {
    private Board player1Board;
    private Board player2Board;
    private Scanner scanner;

    public Game() {
        player1Board = new Board(10, 10);
        player2Board = new Board(10, 10);
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Jogo de Batalha Naval - Posicionamento das Embarcações");
        System.out.println("-----------------------------------------------");

        setupGame();

        System.out.println("-----------------------------------------------");
        System.out.println("Jogo iniciado!");
        System.out.println();

        // Implemente a lógica do jogo aqui
        // Loop principal do jogo, onde os jogadores se alternam para fazer seus movimentos

        while (true) {
            // Jogador 1 faz seu movimento

            // Jogador 2 faz seu movimento

            // Verifica se houve um vencedor

            // Se houver um vencedor, encerra o jogo e exibe a mensagem de vitória

            // Caso contrário, o loop continua para o próximo turno
        }
    }

    private void setupGame() {
        System.out.println("Jogador 1, posicione suas embarcações:");
        placeShips(player1Board);

        System.out.println("Jogador 2, posicione suas embarcações:");
        placeShips(player2Board);
    }

    private void placeShips(Board board) {
        System.out.println("Posicione suas embarcações no tabuleiro:");

        placeShip(board, "Porta-aviões (P)", 'P', 5);
        placeShip(board, "Navio-tanque (N)", 'N', 4);
        placeShip(board, "Contra-torpedeiro (C)", 'C', 3);
        placeShip(board, "Submarino (S)", 'S', 2);

        System.out.println("Suas embarcações foram posicionadas:");
        board.printBoard();
        System.out.println();
    }

    private void placeShip(Board board, String shipName, char shipSymbol, int shipSize) {
        System.out.println("Posicione o " + shipName + " de tamanho " + shipSize + ":");

        Ship ship = new Ship(shipName, shipSymbol, shipSize);

        boolean shipPlaced = false;
        while (!shipPlaced) {
            System.out.print("Digite a coordenada inicial (linha coluna): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            scanner.nextLine(); // Limpar o buffer do scanner

            System.out.print("Digite a orientação (horizontal ou vertical): ");
            String orientation = scanner.nextLine();

            if (board.canPlaceShip(ship, row, col, orientation)) {
                board.placeShip(ship, row, col, orientation);
                shipPlaced = true;
            } else {
                System.out.println("Posição inválida! Tente novamente.");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

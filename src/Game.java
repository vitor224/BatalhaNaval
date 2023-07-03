import java.util.Scanner;

public class Game {
    private Board playerBoard;
    private Scanner scanner;

    public Game() {
        playerBoard = new Board(10, 10);
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Posicione suas embarcações no tabuleiro:");

        placeShips();

        System.out.println("Suas embarcações foram posicionadas:");
        playerBoard.printBoard();
    }

    private void placeShips() {
        placeShip("Porta-aviões (P)", 'P', 5);
        placeShip("Navio-tanque (N)", 'N', 4);
        placeShip("Contra-torpedeiro (C)", 'C', 3);
        placeShip("Submarino (S)", 'S', 2);
    }

    private void placeShip(String shipName, char shipSymbol, int shipSize) {
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

            if (playerBoard.canPlaceShip(ship, row, col, orientation)) {
                playerBoard.placeShip(ship, row, col, orientation);
                shipPlaced = true;
            } else {
                System.out.println("Posição inválida! Tente novamente.");
            }
        }

        playerBoard.printBoard();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

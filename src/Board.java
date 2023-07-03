public class Board {
    private char[][] grid;

    public Board(int rows, int columns) {
        grid = new char[rows][columns];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("   A B C D E F G H I J");
        for (int i = 0; i < grid.length; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public boolean isPositionEmpty(int row, int col) {
        return grid[row][col] == '-';
    }

    public boolean canPlaceShip(Ship ship, int row, int col, String orientation) {
        int size = ship.getSize();
        int deltaRow = 0;
        int deltaCol = 0;
        if (orientation.equalsIgnoreCase("horizontal")) {
            deltaCol = 1;
        } else if (orientation.equalsIgnoreCase("vertical")) {
            deltaRow = 1;
        } else {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!isValidPosition(row, col) || !isPositionEmpty(row, col)) {
                return false;
            }
            row += deltaRow;
            col += deltaCol;
        }
        return true;
    }

    public void placeShip(Ship ship, int row, int col, String orientation) {
        int size = ship.getSize();
        int deltaRow = 0;
        int deltaCol = 0;
        if (orientation.equalsIgnoreCase("horizontal")) {
            deltaCol = 1;
        } else if (orientation.equalsIgnoreCase("vertical")) {
            deltaRow = 1;
        }
        for (int i = 0; i < size; i++) {
            grid[row][col] = ship.getSymbol();
            row += deltaRow;
            col += deltaCol;
        }
    }
}

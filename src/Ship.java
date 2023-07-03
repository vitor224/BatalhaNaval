public class Ship {
    private String name;
    private char symbol;
    private int size;

    public Ship(String name, char symbol, int size) {
        this.name = name;
        this.symbol = symbol;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getSize() {
        return size;
    }
}

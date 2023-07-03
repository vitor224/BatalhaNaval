import java.io.Serializable;

public class Message implements Serializable {
    private String coordinate;

    public Message(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getCoordinate() {
        return coordinate;
    }
}

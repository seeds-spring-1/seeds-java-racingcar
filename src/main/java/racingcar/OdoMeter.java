package racingcar;

public class OdoMeter {
    private int distance;

    public OdoMeter() {
        distance = 0;
    }

    public void add(int distance) {
        this.distance += distance;
    }

    public int get() {
        return distance;
    }

    public String toString() {
        return new String(new char[distance]).replace("\0", "-");
    }
}
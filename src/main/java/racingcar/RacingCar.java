package racingcar;

public class RacingCar {
    private final OdoMeter odoMeter;

    public RacingCar() {
        odoMeter = new OdoMeter();
    }

    public OdoMeter getOdoMeter() {
        return odoMeter;
    }

    public void moveForward() {
        odoMeter.add(1);
    }
}

package application;

public class StandardSensor implements Sensor{
    private int number;

    public StandardSensor(int n) {
        number = n;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {

    }

    @Override
    public void setOff() {

    }

    @Override
    public int read() {
        return number;
    }
}

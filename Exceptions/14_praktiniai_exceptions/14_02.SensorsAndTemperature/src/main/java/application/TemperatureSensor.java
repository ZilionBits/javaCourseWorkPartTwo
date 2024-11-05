package application;

public class TemperatureSensor implements Sensor{
    private boolean sensorPosition = false;

    @Override
    public boolean isOn() {
        return sensorPosition;
    }

    @Override
    public void setOn() {
        sensorPosition = true;
    }

    @Override
    public void setOff() {
        sensorPosition = false;
    }

    @Override
    public int read() throws IllegalArgumentException {
        if(!sensorPosition) {
            throw new IllegalArgumentException();
        }
        return (int)(Math.random() * 61)-30;
    }
}

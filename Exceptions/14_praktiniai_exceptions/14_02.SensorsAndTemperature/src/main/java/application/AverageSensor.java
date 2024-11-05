package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> sensors = new ArrayList<>();
    private boolean averageSensorStatus;
    private List<Integer> tempReadings = new ArrayList<>();

    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
        averageSensorStatus = toAdd.isOn();
    }

    @Override
    public boolean isOn() {
        return averageSensorStatus;
    }

    @Override
    public void setOn() {
        for(Sensor s : sensors){
            s.setOn();
        }
        averageSensorStatus = true;
    }

    @Override
    public void setOff() {
        for(Sensor s : sensors){
            s.setOff();
        }
        averageSensorStatus = false;
    }

    @Override
    public int read() throws IllegalArgumentException {
        if (!averageSensorStatus) {
            throw new IllegalArgumentException();
        }
        int temp = sensors.stream()
                .mapToInt(Sensor::read)
                .sum()/sensors.size();

        tempReadings.add(temp);

        return temp;
    }

    public List<Integer> readings() {
        return tempReadings;
    }
}

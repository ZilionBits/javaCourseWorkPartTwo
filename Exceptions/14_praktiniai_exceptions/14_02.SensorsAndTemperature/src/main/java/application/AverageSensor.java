package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> sensors = new ArrayList<>();
    private List<Integer> tempReadings = new ArrayList<>();

    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        if(sensors.stream().anyMatch(Sensor::isOn)) {
            return true;
        }
        return false;
    }

    @Override
    public void setOn() {
        for(Sensor s : sensors){
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for(Sensor s : sensors){
            s.setOff();
        }
    }

    @Override
    public int read() throws IllegalArgumentException {
        if (sensors.stream().anyMatch(s -> s.isOn() == false)) {
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

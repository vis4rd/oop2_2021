import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class SensorManager
{
    private final Map<String, Sensor> sensorMap;

    public SensorManager() {
        sensorMap = new HashMap<>();
    }

    public void printSensors() {
        sensorMap.values().forEach(System.out::println);
    }

    public void addTemperatureSensor(String name) throws SensorPresentException
    {
        if(this.sensorMap.containsKey(name))
        {
            throw new SensorPresentException();
        }
        else
        {
            this.sensorMap.put(name, new TemperatureSensor(name, true));
        }
    }

    public void addAverageSensor(String name) throws SensorPresentException
    {
        if(this.sensorMap.containsKey(name))
        {
            throw new SensorPresentException();
        }
        else
        {
            this.sensorMap.put(name, new AverageSensor(name, true));
        }
    }

    public void addTemperatureSensorToAverageSensor(String average, String temperature) throws SensorNotFoundException
    {
        if(!this.sensorMap.containsKey(average))
        {
            throw new SensorNotFoundException();
        }
        if(!this.sensorMap.containsKey(temperature))
        {
            throw new SensorNotFoundException();
        }
        var avg = (AverageSensor)this.sensorMap.get(average);
        var temp = this.sensorMap.get(temperature);

        avg.addSensor(temp);
    }

    public void turnOff(String name) throws SensorNotFoundException
    {
        if(!this.sensorMap.containsKey(name))
        {
            throw new SensorNotFoundException();
        }
        else
        {
            var avg = this.sensorMap.get(name);
            avg.setOff();
        }
    }

    public void turnOn(String name) throws SensorNotFoundException
    {
        if(!this.sensorMap.containsKey(name))
        {
            throw new SensorNotFoundException();
        }
        else
        {
            var avg = this.sensorMap.get(name);
            avg.setOn();
        }
    }

    public int getSensorReadings(String name) throws SensorNotFoundException
    {
        if(!this.sensorMap.containsKey(name))
        {
            throw new SensorNotFoundException();
        }
        else
        {
            var avg = this.sensorMap.get(name);
            return avg.read();
        }
    }

    public List<Integer> getAverageSensorReadingList(String name) throws SensorNotFoundException
    {
        if(!this.sensorMap.containsKey(name))
        {
            throw new SensorNotFoundException();
        }
        else
        {
            var avg = (AverageSensor)this.sensorMap.get(name);
            return avg.readings();
        }
    }
}

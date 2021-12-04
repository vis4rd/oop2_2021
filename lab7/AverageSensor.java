import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor
{
    private HashSet<Sensor> sensors;
    // private final int measurement = new java.util.Random().nextInt(60) - 30;
    private final String name;
    private boolean state = false;

    {
        this.sensors = new HashSet<>();
    }

    AverageSensor(String name, boolean init_state)
    {
        this.name = name;
        this.state = init_state;
    }

    public boolean isOn()
    { 
        boolean check = true;
        for (var i : this.sensors)
        {
            check = check && i.isOn();
        }
        return check;
    }
    public void setOn()
    {
        // this.sensors.forEach(Sensor::setOn());
        for(var t : this.sensors)
        {
            t.setOn();
        }
    }
    public void setOff()
    {
        for(var t : this.sensors)
        {
            t.setOff();
        }
    }
    public int read() throws IllegalStateException
    {
        if(!isOn())
        {
            throw new IllegalStateException();
        }
        else
        {
            int sum = 0;
            for (var el : this.sensors)
            {
                try
                {
                    sum += el.read();
                }
                catch(IllegalStateException e)
                {
                    System.out.println("Can't read from a turned off sensor.");
                    throw e;
                }
            }

            return sum / this.sensors.size();
        }
    }

    public void addSensor(Sensor new_sensor)
    {
        this.sensors.add(new_sensor);
    }

    public List<Integer> readings() throws IllegalStateException
    {
        var result = new ArrayList<Integer>();
        for(var i : this.sensors)
        {
            try
            {
                result.add(i.read());
            }
            catch(IllegalStateException e)
            {
                throw e;
            }
        }
        return result;
    }

    @Override
    public String toString()
    {
        return
            "AverageSensor{" +
            "state=" +
            state +
            '}';
    }
}

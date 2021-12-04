import java.util.Random;

public class TemperatureSensor implements Sensor
{
    // private static Random r = new java.util.Random();
    private final int measurement = new java.util.Random().nextInt(60) - 30;
    private final String name;
    private boolean state;

    TemperatureSensor(String name, boolean init_state)
    {
        this.name = name;
        this.state = init_state;
    }

    public String toString()
    {
        String running = "";
        if(state) running = "running";
        else running = "stopped";

        return name + ", state:" + running;
    }

    public boolean isOn() { return this.state; }
    public void setOn() { this.state = true; }
    public void setOff() { this.state = false; }
    public int read() throws IllegalStateException
    {
        if(!isOn())
        {
            throw new IllegalStateException();
        }
        else
        {
            return this.measurement;
        }
    }
}
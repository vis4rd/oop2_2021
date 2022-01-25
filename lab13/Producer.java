import java.lang.Thread;

class Producer extends Thread
{
    Buffer b;
    Producer(Buffer buff)
    {
        this.b = buff;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                this.b.put();
                Thread.sleep((int)(Math.random() * 1000));
            }
            catch(Exception e) { }
        }
    }
}
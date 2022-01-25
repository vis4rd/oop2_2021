import java.lang.Thread;

class Consumer extends Thread
{
    Buffer b;
    Consumer(Buffer buff)
    {
        this.b = buff;
    }
    
    public void run()
    {
        while(true)
        {
            try
            {
                this.b.get();
                Thread.sleep((int)(Math.random() * 1000));
            }
            catch(Exception e) { }
        }
    }
}
import java.lang.Thread;

class Buffer
{
    public int current;
    public final int max;

    public Buffer(int max)
    {
        this.max = max;
    }

    public synchronized void put()
    {
        Thread t = Thread.currentThread();
        System.out.println("put(): " + t);
        while(this.current == this.max)
        {
            System.out.println("put(): waiting for free space...");
            try { wait(); }
            catch(InterruptedException e) {}
        }
        System.out.println("put(): element added to the buffer: " + this.current + "/" + this.max);
        this.current++;
        notifyAll();
    }

    public synchronized void get()
    {
        Thread t = Thread.currentThread();
        System.out.println("get(): " + t);
        while(this.current == 0)
        {
            System.out.println("get(): waiting for at least one element in the buffer...");
            try { wait(); }
            catch(InterruptedException e) {}
        }
        System.out.println("get(): element removed from the buffer: " + this.current + "/" + this.max);
        this.current --;
        notifyAll();
    }
}
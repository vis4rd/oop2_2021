import java.io.*;
// import java.nio.Files;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Buffer b = new Buffer(3);
        Producer prod = new Producer(b);
        Consumer cons = new Consumer(b);
        Producer prod2 = new Producer(b);
        Consumer cons2 = new Consumer(b);

        prod.start();
        cons.start();
        prod2.start();
        cons2.start();
    }
}

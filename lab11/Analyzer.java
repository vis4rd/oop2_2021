import java.util.Random;

public abstract class Analyzer {

    protected String[] t1;
    protected String[] t2;
    protected String[] t3;

    protected Analyzer(int n, int m) {
        t1 = new String[n];
        t2 = new String[m];
        t3 = new String[m];

        Random random = new Random();

        // generate t1, t2, t3 arrays content
        var dict = "abcdefghijklmnoprstquvwxyzABCDEFGHIJKLMNOPRSTQUVWXYZ";

        // t1
        for(int i = 0; i < t1.length; i++)
        {
            var length = random.nextInt(15) + 5;
            t1[i] = "";
            for (int j = 0; j < length; j++)
            {
                t1[i] += dict.charAt(random.nextInt(dict.length()));
            }
        }

        // t2
        for(int i = 0; i < t2.length; i++)
        {
            t2[i] = t1[random.nextInt(n)];
        }

        // t3
        
        for(int i = 0; i < t3.length; i++)
        {
            t3[i] = "";
            var length = random.nextInt(15) + 5;
            for (int j = 0; j < length; j++)
            {
                t3[i] += dict.charAt(random.nextInt(dict.length()));
            }
        }
        
    }

    protected abstract void fillCollection();

    protected abstract void searchPresentElementsInCollection();

    protected abstract void searchMissingElementsInCollection();

    protected abstract void deleteAllElementsInCollection();

    public final void analyse(String collectionName) {
        long start = System.nanoTime();
        fillCollection();
        System.out.println("Filling " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        searchPresentElementsInCollection();
        System.out.println("Searching present in " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        searchMissingElementsInCollection();
        System.out.println("Searching missing in " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        deleteAllElementsInCollection();
        System.out.println("Deleting all from " + collectionName + ": " + (System.nanoTime() - start) + " ms");
    }
}

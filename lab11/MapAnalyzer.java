import java.util.Map;
import java.util.Collection;

public class MapAnalyzer extends Analyzer {

    // code here...
    private final Map<String, String> list;

    public MapAnalyzer(Map<String, String> mss, int n, int m)
    {
        super(n, m);
        this.list = mss;
    }

    public void fillCollection()
    {
        for(int i = 0; i < super.t1.length; i++)
        {
            this.list.put(super.t1[i], super.t1[i]);
        }
    }

    public void searchPresentElementsInCollection()
    {
        for(var el : this.t2)
        {
            this.list.get(el);
        }
    }

    public void searchMissingElementsInCollection()
    {
        for(var el : this.t3)
        {
            this.list.get(el);
        }
    }

    public void deleteAllElementsInCollection()
    {
        this.list.clear();
    }

    public void analyzeList(String listName)
    {
        fillCollection();

        long start = System.nanoTime();
        indexedForLoop();
        System.out.println("Indexed for loop over " + listName + ": " +
            (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        forEachLoop();
        System.out.println("For each loop over " + listName + ": " +
            (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        iteratorLoop();
        System.out.println("Iterator loop over " + listName + ": " +
            (System.nanoTime() - start) + " ms");
    }
}

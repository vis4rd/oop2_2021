import java.util.List;
import java.util.Collection;

public class ListAnalyzer extends Analyzer {

    // code here...
    private final List<String> list;

    public ListAnalyzer(List<String> ls, int n, int m)
    {
        super(n, m);
        this.list = ls;
    }

    public void fillCollection()
    {
        for(var el : this.t1)
        {
            this.list.add(el);
        }
    }

    public void searchPresentElementsInCollection()
    {
        for(var el : this.t2)
        {
            this.list.indexOf(el);
        }
    }

    public void searchMissingElementsInCollection()
    {
        for(var el : this.t3)
        {
            this.list.indexOf(el);
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

    private void indexedForLoop()
    {
        for(int i = 0; i < this.list.size(); i++)
        {
            this.list.get(i);
        }
    }

    private void forEachLoop()
    {
        for(var el : this.list)
        {
            
        }
    }

    private void iteratorLoop()
    {
        for(var it = this.list.iterator(); it.hasNext(); it.next())
        {
            
        }
    }
}

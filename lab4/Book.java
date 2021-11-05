public class Book extends Item
{
    private String author;
    private String title;

    {
        this.author = new String();
        this.title = new String();
    }

    public Book(int vol, String id, String author, String title)
    {
        super(vol, id);
        this.author = author;
        this.title = title;
    }

    public Book() { this(0, "", "", ""); }

    public Book(Book oth)
    {
        super(oth.volume, oth.itemId);
        this.author = oth.author;
        this.title = oth.title;
    }

    @Override
    public boolean equals(Object o)
    {
        if(!super.equals(o))
            return false;
        if(!o.getClass().equals(getClass()))
            return false;
        
        var p = (Book)o;
        if(!p.author.equals(this.author))
            return false;
        if(!p.title.equals(this.title))
            return false;
        
        return true;
    }

    @Override
    public String toString()
    {
        return "[Book] author="+this.author+", title="+this.title+", "+super.toString();
    }
}
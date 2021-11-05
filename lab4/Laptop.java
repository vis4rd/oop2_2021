public class Laptop extends Item
{
    private String brand;

    {
        this.brand = new String();
    }

    public Laptop(int vol, String id, String brand)
    {
        super(vol, id);
        this.brand = brand;
    }

    public Laptop() { this(0, "", ""); }
    public Laptop(Laptop oth)
    {
        super(oth.volume, oth.itemId);
        this.brand = oth.brand;
    }

    @Override
    public boolean equals(Object o)
    {
        if(!super.equals(o))
            return false;
        if(!o.getClass().equals(getClass()))
            return false;
        
        var p = (Laptop)o;
        if(!p.brand.equals(this.brand))
            return false;
        
        return true;
    }

    public String toString()
    {
        return "[Laptop] brand="+this.brand+", "+super.toString();
    }
}
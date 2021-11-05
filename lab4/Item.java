public abstract class Item
{
    protected int volume;
    protected String itemId;

    {
        this.volume = 0;
        this.itemId = new String();
    }

    public Item(int vol, String id)
    {
        this.volume = vol;
        this.itemId = id;
    }

    public Item() { this(0, ""); }
    public int getVolume() { return this.volume; }
    public String getID() { return this.itemId; }

    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!o.getClass().equals(getClass()))
            return false;
        
        var p = (Item)o;
        if(p.volume != this.volume)
            return false;
        if(!p.itemId.equals(this.itemId))
            return false;
        
        return true;
    }

    @Override
    public String toString()
    {
        return "ID="+this.itemId+", volume="+this.volume;
    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class Box extends Item
{
    private int maxCapacity;
    private int freeCapacity;
    private ArrayList<Item> contents;
    private boolean hasBoxes;

    {
        this.maxCapacity = 0;
        this.freeCapacity = 0;
        this.contents = new ArrayList<>();
        this.hasBoxes = false;
    }

    public Box(int vol, String id, int mcap)
    {
        super(vol, id);
        this.maxCapacity = mcap;
        this.freeCapacity = mcap;
    }

    public Box(Box oth)
    {
        super(oth.volume, oth.itemId);
        this.maxCapacity = oth.maxCapacity;
        this.freeCapacity = oth.freeCapacity;
        this.contents = new ArrayList<>(oth.contents);
    }

    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!o.getClass().equals(this.getClass()))
            return false;
        if(!super.equals(o))
            return false;

        var p = (Box)o;
        return (this.maxCapacity == p.maxCapacity)
            && (this.freeCapacity == p.freeCapacity)
            && (this.hasBoxes == p.hasBoxes)
            && (this.contents.size() == p.contents.size())
            && (Arrays.equals(this.contents.toArray(), p.contents.toArray()));
    }

    public String toString()
    {
        String result = new String();
        result = "[Box] capacity="+this.maxCapacity+", items=[\n";
        for(var i : this.contents)
        {
            result += ("   "+i.toString()+",\n");
        }
        result += "], "+super.toString();
        return result;
    }

    public void addItem(Item new_item)
    {
        if(new_item == null)
        {
            System.out.println("Invalid item.");
            return;
        }

        if(new_item.getClass().equals(getClass()))
        { // dodawane jest pudelko
            if(this == new_item)
            {
                System.out.println("Cannot put a box into itself.");
                return;
            }
            if(((Box)new_item).containsItem(this))
            {
                System.out.println("Cannot put outer box into an inner box (nice try though, witch)");
                return;
            }
        }

        if(this.canBeAdded(new_item))
        {
            int total_vol = 0;
            if(new_item.getClass().equals(getClass()))
            {
                this.hasBoxes = true;
                total_vol = total_vol + ((Box)new_item).getUsedCapacity();
            }
            total_vol = total_vol + new_item.volume;

            this.contents.add(new_item);
            this.freeCapacity = this.freeCapacity - total_vol;
            if(this.freeCapacity < 0)
                this.freeCapacity = 0;
        }
        else
        {
            System.out.println("Cannot add more items to the box.");
        }
    }

    public int getUsedCapacity()
    {
        return this.maxCapacity - this.freeCapacity;
    }

    public void removeItem(Item item)
    {
        if(item == null)
            return;
        if(this.hasBoxes)
        {
            this.contents.forEach( (Item i) ->
            {
                if(i.getClass().equals(getClass()))
                {
                    ((Box)i).removeItem(item);
                }
            });
        }

        if(!this.contents.contains(item))
            return;
        
        var index = this.contents.indexOf(item);
        this.contents.remove(index);
    }

    public boolean containsItem(Item item)
    {
        boolean is = false;
        if(this.hasBoxes)
        {
            for(var i : this.contents)
            {
                if(i.getClass().equals(getClass()))
                {
                    is = ((Box)i).containsItem(item);
                }
            }
        }
        return this.contents.contains(item) || is;
    }

    private boolean canBeAdded(Item new_item)
    {
        return new_item.volume <= this.freeCapacity;
    }
}
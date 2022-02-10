import java.time.ZoneId;
import java.util.Random;

class RandomZoneGenerator
{
    private long seed = 0;
    public RandomZoneGenerator(long seed)
    {
        this.seed = seed;
    }

    public ZoneId generate()
    {
        var set = ZoneId.getAvailableZoneIds();
        var len = set.size();
        var id = new Random(this.seed).nextInt(len);
        String[] dummy = new String[len];
        return ZoneId.of(set.toArray(dummy)[id]);
    }
}
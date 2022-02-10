import java.time.ZonedDateTime;
import java.time.ZoneId;

class TimeZoneConverter
{
    public ZonedDateTime convert(ZonedDateTime date, ZoneId zone)
    {
        return date.withZoneSameInstant(zone);
    }
}
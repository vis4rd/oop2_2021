import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class StringToDateConverter
{
    public ZonedDateTime convert(String target)
    {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return ZonedDateTime.parse(target, formatter);
    }
}
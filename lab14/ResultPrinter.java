import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class ResultPrinter
{
    public void print(ZonedDateTime date1, ZonedDateTime date2)
    {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV");
        var str1 = date1.format(formatter);
        var str2 = date2.format(formatter);
        System.out.printf("%s => %s%n", str1, str2);
    }
}
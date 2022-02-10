import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputValidator validator = new InputValidator();
        List<String> validationResult = validator.validate(args);
        if (validationResult.size() > 0) {
            validationResult.forEach(System.out::println);
            return;
        }

        StringToDateConverter stringToDateConverter = new StringToDateConverter();
        ZonedDateTime toConvert = stringToDateConverter.convert(args[0] + " " + args[1] + " " + args[2]);

        Long seed = Long.parseLong(args[3]);
        RandomZoneGenerator randomZoneGenerator = new RandomZoneGenerator(seed);
        ZoneId toZoneId = randomZoneGenerator.generate();

        TimeZoneConverter timeZoneConverter = new TimeZoneConverter();
        ZonedDateTime converted = timeZoneConverter.convert(toConvert, toZoneId);

        ResultPrinter resultPrinter = new ResultPrinter();
        resultPrinter.print(toConvert, converted);
    }
}

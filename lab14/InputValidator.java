import java.util.ArrayList;
// import java.util.regex;

class InputValidator
{
    public ArrayList<String> validate(String[] args)
    {
        var results = new ArrayList<String>();
        if(args.length != 4)
        {
            results.add("Wrong number of parameters.");
            return results;
        }
        System.out.println(args[0] + " " + args[1]);
        if(!args[0].matches("^(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$"))
        {
            results.add("First argument should be date with format yyyy-MM-dd.");
        }

        if(!args[1].matches("([2][0-3]|[0-1][0-9]|[1-9]):[0-5][0-9]:([0-5][0-9]|[6][0])"))
        {
            results.add("Second argument should be time with format HH:mm:ss");
        }

        if(args[2].length() != 3)
        {
            results.add("Third argument should be exactly 3 letters long");
        }

        try
        {
            long l = Long.valueOf(args[3]);
        }
        catch(Exception e)
        {
            results.add("Fourth argument should be a number");
        }

        return results;
    }
}
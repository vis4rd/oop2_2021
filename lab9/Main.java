import java.lang.Class;
import java.util.Arrays;
import java.lang.reflect.InvocationTargetException;

public class Main
{

    public static String[] splitArgs(String arg)
    {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> !w.isEmpty()).toArray(String[]::new);
    }

    public static void main(String[] args)
    {
        try
        {
            String[] splitted = splitArgs(args[0]);
            var length = splitted.length;

            if(length == 0)
            {
                System.out.println("No arguments to calculate.");
            }
            if(length == 1)
            {
                System.out.println("Wrong number of arguments passed to the function, enter one or two numbers.");
            }
            else if(length == 2)
            {
                var met = Math.class.getMethod(splitted[0], double.class);
                var res = met.invoke(null, Double.parseDouble(splitted[1]));
                System.out.println(res);
            }
            else if(length == 3)
            {
                var met = Math.class.getMethod(splitted[0], double.class, double.class);
                var res = met.invoke(null, Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2]));
                System.out.println(res);
            }
            else if(length > 3)
            {
                System.out.println("Wrong number of arguments passed to the function, enter one or two numbers.");
            }
        }
        catch(NoSuchMethodException e)
        {
            System.out.println("There is no such method.");
        }
        catch(IllegalAccessException e)
        {
            System.out.println("Wrong number of arguments passed to the function, enter one or two numbers.");
        }
        catch(InvocationTargetException e)
        {
            System.out.println("test123");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("No arguments to calculate.");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Function arguments must be numbers.");
        }
    }

}
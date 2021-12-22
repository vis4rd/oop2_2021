import java.lang.ArrayIndexOutOfBoundsException;

public class StackUtils
{
    public static <T> String toString(Stack<T> stack)
    {
        String result = "";
        if(!stack.isEmpty())
        {
            result = "[ ";
            for(int i = stack.getCurrentSize()-1; i >= 0; i--)
            {
                result += stack.getArray()[i]+" ";
            }
            result += "]";
        }
        return result;
    }

    public static <T, U> boolean equals(Stack<T> one, Stack<U> two)
    {
        if(one.getMaxSize() != two.getMaxSize()) { return false; }
        if(one.getCurrentSize() != two.getCurrentSize()) { return false; }
        for(int i = 0; i < one.getCurrentSize(); i++)
        {
            if(one.getArray()[i] != two.getArray()[i]) { return false; }
        }
        return true;
    }

    public static <T> Stack<T> swap(Stack<T> one, int id1, int id2)
    {
        if(id1 >= one.getMaxSize() || id2 >= one.getMaxSize())
        {
            throw new ArrayIndexOutOfBoundsException("Given indexes are greater than stack max size.");
        }
        if(id1 >= one.getCurrentSize() || id2 >= one.getCurrentSize())
        {
            throw new ArrayIndexOutOfBoundsException("Given indexes are greater than current stack size.");
        }
        if(id1 < 0 || id2 < 0 )
        {
            throw new ArrayIndexOutOfBoundsException("Given indexes are below zero.");
        }

        var temp = one.getArray()[id1];
        one.getArray()[id1] = one.getArray()[id2];
        one.getArray()[id2] = temp;
        return one;
    }
}

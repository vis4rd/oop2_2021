import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexOperationsTest
{
    @Test
    public void TestAdd()
    {
        Complex c1 = new Complex(1, 1);
        Complex c2 = new Complex(1, 1);
        assertEquals(ComplexOperations.add(c1, c2), new Complex(2, 2));
    }

    @Test
    public void TestSubtract()
    {
        Complex c1 = new Complex(2, 2);
        Complex c2 = new Complex(1, 1);
        assertEquals(ComplexOperations.subtract(c1, c2), new Complex(1, 1));
    }

    @Test
    public void TestMultiply()
    {
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        assertEquals(ComplexOperations.multiply(c1, c2), new Complex(-9.46, -113.6));
    }

    @Test
    public void TestDivide()
    {
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        assertEquals(ComplexOperations.divide(c1, c2), new Complex(-0.4522310429783739, -1.4932931836846426));
    }
}
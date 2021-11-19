import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest
{
    @Test
    public void TestToString()
    {
        Complex c1 = new Complex(1, 1);
        assertEquals(c1.toString(), "1.0 + 1.0i");
    }

    @Test
    public void TestEqualsHash()
    {
        Complex c1 = new Complex(1, 1);
        Complex c2 = new Complex(1, 1);
        Complex c3 = new Complex(1, 2);
        assertEquals(c1.equals(c2), true);
        assertEquals(c1.equals(c3), false);
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}
import java.math.BigInteger;

public class Main
{
    public static void main(String[] args)
    {
        BigInteger n = m_p.multiply(m_q);
        BigInteger phi_n = m_p.subtract(BigInteger.valueOf(1)).multiply(m_q.subtract(BigInteger.valueOf(1)));
        BigInteger e = BigInteger.valueOf(3);
        while(!e.gcd(phi_n).equals(BigInteger.valueOf(1)))
        {
            e = e.add(BigInteger.valueOf(2));
        }

        BigInteger d = BigInteger.valueOf(1);
        while(!(d.multiply(e)).mod(phi_n).equals(BigInteger.valueOf(1)))
        {
            d = d.add(BigInteger.valueOf(1));
        }
        System.out.println("n="+ n + ", phi=" + phi_n + ", e=" + e + ", d=" + d);

        String text = args[0];
        System.out.println("input: \"" + text + "\"");
        byte[] bytes = text.getBytes();
        BigInteger[] ints = new BigInteger[text.length()];
        System.out.print("ascii = [");
        for(int i = 0; i < text.length(); i++)
        {
            ints[i] = BigInteger.valueOf((int)bytes[i]);
            System.out.print(ints[i] + ", ");
        }
        System.out.println("]");

        // encoding
        BigInteger[] encodes = new BigInteger[text.length()];
        System.out.print("encoded = [");
        for(int i = 0; i < text.length(); i++)
        {
            encodes[i] = ints[i].pow(e.intValue()).mod(n);
            System.out.print(encodes[i] + ", ");
        }
        System.out.println("]");

        // decoding
        int[] decodes = new int[text.length()];
        System.out.print("decoded = [");
        for(int i = 0; i < text.length(); i++)
        {
            decodes[i] = encodes[i].pow(d.intValue()).mod(n).intValue();
            System.out.print(decodes[i] + ", ");
        }
        System.out.println("]");

        // conversion to String
        char[] letters = new char[text.length()];
        for(int i = 0; i < text.length(); i++)
        {
            letters[i] = (char)decodes[i];
        }
        String result = new String(letters);
        System.out.println("result: \"" + result + "\"");
    }

    public static BigInteger m_p = BigInteger.valueOf(397);
    public static BigInteger m_q = BigInteger.valueOf(103);
}
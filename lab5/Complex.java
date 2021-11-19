import java.util.Objects;

public class Complex
{
    private double re;
    private double im;

    {
        this.re = 0.0;
        this.im = 0.0;
    }

    public Complex(double re, double im)
    {
        this.re = re;
        this.im = im;
    }
    public Complex(double re) { this(re, 0.0); }
    public Complex() { this(0.0, 0.0); }

    public double getRe() { return this.re; }
    public double getIm() { return this.im; }
    public void setRe(double re) { this.re = re; }
    public void setIm(double im) { this.im = im; }

    @Override
    public String toString()
    {
        return ""+this.re+" + "+this.im+"i";
    }

    @Override
    public boolean equals(Object o)
    {
        if((o == null)
        || (!o.getClass().equals(this.getClass())))
        {
            return false;
        }

        Complex c = (Complex)o;
        return (this.re == c.re)
            && (this.im == c.im);
    }

    @Override
    public int hashCode()
    {
        return (int)Objects.hash(re, im);
    }
}
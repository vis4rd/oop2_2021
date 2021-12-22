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
    	var result = "";
    	if(Math.abs(this.re) > 1e-7)  // if this.re != 0, but float :)
        {
            result = ""+this.re;
            if(this.im < 0)
            {
                result += " - "+(-this.im)+"i";
            }
            else if(this.im > 0)
            {
                result += " + "+this.im+"i";
            }
        }
    	else
        {
            if(this.im < 0)
            {
                result += ""+(-this.im)+"i";
            }
            else if(this.im > 0)
            {
                result += ""+this.im+"i";
            }
            else
                return "0.0";
        }
    	return result;
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

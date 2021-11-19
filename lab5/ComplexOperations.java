public class ComplexOperations {

    public static Complex add(Complex c1, Complex c2) {
        class Local implements ComplexFunction
        {
            public Complex calculate(Complex c1, Complex c2)
            {
                Complex result = new Complex();
                result.setRe(c1.getRe() + c2.getRe());
                result.setIm(c1.getIm() + c2.getIm());
                return result;
            }
        }
        Local add = new Local();
        return calculate(c1, c2, add);
    }

    public static Complex subtract(Complex c1, Complex c2) {
        ComplexFunction subtract = new ComplexFunction()
        {
            public Complex calculate(Complex c1, Complex c2)
            {
                Complex result = new Complex();
                result.setRe(c1.getRe() - c2.getRe());
                result.setIm(c1.getIm() - c2.getIm());
                return result;
            }
        };
        return calculate(c1, c2, subtract);
    }

    public static Complex multiply(Complex c1, Complex c2) {
        ComplexFunction multiply = (x, y) ->
        {
            double re = ((x.getRe()*y.getRe()) - (x.getIm()*y.getIm()));
            double im = ((x.getRe()*y.getIm()) + (x.getIm()*y.getRe()));
            return new Complex(re, im);
        };
        return calculate(c1, c2, multiply);
    }

    public static Complex divide(Complex c1, Complex c2) {
        class Local implements ComplexFunction
        {
            public Complex calculate(Complex c1, Complex c2)
            {
                Complex result = new Complex();
                double delim = (Math.pow(c2.getRe(), 2)+Math.pow(c2.getIm(), 2));
                result.setRe((c1.getRe()*c2.getRe() + c1.getIm()*c2.getIm())/delim);
                result.setIm((c1.getIm()*c2.getRe() - c1.getRe()*c2.getIm())/delim);
                return result;
            }
        }
        Local divide = new Local();
        return calculate(c1, c2, divide);
    }

    private static Complex calculate(Complex c1, Complex c2, ComplexFunction function) {
        return function.calculate(c1, c2);
    }
}

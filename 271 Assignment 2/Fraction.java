public class Fraction implements FractionInterface{

    private long numerator;
    private long denominator;

    public Fraction(long num, long denom){
        numerator = num;
        denominator = denom;

        if (numerator % denominator == 0){
            numerator = numerator/denominator;
            denominator = denominator/denominator;
        }
        else if (denominator % numerator == 0){
            numerator = numerator / numerator;
            denominator = denominator / numerator;
        }
    }
    public Fraction(long num){
        numerator = num;
        denominator = 1;
    }
    gcd(numerator, denominator){
        if ( a < 0 ){ //then a = -a // to avoid sign problems
        while (b != 0){
            remainder = a % b;
            a = b;
            b = remainder;
        }
        }
        if a == 0
        a = 1
        return a
    }
    @Override
    public long getNumerator(){
        return numerator;
    }
    @Override
    public long getDenominator(){
        return denominator;
    }
    @Override
    public String toString(){
        String output = " ";
        output = Long.toString(numerator) + "/" + Long.toString(denominator);
        return output;
    }
    /* 
    public Fraction add(Fraction inFraction){
        System.out.println("I am working");
        Fraction a = inFraction;
        return Fraction a;
    }
    public Fraction subtract(Fraction inFraction){
    /* your logic here 
    }
    public Fraction multiply(Fraction inFraction){
    /* your logic here 
    }
    public Fraction divide(Fraction inFraction){
    /* your logic here 
    }
    public Fraction pow(int n){
    /* your logic here 
    }
    public Fraction negate(){
    /* your logic here 
    }
    */
}

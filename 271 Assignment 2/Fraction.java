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
    /* 
    public long getNumerator(){
        System.out.println("I am working");
        long i = 10;
        return i;
    }
    public long getDenominator(){
        System.out.println("I am working");
        long i = 10;
        return i;
    }
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
    @Override
    public String toString(){
    /* put your print logic here 
    }
    */
}

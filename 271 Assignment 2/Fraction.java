public class Fraction implements FractionInterface{

    private long numerator;
    private long denominator;

    public Fraction(long num, long denom){
        numerator = num;
        denominator = denom;
        long gcd = gcd(numerator,denominator);
        numerator = numerator / gcd;
        denominator = denominator/gcd;

        if (denominator < 0){ //Flip signs for proper format
            numerator = -numerator;
            denominator = -denominator;
        }
    }


    public Fraction(long num){
        numerator = num;
        denominator = 1;
    }


    public static long gcd(long a, long b){
        if ( a < 0 ){
            a = -a;
        }// to avoid sign problems
        while (b != 0){
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        if (a == 0){
            a = 1;
        }
        return a;
    }


    @Override
    public long getNumerator(){
        return numerator;
    }


    @Override
    public long getDenominator(){
        return denominator;
    }


    public Fraction divide(Fraction inFraction){
        //While not neccessary used this here to actually use the getNumerator and getDenomiator functions
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num * inFraction.getDenominator();
        long newdenum = denum * inFraction.getNumerator();
        return new Fraction(newnum, newdenum);
    }


    public Fraction multiply(Fraction inFraction){
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num * inFraction.numerator;
        long newdenum = denum * inFraction.denominator;
        return new Fraction(newnum, newdenum);
    }


    public Fraction add(Fraction inFraction){
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num * inFraction.denominator + denum * inFraction.numerator;
        long newdenum = denum * inFraction.denominator;
        return new Fraction(newnum, newdenum);
    }


    public Fraction subtract(Fraction inFraction){
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num * inFraction.denominator - denum * inFraction.numerator;
        long newdenum = denum * inFraction.denominator;
        return new Fraction(newnum, newdenum);
    }


    @Override
    public String toString(){
        String output = " ";
        //While not neccessary used this here to actually use the getNumerator and getDenomiator functions
        long num = getNumerator();
        long denum = getDenominator();
        if (denum == 0 && num > 0){
            output = "Infinity";
        }
        else if (denum == 0 && num < 0){
            output = "-Infinity";
        }
        else if (denum == 1){
            output = Long.toString(num);
        }
        else if (num == 0 && denum == 0){
            output = "NaN";
        }
        else{
            output = Long.toString(num) + "/" + Long.toString(denum);
        }
        return output;
    }
    /* 
    public Fraction pow(int n){
    /* your logic here 
    }
    public Fraction negate(){
    /* your logic here 
    }
    */
}

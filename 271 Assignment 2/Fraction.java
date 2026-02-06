public class Fraction implements CSCI271_Assignemnt2_FractionInterface{

    private long numerator;
    private long denominator;
    /* The fraction function takes in a numerator and denominator and asssigns them to numerator and denominator. We then
    call the gcd function and once we get the gcd we dvide both teh numerator and denominator by this. We also check if the
    denominator is negative if so we flip the values of the numerator from postive to negative and denominator from 
    negative to positive to keep with the format -a/b for a fraction.
     */
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

    //Fraction function for if we have only a numerator. Denominator is assumed to be 1 in this case
    public Fraction(long num){
        numerator = num;
        denominator = 1;
    }

    /*gcd takes in the numerator and denominator of the new fraction and finds there greatest common denominator
    it cheks if a is negative is so it negates it. Then it assignes a with the gcd. if a - 0 then a is assigned with 1.
    lastly it returns a.
     */
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


    //Returns the numerator
    public long getNumerator(){
        return numerator;
    }


    //Returns the Denominator
    public long getDenominator(){
        return denominator;
    }

    /*the divide function takes in a fraction to divide the one its called by with. it uses getNumerator
    and getDenominator to assign num and denum. newnum is set equal to the numerator of the first multlied with
    the denominator of the second and newdenum is set euqal to the denominator of both the first multipled
    with the numerator of the second. Lastly we return a new fraction.
     */
    public Fraction divide(Fraction inFraction){
        //While not neccessary used this here to actually use the getNumerator and getDenomiator functions
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num * inFraction.denominator;
        long newdenum = denum * inFraction.numerator;
        return new Fraction(newnum, newdenum);
    }

    /*the multiply function takes in a fraction to multiply the one its called by with. it uses getNumerator
    and getDenominator to assign num and denum. newnum is set equal to the numerators of both multlied togther and
    newdenum is set euqal to the denominators of both fractions multipled together. Lastly we return a new fraction.
     */
    public Fraction multiply(Fraction inFraction){
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num * inFraction.numerator;
        long newdenum = denum * inFraction.denominator;
        return new Fraction(newnum, newdenum);
    }

    /*the addition function takes in a fraction to add to the one its called by with. It uses getNumerator and getDenominator
    to assign num and denum. newnum s assigned with the numerator of the first times the denominator of the second
    added with the denominator of the first times the numerator of the second. newdenum is both denominators multiplied.
    Lastly a new fraction is returned.
     */
    public Fraction add(Fraction inFraction){
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num * inFraction.denominator + denum * inFraction.numerator;
        long newdenum = denum * inFraction.denominator;
        return new Fraction(newnum, newdenum);
    }

    /*The subtract function take in a fraction to subtract the one its called by with. It uses getNumerator and
    getDenominator to assign num and denum with their respective values. newnum is set equal to the num of the
    first fraction times the denominator of the second dubtracted by the denominator ofn the first times the
    numerator of the second. newdenum is the two denominators multiplied together. Lastly we return a new fraction
     */
    public Fraction subtract(Fraction inFraction){
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num * inFraction.denominator - denum * inFraction.numerator;
        long newdenum = denum * inFraction.denominator;
        return new Fraction(newnum, newdenum);
    }

    /*The pow function takes in a int n power. It uses getNumerator and get Denominator to assign the values of num
    and denum. two new variables newnum and newdenum are assigned with thee inital values of num and denum
    afterwards powe is set equal to the absoluteb value of n. We then check if n = 0. if so then newnum and denum are
    both set equal to 1. else we use a for loop to check lop the number of powe time. with newnum being setequal to itself
    times num and the same with denum. After that we look to see if n was negative aka n < 0 if so we flip the values
    of newnum and newdenum. Lastly we return a new fraction with the newnum and newdenum values
    */
    public Fraction pow(int n){
        long num = getNumerator();
        long denum = getDenominator();
        long newnum = num;
        long newdenum = denum;
        int powe = Math.abs(n);
        if (n == 0){
            newnum = 1;
            newdenum = 1;
        }
        else{
            for (int i = 1; i < powe; ++i){
                newnum *= num;
                newdenum *= denum;
            }
        }
        if (n < 0){
            long temp = newnum;
            newnum = newdenum;
            newdenum = temp;
        }
        return new Fraction(newnum, newdenum);
    }

    //The negate function calls getNumerator and getDenominator to assign the variable num and denum
    // num. is then set equal to its negation and then a new fraction is returned
    public Fraction negate(){
        long num = getNumerator();
        long denum = getDenominator();
        num = -num;
        return new Fraction(num, denum);
    }

    /*The toString function uses getNumerator and getDenominator to asign num and denum
    We then check if denum = 0 and num > 0 if so the answer is infinity. Next if denum is still 0 but the numerator
    is negative with say negative infinity. Next if the denominator is 1 we just output the numerator. Next if both
    num and denum are 0 we say its not a number of NaN. If none of those apply we out put the numerator followed by
    a / and then the denominator. Lastly returning the output.
    */
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

}

public class Assignment2 {
    public static void main(String[] args){
        /*
        Tasks 1 and 2 test code for creating and printing fractions. Fractions a and b are created properly. Printing will result in b outpouting just 0 however it
        does create the fraction as 0/1. Chose to do this two together as it made the most sense development wise to have the creation and the output of the fractions be linked
        */
        Fraction a = new Fraction( 6, -24); // creates a fraction of numerator = -1 and denominator = 4
        Fraction b = new Fraction( 0, 8 );// creates a fraction of numerator = 0, denominator = 1 (not 8)
        System.out.println(a);
        System.out.println(b);

        Fraction fr = new Fraction(8, -6); // fr.toString() is "-4/3"
        System.out.println(fr);
        Fraction fr2 = new Fraction(23, 0); // fr.toString() is "Infinity"
        System.out.println(fr2);
        Fraction fr3 = new Fraction(-6, 0); // fr.toString() is "-Infinity"
        System.out.println(fr3);
        Fraction fr4 = new Fraction(7, 1); // fr.toString() is "7" (not "7/1")
        System.out.println(fr4);
        Fraction fr5 = new Fraction(0, 0); // fr.toString() is "NaN"
        System.out.println(fr5); 

        /*
        Code for Task 3 test cases
        */
       Fraction r = new Fraction(3,5).add(new Fraction(7)); //Outputs 38/5
       System.out.println(r);
       Fraction t = new Fraction(76,30).multiply(new Fraction(8, 13)); //Outputs 304/195
       System.out.println(t);
       Fraction d = new Fraction(4,21).divide(new Fraction(3,85)); //Outputs 340/63
       System.out.println(d);
       Fraction s = new Fraction(21, 8).subtract(new Fraction(80,11)); //Outputs -409/88
       System.out.println(s);
       Fraction p = new Fraction(1, 4).pow(3); //Outputs 1/64
       System.out.println(p);
       Fraction pn = new Fraction(1, 4).pow(-3); //Outputs 64
       System.out.println(pn);
       Fraction pz = new Fraction(1, 4).pow(0); //Outputs 1
       System.out.println(pz);
       Fraction ne = new Fraction(1,0).negate();
       System.out.println(ne);
    }
}

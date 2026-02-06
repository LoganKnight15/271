public class Assignment2 {
    public static void main(String[] args){
        /*
        Tasks 1 and 2 test code for creating and printing fractions. Fractions a and b are created properly. 
         Chose to do this two together as it made the most sense development wise to have the 
         creation and the output of the fractions be linked. These cases are taken directly from the instruction page
         fr1 -fr5 are testing the toString() fucntion and there cases are shown.
        */
        Fraction a1 = new Fraction( 6, -24); // creates a fraction of numerator = -1 and denominator = 4
        Fraction b1 = new Fraction( 0, 8 );// creates a fraction of numerator = 0, denominator = 1 (not 8)
        System.out.println(a1);
        System.out.println(b1);

        Fraction fr1 = new Fraction(8, -6); // fr.toString() is "-4/3"
        System.out.println(fr1);
        Fraction fr2 = new Fraction(23, 0); // fr.toString() is "Infinity"
        System.out.println(fr2);
        Fraction fr3 = new Fraction(-6, 0); // fr.toString() is "-Infinity"
        System.out.println(fr3);
        Fraction fr4 = new Fraction(7, 1); // fr.toString() is "7" (not "7/1")
        System.out.println(fr4);
        Fraction fr5 = new Fraction(0, 0); // fr.toString() is "NaN"
        System.out.println(fr5); 

        /*
        Code for Task 3 test cases are listed below

        1st we start with three cases for addition. The first is just adding two positive numbers. 3/5 and 7.
        The second addition case is tetsing adding a negative and postive fraction. The last acse is adding two negative
        fractions together. The same can be seen for the subtraction, multiplication, and division cases. I have added
        the outputs and inital fractions above each test case for easer reading. These cases were mathmatically tested
        using a calculator to check for proper addition, subtraction, multiplication, and division.

        Following the add, sub, multi, and divide section comes power and negate. Power has 3 test cases listed showing
        a positive power, negative power, and a zero power.

        Negate has 4 test cases showing Infinity switches, normal fraction cases, and NaN
        */
        //The addition of the fractions 3/5 and 7/1 which outputs 38/5
       Fraction addp = new Fraction(3,5).add(new Fraction(7));
       System.out.println(addp);
        //The addition of the fractions 7/14 and -20/50 which outputs 1/10
       Fraction addn = new Fraction(7,14).add(new Fraction(-20,50));
       System.out.println(addn);
        //The addition of the fractions -7/46 and -2/5 which outputs -127/230
       Fraction addn2 = new Fraction(-7,46).add(new Fraction(-2,5));
       System.out.println(addn2);
        //The multiplication of the fractions 76/30 and 8/13 which outputs 304/195
       Fraction mp = new Fraction(76,30).multiply(new Fraction(8, 13));
       System.out.println(mp);
        //The multiplication of the fractions 7/3 and -80/100 which outputs -28/15
       Fraction mn = new Fraction(7,3).multiply(new Fraction(-80, 100));
       System.out.println(mn);
        //The multiplication of the fractions -40/3 and -5/20 which outputs 10/3
       Fraction mn2 = new Fraction(-40,3).multiply(new Fraction(-5, 20));
       System.out.println(mn2);
        //The division of the fractions 4/21 and 3/85 which outputs 340/63
       Fraction dp = new Fraction(4,21).divide(new Fraction(3,85));
       System.out.println(dp);
        //The division of the fractions 100/74 and -9/85 which outputs -4250/33
       Fraction dn = new Fraction(100,74).divide(new Fraction(9,-85));
       System.out.println(dn);
        //The division of the fractions -4/210 and -33/8 which outputs 16/3465
       Fraction dn2 = new Fraction(-4,210).divide(new Fraction(-33,8));
       System.out.println(dn2);
        //The subtraction of the fractions 21/8 and 80/11 which outputs -409/88
       Fraction sp = new Fraction(21, 8).subtract(new Fraction(80,11));
       System.out.println(sp);
        //The subtraction of the fractions 2/83 and -5/11 which outputs 437/913
       Fraction sn = new Fraction(2, 83).subtract(new Fraction(-5,11));
       System.out.println(sn);
        //The subtraction of the fractions -7/5000 and -3/2 which outputs 7493/5000
       Fraction sn2 = new Fraction(-7, 5000).subtract(new Fraction(-3,2));
       System.out.println(sn2);
        //The fraction 1/4 raised to the pwoer of 3 which is 1/64
       Fraction p = new Fraction(1, 4).pow(3);
       System.out.println(p);
       //The fraction 1/4 raised to the power of -3 which is 64
       Fraction pn = new Fraction(1, 4).pow(-3);
       System.out.println(pn);
       //The fraction 1/4 raised to the pwoer of 0 which is 1
       Fraction pz = new Fraction(1, 4).pow(0); //Outputs 1
       System.out.println(pz);
        //The negation of the fraction 0/0 which is normally NaN showing NaN negated.
       Fraction ne = new Fraction(0,0).negate();
       System.out.println(ne);
        //The negation of the fraction 1/0 which is normnally Infinity showing -Infinity negated.
       Fraction nei = new Fraction(1,0).negate();
       System.out.println(nei);
        //The negation of the fraction -2/0 which is normally -infinity showing Infinity negated.
       Fraction neni = new Fraction(-2,0).negate();
       System.out.println(neni);
        //The negation of the fraction 7/50 which is -7/50 negated;
       Fraction nep = new Fraction(7,50).negate();
       System.out.println(nep);
        //The negation of the fraction -55/30 which is reduced to 11/6 when negated.
       Fraction nen = new Fraction(-55,30).negate();
       System.out.println(nen);

       /*
       The below code is the big test case you showed in the instruction page being tested with
       my own verison following it.
        */
        Fraction a2 = new Fraction(16); // 16/1
        Fraction b2 = new Fraction(3,5).add(new Fraction(7)); // 3/5 + 7/1 = 38/5
        Fraction c2 = new Fraction(6,7); // 6/7
        Fraction results = c2.multiply(a2.divide(b2)); //Outputs 240/133
        System.out.println(results);
        //My own version
        Fraction a3 = new Fraction(10, 26); // 10/26
        Fraction b3 = new Fraction(9,-60).subtract(new Fraction(7, 39)); // -9/60 - 7/39
        Fraction c3 = new Fraction(2,7); // 2/7
        Fraction result = c3.divide(a3.multiply(b3)); // Outputs -4056/1799
        System.out.println(result);
    }
}

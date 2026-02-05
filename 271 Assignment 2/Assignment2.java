public class Assignment2 {
    public static void main(String[] args){
        Fraction a = new Fraction( 6); // creates a fraction of numerator = -1 and denominator = 4
        Fraction b = new Fraction( 0, 8 );// creates a fraction of numerator = 0, denominator = 1 (not 8)
        System.out.println(a);
        Fraction fr = new Fraction(8, -6); // fr.toString() is "-4/3"
        System.out.print(fr);
    }
}

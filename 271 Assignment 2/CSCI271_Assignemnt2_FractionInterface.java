/*************************************************************************
* Project 2 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: MacOs
* Compiler: javac 21.0.9
* Date: Feburary 6, 2026
*
* Purpose
* This program creates, multiples, adds, subtracts, divides, rasies to powers, and negates Fractions.
* It will also convert them to strings for output purposes.
*
*************************************************************************/
public interface CSCI271_Assignemnt2_FractionInterface{
    long getNumerator();
    long getDenominator();
    Fraction divide(Fraction f);
    Fraction multiply(Fraction f);
    Fraction add(Fraction f);
    Fraction subtract(Fraction f);
    Fraction negate();
    Fraction pow(int n);
}

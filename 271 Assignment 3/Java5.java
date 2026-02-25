/*************************************************************************
* Project 3 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: macOS Tahoe Version 26.3 and Windows 11 version 25H2
* Compiler: javac 21.0.9
* Date: Feb 25, 2026
*
* Purpose
* This program reads in a user generated string and recursively returns
* the the string in reverse.
*
*************************************************************************/
/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Logan Robinson
********************************************************************/



import java.util.Scanner;

public class Java5{

    /*****************************<stringReverse>****************************
    * Description: stringReverse takes in a user generated string userString. It will then check if the string is empty. If so it returns that empty string
    * Otehrwise it will take that string and recursively reverse the string and return that reversed string.
    *
    * Parameters: String userString which stands in for String S in main
    *
    * Pre: Before the function is called there must be a String S in main that must either be
    * empty of contain user entered data. That string must be passed in to stringReversewhere 
    * String userString stands in for it.
    *
    * Post: Once stringReverse is done there will be a string reverse returned to the user.
    * Either "" in the base case or the reversed string of what the user entered.
    *
    * Returns: A string that is the reverse of the user entered string
    *
    * Called by: main()
    * Calls: stringReverse()
    ************************************************************************/

    public static String stringReverse(String userString){
        String reverse;
        if (userString.equals("")){
            reverse =  "";
        }
        else{
            reverse = stringReverse(userString.substring(1)) +  userString.charAt(0);
        }
        return reverse;
    }

    public static void main(String[] args) {
        String S;
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Please enter the string you want reversed: ");
        S = userInput.nextLine();
        String reversed = stringReverse(S);
        System.out.println("The reverse of the string you entered is: " + reversed);
        userInput.close();
    }
}
/*************************************************************************
* Project 3 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: macOS Tahoe Version 26.3
* Compiler: javac 21.0.9
* Date: Feb 25, 2026
*
* Purpose
* This program reads in a user generated string and recursively returns
* the length of that string.
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

public class 271Assignment3_Problem1_LoganRobinson{

    /*****************************<lengthOfString>****************************
    * Description: lengthOfString will take in a user generated string and check
    * if it meets the base case of an empty string or it does not it will find the length
    * of the string through recursion.
    *
    * Parameters: String userString which stands in for String S in main
    *
    * Pre: Before the function is called there must be a String S in main that must either be
    * empty of contain user entered data. That string must be passed in to lengthOfString where 
    * String userString stands in for it.
    *
    * Post: Once lengthOfString is done there will be an integer value returned to the user.
    * Either 0 in the base case or whatever the length is calculated recursively.
    *
    * Returns: An integer value that is the length of the string
    *
    * Called by: main()
    * Calls: lengthOfString()
    ************************************************************************/

    public static int lengthOfString(String userString){
        if (userString.equals("")){
            return 0;
        }
        else{
            int length = 1;
            length += lengthOfString(userString.substring(1));
            return length;
        }
    }

    public static void main(String[] args) {
        String S;
        Scanner userInput = new Scanner(System.in);

        S = userInput.nextLine();
        int stringLength = lengthOfString(S);
        System.out.println("The length of the string you entered is: " + stringLength);
        userInput.close();
    }
}
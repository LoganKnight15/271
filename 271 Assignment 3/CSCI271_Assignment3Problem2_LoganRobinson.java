/*************************************************************************
* Project 3 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: macOS Tahoe Version 26.3
* Compiler: javac 25.0.1
* Date: Feb 25, 2026
*
* Purpose
* This program reads in a number for the length of an array. It then takes a list of integers from the use to populate that array.
* It will then call a function called max that uses recursion to find the maximum value in that list of integers.
* This value is then returned and printed to the user.
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

public class CSCI271_Assignment3Problem2_LoganRobinson{
    /*****************************<countOfChar>****************************
    * Description: countOfChar takes in a user defined string and a char they want to search for. It first checks if the string is empty
    * if so it returns taht count is equal to 0. If not it will then check by using recursion how many times the user entered char occurs in the string.
    * It lastly returns this interger count to main where it is output to the user.
    *
    * Parameters: String userString and char userChar. These correspond to S and c in main respectively
    *
    * Pre: Before the function is called there must be a String S in main that is either empty or contains user entered data, and a char c that must contain a user entered char.
    * Those are then passed to the countOfChar function call.
    *
    * Post: Once countOfChar is finished it must return an integer value count. This will either be 0 in the base case or be found recursively.
    *
    * Returns: An integer value that is the count of how many times the user defined char occurs in the string userString
    *
    * Called by: main()
    * Calls: countOfChar()
    ************************************************************************/
    public static int countOfChar(String userString, char userChar){
        int count = 0;
        if (userString.equals("")){
            count  = 0;
        }
        //Found .charAt in java documenatation when looking through strings and chars
        //Link to information I found https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html#charAt(int)
        else if(userString.charAt(0) == userChar){
            count = 1 + countOfChar(userString.substring(1), userChar);
        }
        else{
            count = countOfChar(userString.substring(1), userChar);
        }
        return count;
    }

    public static void main(String[] args) {
        String S;
        char c;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter a string and on the next line a character");
        S = userInput.nextLine();
        c = userInput.next().charAt(0);
        int charCount = countOfChar(S, c);

        System.out.println("the char you've entered: " + c + " occurs " + charCount + " times in the string you entered");
        userInput.close();

    }
}
// Time Complexity is O(n)
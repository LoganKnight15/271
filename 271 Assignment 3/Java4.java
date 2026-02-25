/*************************************************************************
* Project 3 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: macOS Tahoe Version 26.3 and Windows 11 version 25H2
* Compiler: javac 25.0.1
* Date: Feb 25, 2026
*
* Purpose
* This program reads in a long int N from the user and a normal int D from the user. D is the int they wish to know how many times occurs in the long int.
* It thens calls a function countOfD that will check for its bases cases of if N and D are both zero or if only N is zero. In those cases it will return 1 or 0
* respectively. IF neither hold it will recursively check the last integer to count the number of time D occurs in N.
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

public class Java4{
    /*****************************<countOfD>****************************
    * Description: countOfD takes in a user defined long int and an int they want to search for. It first checks if the long int is either 0 and the int they entered is 0
    * or if only the long int is 0. If so it will return 1 if both the long int and int are 0 and it will return a 0 if only the long int is 0.
    * If not it will then check by using recursion how many times the user entered int occurs in the long int.
    * It lastly returns this interger count to main where it is output to the user.
    *
    * Parameters: long userN and int userD. These correspond to N and D in main respectively
    *
    * Pre: Before the function is called there must be a long N in main that is either 0 or contains user entered data, and an int D that must contain a user entered int.
    * Those are then passed to the countOfD function call.
    *
    * Post: Once countOfD is finished it must return an integer value count. This will either be 0 or 1 in the base cases or be found recursively.
    *
    * Returns: An integer value that is the count of how many times the user defined int occurs in the long userN
    *
    * Called by: main()
    * Calls: countOfD()
    ************************************************************************/
    public static int countOfD(long userN, int userD){
        int count = 0;
        if (userN == 0 && userD == 0){
            return 1;
        }
        else if(userN == 0){
            return 0;
        }

        if(userN % 10 == userD){ //Checking the last digit of the number first
            count = 1;
        }
        return count + countOfD(userN / 10, userD);
    }

    public static void main(String[] args) {
        long N;
        int D;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter a very long integer followed by the int you want found:");
        N = userInput.nextLong();
        D = userInput.nextInt();
        int DCount = countOfD(N, D);

        System.out.println("the int you've entered: " + D + " occurs " + DCount + " times in the long int you entered");
        userInput.close();

    }
}
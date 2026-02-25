/*************************************************************************
* Project 3 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: macOS Tahoe Version 26.3 and Windows 11 version 25H2
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

public class Java3{
    /*****************************<max>****************************
    * Description: max takes in an integer array and an int that corresponds to the length of that array.
    * We then check if the array only has one value in it or not. If so we return that value as our max.
    * If that is not the case we recursively check to find the maximum value of integers in the array provided
    * to use by the user. Once we have the max we return it back to main
    *
    * Parameters: int array[] and int length. These two correspond to int arr[] and int userLength in main respectively
    *
    * Pre: Before the function is called there must be an array of ints arr and a user defined length for that array userLength.
    * Both the length and the array must be passed into the max function call.
    *
    * Post: Once max is done it must return an integer value containing the max value from the array provided to it. This is either the 1st and only
    * element in the array or that value is found recursively.
    *
    * Returns: An integer value that is the max value from a user defined array of integers
    *
    * Called by: main()
    * Calls: max(int array[], int length)
    ************************************************************************/
    public static int max(int array[], int length){
        int maxInt;
        if(length <= 1){ //This is the base cae. If there is only one element.
            return array[0];
        }
        //This is the recursive case.
        int arrayRecur = max(array, length - 1);

        //This is comparing the numbers on the way back up of the recursion.
        if(array[length - 1] > arrayRecur){
            maxInt = array[length - 1];
        }
        else{
            maxInt = arrayRecur;
        }
        return maxInt;
    }

    public static void main(String[] args) {
        int userLength;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please state how any integers you are going to enter");
        userLength = userInput.nextInt();

        int A[] = new int[userLength];

        System.out.println("Please enter a list of integers");
        for(int i = 0; i < userLength; ++i){
            A[i] = userInput.nextInt();
        }
        int maximum = max(A, userLength);
        System.out.println("Max value of the list you provided is: " + maximum);

        userInput.close();
        
    }
}
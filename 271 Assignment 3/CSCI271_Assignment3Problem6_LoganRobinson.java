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
* It will then call a function called sumEven that will take in an index value of 0 which is the start of the array and will then
* begin to check if its first at the end of the array if not it will check if the number at index 0 is even. If it is even it will add it to
* sumOfEvens. If not it will check the next index value recursively until it reaches the end of the array. It will lastly return the sumOfEvens value
* whcih is the sum of all even ints in the array
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

public class CSCI271_Assignment3Problem6_LoganRobinson{
    /*****************************<sumEven>****************************
    * Description: sumEven takes in an integer array and an int that corresponds to the first index position in the array.
    * We then check if that index position is at the end of the array. If so we return a 0. If not we then check if that number is positive if so
    * we add it to sumOfEvens if not we check the next number recursively. Once we reach the end we return the total value of the sum of the even numbers
    *
    * Parameters: int array[] and int n. These two correspond to int A[] and the 0 in the fucntion call in main respectively
    *
    * Pre: Before the function is called there must be an array of ints A and an index specification.
    * Both the index and the array must be passed into the max function call.
    *
    * Post: Once sumEven is done it must return an integer value containing the sum value of all the even ints from the array provided to it. This is either 0 or 
    * it is found in the array recursively.
    *
    * Returns: An integer value that is the sum of all even integers in the array
    *
    * Called by: main()
    * Calls: sumEven()
    ************************************************************************/
    public static int sumEven(int array[], int n){
        int sumOfEvens;
        if(n == array.length){ //This is the base cae. Checking if we have reached the end of the array
            return 0;
        }

        //This is the recursive case it will check if the int at position n is postive or not. If so add it to the sum
        if(array[n] % 2 == 0){
            sumOfEvens = array[n] + sumEven(array, n + 1);
        }
        else{
            sumOfEvens = sumEven(array, n + 1);
        }
        return sumOfEvens;
    }

    public static void main(String[] args) {
        int userLength;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please state how any integers you are going to enter");
        userLength = userInput.nextInt();

        int arr[] = new int[userLength];

        System.out.println("Please enter a list of integers");
        for(int i = 0; i < userLength; ++i){
            arr[i] = userInput.nextInt();
        }
        int sum = sumEven(arr, 0);
        System.out.println("The sum of the even numbers in the array you provided is: " + sum);

        userInput.close();
        
    }
}
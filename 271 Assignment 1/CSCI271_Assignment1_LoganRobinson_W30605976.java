/*************************************************************************
* Project 1 for CSCI 271-001 Spring 2026
*
* Author: Logan Robinson
* OS: macOS 15.7.3
* Compiler: javac 21.0.9
* Date: January, 22, 2026
*
* Purpose
* This program reads a list of scores from an input file, counts how many
* scores there are in the list, and computes their sum and average.
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
* W30605976
********************************************************************/
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CSCI271_Assignment1_LoganRobinson_W30605976 {
    public static void main(String[] args) throws IOException{ // Added throws IOException after having looked through the Java Documentation guide mentioned in class. 
                                                                // A few things in this assignment were learned from that guide and from Friday TA examples. This exception was added to allow for the scanner new file system to work.
        
        String line; // string we will use later to store the full line from the file
        String StudentName = ""; //will contain the StudentName element
        int[] Assignments = new int[7]; //will contain all 7 asisgnment scores
        int[] Tests = new int[7]; // will contain all 7 test scores
        int midterm = 0; // will contain the midterm score
        int finalexam = 0; // will contain the final exam score


        Scanner fileinput = new Scanner(new File(args[0])); // creates and opens a new scanner called fileinput and also intitalizes a new File. Learned this from readin the Java documenation guide. Uses the argument provided when running for the file name.
        fileinput.useDelimiter("\n"); // Used to seperated the file by new lines. Works with the scanner 
        if (fileinput.hasNextLine()){ //checking if the file has a next line
            fileinput.nextLine();  //Skips header line that in out data file contains StudentName, a1, a2, etc.
        }
        while(fileinput.hasNextLine()){ // While the file has a next line keep iterating through it.
            line = fileinput.nextLine(); // sets the string line to the entire next line of the csv file

            String[] Line = line.split(","); // places that line in a string array that is seperated by the commas in our file. 

            for (int i = 0; i < 17; ++i){ // loops through the entire line. Hard codded as we are asked for Student Name, 7 assignments, 7 tests, 1 midterm, and 1 final exam.
                switch(i){ // switch statement to allow for diffrent cases without the clunky multiple if else statements.
                    case 0: //if i=0 Assign StudentName with what is stored in Line[i]
                        StudentName = Line[i] + " ";
                        break;
                    case 1,2,3,4,5,6,7://If i=1,2,3,4,5,6, or 7 assign the value of Line[i] to the appropriate spot in the Assignments array.
                        Assignments[i-1] = Integer.parseInt(Line[i]);
                        break;
                    case 8,9,10,11,12,13,14:// If i=8,9,10,11,12,13, or 14 the assign the value of Line[i] ton the appropriate spot in the Tests array.
                        Tests[i - 8] = Integer.parseInt(Line[i]);
                        break;
                    case 15:// If i=15 assign the value of Line[i] to midterm 
                        midterm = Integer.parseInt(Line[i]);
                        break;
                    case 16: // If i=16 assign the value of Line[i] to finalexam
                        finalexam = Integer.parseInt(Line[i]);
                        break;
                }
            }

            int A = 0; // Average score of assignments
            int T = 0; // Average score of tests
            double E = 0; //E value taken straight from the Syllabus
            double W = 0; // W value taken straight from the Syllabus
            int G = 0; // G valkue taken from the Syllabus stands for final grade

            for(int Assignment : Assignments){ // Loop through every element in the Assignments array and assign the added values to A
                A += Assignment;
            }
            A = A/Assignments.length; // Divide A by the length of the Assignments array fully computing the average. Note choosing to allow this to round down.

            for(int Test : Tests){ // Loop through every element in the Tests array and assign the added values to T
                T += Test;
            }
            T = T/Tests.length; // Divide T by the length of the Tests array fully computing the average. Note choosing to allow this to round down.

            E = ((0.4 * finalexam + 0.2 * midterm + 0.1 * T)/70) * 100; //Calculation for actual E value
            
            W = ((E - 60)/20)*0.3; //Calculation for actual W value

            //This is calculating if E is less than 60, if 60 <= E < 80 and if E >=80
            if (E < 60){
                G = (int)E; // Set G equal to E converted to an int
                System.out.println(StudentName + "Final Grade " + G); // Output the StudentName and Final Grade
            }
            else if (E >=60 && E < 80){
                G = (int)(((1+W)*E) + (W*A)); // Does the calculation and sets G equal to that value converted to an int
                System.out.println(StudentName + "Final Grade " + G);// Output the StudentName and Final Grade
            }
            else{
                G = (int)((0.4*finalexam)+(0.2*midterm)+(0.1*T)+(0.3*A)); // Does the calculation and sets G equal to that value converted to an int
                System.out.println(StudentName + "Final Grade " + G);// Output the StudentName and Final Grade
            }

        }
        fileinput.close(); // close the fileinput scanner
    }
}

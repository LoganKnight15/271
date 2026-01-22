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

import java.util.Scanner;

public class CSCI271_Assignment1_LoganRobinson_W30605976 {
    public static void main(String[] filear){
        String StudentName;
        double[] Assignments = new double[7];
        double[] Test = new double[7];
        double midterm = 0;
        double finalexam = 0;
        Scanner fileinput = new Scanner(filear[0]);
        fileinput.nextLine();  //Skips header line
        for (int i = 0; i < 18; ++i){
           switch(i){
            case 1: StudentName = fileinput.nextLine();
            break;
            case 2, 3, 4, 5, 6, 7 , 8: 
                Assignments[i] = fileinput.nextInt();
            break;
            case 9, 10, 11, 12, 13, 14, 15:
                Test[i] = fileinput.nextInt();
            break;
            case 16: midterm = fileinput.nextInt();
            break;
            case 17: finalexam = fileinput.nextInt();
           }
        }
        System.out.println(midterm);
        fileinput.close();
    }
    //if (E < 60){
        //System.out.print(E);
    //}
    //else if (E >=60 || E<80){

    //}
    //else{

    //}

}

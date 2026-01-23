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
    public static void main(String[] args) throws IOException{
        String line;
        String StudentName;
        int[] Assignments = new int[7];
        int[] Test = new int[7];
        int midterm;
        int finalexam;
        Scanner fileinput = new Scanner(new File(args[0]));
        fileinput.useDelimiter("\n");
        if (fileinput.hasNextLine()){
            fileinput.nextLine();  //Skips header line
        }
        line = fileinput.nextLine();
        System.out.println(line);

        String[] Line = line.split(",");

        for (int i = 0; i < 17; ++i){
           switch(i){
            case 0: 
                StudentName = Line[i];
                System.out.println(StudentName);
            break;
            case 1,2,3,4,5,6,7:
                Assignments[i-1] = Integer.parseInt(Line[i]);
                System.out.print(Assignments[i-1] + " ");
            break;
            case 8,9,10,11,12,13,14:
                Test[i - 8] = Integer.parseInt(Line[i]);
                System.out.print(Test[i-8] + " ");
            break;

            case 15:
                midterm = Integer.parseInt(Line[i]);
                System.out.print(midterm + " ");
            break;
            case 16: 
                finalexam = Integer.parseInt(Line[i]);
                System.out.print(finalexam + " ");
            break;
           }
        }
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

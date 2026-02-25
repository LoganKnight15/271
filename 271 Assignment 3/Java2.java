import java.util.Scanner;

public class Java2{
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
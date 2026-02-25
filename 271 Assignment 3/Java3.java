import java.util.Scanner;

public class Java3{

    public static int max(int array[], int length){
        int maxInt = 0;
        if(length  == 1){
            maxInt = array[0];
        }
        
        return maxInt;
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
        int maximum = max(arr, userLength);
        System.out.println("Max value of the list you provided is: " + maximum);

        userInput.close();
        
    }
}
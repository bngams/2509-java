import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainExceptions {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number : ");
        String userInput = scan.nextLine();

        //  NumberFormatException => bad input string => Unchecked
        Integer number = Integer.parseInt(userInput);

        try {
            // / by zero => Unchecked
            Integer result = 10 / number;
            System.out.println(result);
        } catch (ArithmeticException e)  {
            System.out.println("Error");
        }


    }
}

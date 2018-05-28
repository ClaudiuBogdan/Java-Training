import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that read a sequence of numbers and writes the result into a file.
 */
public class AverageNumber {
    /**
     * Main entry of the application.
     */
    public static void main(String[] args){
        AverageNumber averageNumber = new AverageNumber();
        double average = averageNumber.calculateAverage();
        System.out.println(average);
        //**try-with resources statement** ensures that a resource is closed when the statement ends normally or due
        //to an exception.
        try(PrintWriter printWriter = new PrintWriter("averageResult.txt","UTF-8")) {
            printWriter.println(average);
        }
        catch (FileNotFoundException fileEx){
            fileEx.printStackTrace();
        }
        catch (UnsupportedEncodingException encodingEx){
            encodingEx.printStackTrace();
        }
    }
    /**
     * Method that get input from user and calculate the average.
     */
    private double calculateAverage(){
        double sum = 0;
        int inputNumber = 0;
        int countInputs = 0;
        Scanner reader = new Scanner(System.in);
        while(inputNumber >= 0){
            sum += inputNumber;
            System.out.println("Enter a positive number: ");
            try {
                inputNumber = reader.nextInt();
                countInputs++;
            }
            catch (InputMismatchException ex){
                System.out.println("You have inserted a wrong input! Try again. ");
                reader.nextLine();
            }

        }
        reader.close();
        countInputs--;
        return sum/countInputs;
    }
}

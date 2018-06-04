import java.util.Scanner;

public class SolutionDay16 {
    private static String errorMessage;
    private static String message;
    static
    {
        errorMessage = "Bad String";
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String S = in.next();
        try{
            Integer numInt = Integer.parseInt(S);
            message = numInt.toString();
        }
        catch(NumberFormatException ex){
            message = errorMessage;
        }
        System.out.println(message);
    }
}
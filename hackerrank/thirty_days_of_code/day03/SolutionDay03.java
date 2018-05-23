import java.util.*;

public class SolutionDay03 {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        String weird = "Weird";
        String notWeird = "Not Weird";
        String solutionMessage = weird;
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if(N % 2 == 0 && (N < 5 || N > 20)){
            solutionMessage = notWeird;
        }
        System.out.println(solutionMessage);
        scanner.close();
    }
}
import java.util.Scanner;

public class SolutionDay05 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int numberOfMultiples = 10;
        for(int multiplayer = 1; multiplayer <= 10; multiplayer++){
            int multiple = n * multiplayer;
            System.out.printf("%d x %d = %d\n",n,multiplayer,multiple);
        }
        scanner.close();
        }
}

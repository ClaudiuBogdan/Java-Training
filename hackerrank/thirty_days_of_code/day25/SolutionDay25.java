import java.util.Scanner;

public class SolutionDay25 {

    private static void checkPrime(int n){
        boolean isPrime = true;
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n % i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime && n > 1){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not prime");
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int i=0; i< testCases; i++){
            int n = scan.nextInt();
            checkPrime(n);
        }
    }
}
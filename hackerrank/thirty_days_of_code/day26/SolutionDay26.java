import java.util.Scanner;

public class SolutionDay26 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int actualDay = scan.nextInt();
        int actualMonth = scan.nextInt();
        int actualYear = scan.nextInt();

        int expectedDay = scan.nextInt();
        int expectedMonth = scan.nextInt();
        int expectedYear = scan.nextInt();
        int fine = 0;
        if(actualYear <= expectedYear){
            if(actualMonth <= expectedMonth){
                if(actualDay > expectedDay && actualMonth == expectedMonth){
                    fine = 15 * (actualDay - expectedDay);
                }
            }
            else if(actualYear == expectedYear){
                fine = 500 * (actualMonth - expectedMonth);
            }
        }
        else{
            fine = 10000;
        }
        System.out.println(fine);
    }
}

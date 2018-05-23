import java.util.Scanner;

public class SolutionDay06 {
    public static class Solution {

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scanner = new Scanner(System.in);
            int numberOfLines = scanner.nextInt();
            scanner.nextLine();
            while(scanner.hasNext()){
                String initialString = scanner.nextLine();
                String evenString = "";
                String oddString = "";
                for(int indexOfChar = 0; indexOfChar < initialString.length(); indexOfChar++){
                    if(indexOfChar % 2 == 0){
                        evenString += initialString.charAt(indexOfChar);
                    }
                    else{
                        oddString += initialString.charAt(indexOfChar);
                    }
                }
                System.out.println(evenString + " " + oddString);
            }
            scanner.close();
        }
    }
}

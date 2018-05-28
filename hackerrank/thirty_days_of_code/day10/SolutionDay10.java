import java.util.Scanner;

public class SolutionDay10 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(binaryNumberVersion2(n));
        scanner.close();
    }

    //Solution with bugs.
    public static int binaryNumberVersion1(int n){
        String binaryNumberString = "";
        String bitString = "";
        if(n == 0){
            binaryNumberString = "0";
        }
        while(n > 0){
            bitString = n % 2 == 0 ? "0" : "1";
            binaryNumberString = bitString + binaryNumberString;
            n = n / 2;
        }
        int maxConsecutiveOnes = 0;
        int temporalConsecutiveOnes = 0;
        for(int i=0; i < binaryNumberString.length(); i++){
            int currentBit = Integer.parseInt("" + binaryNumberString.charAt(i));
            int previousBit = i > 0 ? Integer.parseInt("" + binaryNumberString.charAt(i - 1)) : currentBit;
            if(currentBit == 1 && previousBit == 1){
                temporalConsecutiveOnes++;
            }
            else{
                temporalConsecutiveOnes = 0;
            }
            if( temporalConsecutiveOnes > maxConsecutiveOnes){
                maxConsecutiveOnes = temporalConsecutiveOnes;
            }
        }
        return maxConsecutiveOnes;
    }

    //Correct solution.
    public static int binaryNumberVersion2(int n){
        int bit;
        int maxConsecutiveOnes = 0;
        int temporalConsecutiveOnes = 0;
        while(n > 0){
            bit = n % 2 == 0 ? 0 : 1;
            n = n / 2;
            temporalConsecutiveOnes += bit;
            temporalConsecutiveOnes *= bit;
            if(temporalConsecutiveOnes > maxConsecutiveOnes){
                maxConsecutiveOnes = temporalConsecutiveOnes;
            }
        }
        return maxConsecutiveOnes;
    }

}

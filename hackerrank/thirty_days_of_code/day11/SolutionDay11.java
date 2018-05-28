import java.util.Scanner;

public class SolutionDay11 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        System.out.println(solution(arr));

        scanner.close();
    }

    public static int solution(int[][] arr){
        int hourglassWidth = 3;
        int hourglassHigh = 3;
        int maxSumOfHourglassValues = -9 * 7;
        for(int i=0; i<=arr.length-hourglassHigh; i++){
            for(int j=0; j<=arr[0].length - hourglassWidth; j++){
                int parcialSum=0;
                //Sum the superior and inferior line
                for(int k=j; k<j+hourglassWidth; k++){
                    parcialSum += arr[i][k] + arr[i + 2][k];
                }
                parcialSum += arr[i + 1][j + 1];
                if(parcialSum > maxSumOfHourglassValues){
                    maxSumOfHourglassValues = parcialSum;
                }
            }
        }
        return maxSumOfHourglassValues;
    }
}

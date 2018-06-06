import java.util.Scanner;

public class SolutionDay20 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            // Write Your Code Here
            int numberOfSwaps = 0;
            for (int i = 0; i < n; i++) {
                // Track number of elements swapped during a single array traversal
                for (int j = 0; j < n - 1; j++) {
                    // Swap adjacent elements if they are in decreasing order
                    if (a[j] > a[j + 1]) {
                        int holdVal = a[j + 1];
                        a[j + 1] = a[j];
                        a[j] = holdVal;
                        numberOfSwaps++;
                    }
                }

                // If no elements were swapped during a traversal, array is sorted
                if (numberOfSwaps == 0) {
                    break;
                }
            }
            System.out.printf("Array is sorted in %d swaps.\n",numberOfSwaps);
            System.out.printf("First Element: %d\n", a[0]);
            System.out.printf("Last Element: %d\n", a[a.length - 1]);
        }
    }
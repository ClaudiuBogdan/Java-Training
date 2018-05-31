import java.util.Scanner;

public class SolutionDay14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
class Difference {
    private int[] elements;
    public int maximumDifference;

    // Add your code here
    public Difference(int[] elements) {
        this.elements = elements;
    }

    /**
     * Method that calculate the maximum differenci between all elements of elements array.
     **/
    public void computeDifference() {
        int smallest = elements[0];
        int largest = elements[0];
        for (int i = 0; i < elements.length; i++) {
            int element = elements[i];
            if (element < smallest) {
                smallest = element;
            } else if (element > largest) {
                largest = element;
            }
        }
        maximumDifference = largest - smallest;
    }
}
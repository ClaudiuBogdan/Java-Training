public class DiagonalElementsReader {

    public static void printDiagonalElements(int[][] mMatrix){
        int n = mMatrix.length - 1;
        int direction = -1; // direction upwards right
        int i = - direction;
        int j = direction;
        while (!(i==n && j==n)){
            i += direction;
            j -= direction;

            if(i > n){
                i = n;
                j += 2;
                direction *= -1;
            }
            if( j > n){
                j = n;
                i += 2;
                direction *= -1;
            }
            if(i < 0){
                i = 0;
                direction *= -1;
            }
            if(j < 0 ){
                j = 0;
                direction *= -1;
            }
            System.out.print(mMatrix[i][j] + " ");
        }
    }

    public static void main(String[] args){
        int[][] mMatrix = {{ 1, 2, 3, 4,},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        printDiagonalElements(mMatrix);
    }
}

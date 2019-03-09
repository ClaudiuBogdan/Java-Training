import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap frequencyMap = getElementsFrequency(ar);
        int countPairs = 0;
        for (Object elementCount : frequencyMap.values()) {
            countPairs += ((Integer)elementCount) / 2;
        }
        return countPairs;
    }

    static HashMap getElementsFrequency(int[] ar){
        HashMap frequencyHashMap = new HashMap<Integer, Integer>();
        for (Integer element : ar) {
            Integer elementCount = (Integer) frequencyHashMap.get(element);
            if (elementCount != null) {
                elementCount = elementCount + 1;
            } else {
                elementCount = 1;
            }
            frequencyHashMap.put(element, elementCount);
        }
        return frequencyHashMap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] inputData = new int[] { 1, 1, 3, 1, 2, 1, 3, 3, 3, 3 };
        int result = sockMerchant(inputData.length, inputData);
        System.out.println("Result: " + result);
    }
}

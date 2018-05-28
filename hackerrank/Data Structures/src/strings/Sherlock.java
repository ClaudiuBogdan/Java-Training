package strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sherlock {
    // Complete the isValid function below.
    static String isValid(String s) {
        String yesMessage = "YES";
        String noMessage = "NO";
        String message = "";
        Map<Character, Integer> charOccurence = new HashMap();
        Character characterOfString;
        for (int i = 0; i < s.length(); i++) {
            characterOfString = s.charAt(i);
            if (charOccurence.containsKey(characterOfString)) {
                charOccurence.put(characterOfString, charOccurence.get(characterOfString) + 1);
            } else {
                charOccurence.put(characterOfString, 1);
            }
        }
        Map<Integer, Integer> numOccurence = new HashMap();
        for (int chOccur : charOccurence.values()) {
            if (numOccurence.containsKey(chOccur)) {
                numOccurence.put(chOccur, numOccurence.get(chOccur) + 1);
            } else {
                numOccurence.put(chOccur, 1);
            }
        }
        if (numOccurence.size() == 1) {
            message = yesMessage;
        } else if (numOccurence.size() == 2) {
            if (numOccurence.containsKey(1)) {
                int n = 0;
                for (Integer num : numOccurence.keySet()) {
                    if (num != 1) {
                        n = num;
                    }
                }
                if (numOccurence.get(1) == 1 || numOccurence.get(1) == n + 1) {
                    message = yesMessage;
                } else {
                    message = noMessage;
                }
            } else {
                message = noMessage;
            }
        } else {
            message = noMessage;
        }
        return message;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
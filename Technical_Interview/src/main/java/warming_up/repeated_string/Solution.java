package warming_up.repeated_string;

public class Solution {
    public static void main(String[] args) {
        int charOcc = calculateCharOccurence('l', "Hellow World");
        System.out.println(charOcc);
    }

    public static int calculateCharOccurence(char character, String stringData) {
        int countOccurence = 0;
        for (char stringCharacter : stringData.toCharArray()) {
            countOccurence += character == stringCharacter ? 1 : 0;
        }
        return countOccurence;
    }
}
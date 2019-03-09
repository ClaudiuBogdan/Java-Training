package warming_up.repeated_string;

public class Solution {
    public static void main(String[] args) {
        long charOcc = calculateCharOccurence('l', "Hellow World");
        System.out.println(charOcc);
    }

    public static long calculateCharOccurence(char character, String stringData) {
        long countOccurence = 0;
        for (char stringCharacter : stringData.toCharArray()) {
            countOccurence += character == stringCharacter ? 1 : 0;
        }
        return countOccurence;
    }

    public static long calculateTotalOccurrence(String substringInput, long numberOfCharacters) {
        char repitedCharacter = 'a';
        long characterSubstringCount = calculateCharOccurence(repitedCharacter, substringInput);
        long remainderSubstringCount = calculateCharOccurence(repitedCharacter, substringInput.substring(0, (int)(numberOfCharacters % substringInput.length())));
        characterSubstringCount = characterSubstringCount * (numberOfCharacters / substringInput.length()) + remainderSubstringCount;
        return characterSubstringCount;
    }
}
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SolutionDay18 {
    // Write your code here.
    private List<Character> queueList;
    private List<Character> stackList;

    public SolutionDay18(){
        queueList = new LinkedList();
        stackList = new LinkedList();
    }

    public void pushCharacter(char ch){
        stackList.add(ch);
    }

    public void enqueueCharacter(char ch){
        queueList.add(ch);
    }

    public char popCharacter(){
        int indexLastElement = stackList.size() - 1;
        char ch = stackList.get(indexLastElement);
        stackList.remove(indexLastElement);
        return ch;
    }

    public char dequeueCharacter(){
        char ch  = queueList.get(0);
        queueList.remove(0);
        return ch;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        SolutionDay18 p = new SolutionDay18();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}


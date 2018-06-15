import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionDay28 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String regex = "@gmail.com";
        Pattern pattern = Pattern.compile(regex);
        ArrayList<String> listOfGmailUsers = new ArrayList<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            Matcher matcher = pattern.matcher(emailID);
            if(matcher.find()){
                listOfGmailUsers.add(firstName);
            }
        }
        Collections.sort(listOfGmailUsers);
        for(String user : listOfGmailUsers){
            System.out.println(user);
        }

        scanner.close();
    }
}

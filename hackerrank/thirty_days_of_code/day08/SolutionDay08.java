import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionDay08 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> phoneBook = new HashMap();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneBook.put(name,phone);

        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            String notFoundMessage = "Not found";
            Integer phoneNumber = phoneBook.get(s);
            String message = phoneNumber != null ? String.format("%s=%s",s,phoneNumber) : notFoundMessage;
            System.out.println(message);
        }
        in.close();
    }
}
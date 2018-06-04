import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class SolutionDay15 {
    public static  Node insert(Node head,int data) {
        //Complete this method
        if(head != null){
            Node lastElement = head;
            while(lastElement.next != null){
                lastElement = lastElement.next;
            }
            Node mNode = new Node(data);
            lastElement.next =  mNode;
            return head;
        }
        else{
            Node firstElem = new Node(data);
            return firstElem;
        }
    }
    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SolutionDay23 {
    static void levelOrder(Node root){
        //Write your code here
        Queue<Node> queue = new LinkedList();
        if(root != null){
            queue.add(root);

            while(queue.size() > 0){
                Node tree = queue.poll();
                System.out.print(tree.data + " ");
                if(tree.left != null){
                    queue.add(tree.left);
                }
                if(tree.right != null){
                    queue.add(tree.right);
                }
            }

        }
    }
    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }

     static class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
}


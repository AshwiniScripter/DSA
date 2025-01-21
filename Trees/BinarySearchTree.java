import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node Left,Right;

    public Node(int data){
        this.data=data;
        this.Left=null;
        this.Right=null;
    }
}

public class BinarySearchTree {

    private Node root;
    public BinarySearchTree(){
        root=null;
    }
    public void Creation(){
        Scanner Sc=new Scanner(System.in);
        System.out.print("Enter the number of nodes you want to insert: ");
        int n=Sc.nextInt();

        for(int i=1;i<=n;i++){
            System.out.print("Enter Node Value: ");
            int value=Sc.nextInt();
            root=insert(root,value);
        }
        
    }

    public Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if (data < root.data) {
            root.Left = insert(root.Left, data); // Insert in the left subtree
        } else {
            root.Right = insert(root.Right, data); // Insert in the right subtree
        }
        return root;
    }

    public void Display() {
    if (root == null) {
        System.out.println("The tree is empty.");
        return;
    }
    displayTree(root, "", false);
}
public void displayTree(Node root, String indent, boolean isLeft) {
    if (root == null) {
        return;
    }

    if (isLeft) {
        System.out.println(indent + "├── " + root.data);
    } else {
        System.out.println(indent + "└── " + root.data);
    }

    // Increase indentation for child nodes
    String newIndent = indent + (isLeft ? "│   " : "    ");
    displayTree(root.Left, newIndent, true);
    displayTree(root.Right, newIndent, false);
}


public void inorder(Node root) {
    if (root == null) {
        return; 
    }
    inorder(root.Left); 
    System.out.print(root.data + " "); 
    inorder(root.Right); 
}

public void printInorder(Node root) {
    if (root == null) {
        System.out.println("Tree is Empty.");
    } else {
        inorder(root); 
        System.out.println(); 
    }
}

public int height(Node root) {
    if (root == null) {
        return -1;
    }
    int leftHeight = height(root.Left);
    int rightHeight = height(root.Right);
    return Math.max(leftHeight, rightHeight) + 1;
}
public int level(Node root) {
    if (root == null) {
        return 0; 
    }
    return height(root) + 1;
}
    
    public static void main(String[] args) {
        try {
            @SuppressWarnings("resource")
            Scanner Sc = new Scanner(System.in);
            int ch;

        BinarySearchTree obj=new BinarySearchTree();
        while(true){

                System.out.println("\n\nEnter your choice: ");
                System.out.println("1. Creation of Binary Search Tree");
                System.out.println("2. Display Binary Search Tree");
                System.out.println("3. In-order Traversal");
                System.out.println("4. Height of Binary Search Tree");
                System.out.println("5. Level Order Traversal");
                System.out.println("6. Exit\n");
                

                ch = Sc.nextInt();
                System.out.println("You entered: " + ch);

            switch (ch) {
                case 1:
                        System.out.println("Creation of Binary Search Tree: ");
                        obj.Creation();
                    break;
                case 2:
                        System.out.println("Display Binary Search Tree: ");
                        obj.Display();
                    break;
                case 3:
                        System.out.println("Traversal of Binary Search Tree (Inorder): ");
                        obj.printInorder(obj.root);
                    break;
                case 4:
                        System.out.println("Height of Binary Search Tree: ");
                        System.out.println(obj.height(obj.root));;
                    break;
                case 5:
                    System.out.println("Level of Binary Search Tree: ");
                    System.out.println(obj.level(obj.root));;
                    break;
            
                default:
                    break;
            }
        }
        
        } catch (Exception e) {
            System.out.print("Exception"+e.getMessage());
        }
    }
}

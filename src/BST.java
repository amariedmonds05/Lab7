import java.util.Scanner;

public class BSTExample {


    static Node insert(Node root, char value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }


    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of values: ");
        int size = input.nextInt();

        String[] data = new String[size];

        System.out.println("Enter character values (enter null to skip):");

        for (int i = 0; i < size; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            data[i] = input.next();
        }

        Node root = null;


        for (int i = 0; i < size; i++) {
            if (!data[i].equalsIgnoreCase("null")) {
                root = insert(root, data[i].charAt(0));
            }
        }

        int choice;

        do {
            System.out.println("\n--- BST Traversal Menu ---");
            System.out.println("1. Inorder traversal");
            System.out.println("2. Preorder traversal");
            System.out.println("3. Postorder traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Inorder traversal: ");
                    inorder(root);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Preorder traversal: ");
                    preorder(root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Postorder traversal: ");
                    postorder(root);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }

        } while (choice != 4);

        input.close();
    }
}

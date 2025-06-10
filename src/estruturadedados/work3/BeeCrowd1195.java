package estruturadedados.work3;

import java.util.Scanner;

public class BeeCrowd1195 {
    static class Node {
        public int element;
        public Node left;
        public Node right;

        Node(int element) {
            this.element = element;
        }
    }

    static class BinarySearchTree {
        Node root;

        private Node insertRecursive(Node node, int element) {
            if (node == null) {
                return new Node(element);
            }
            if (element < node.element) {
                node.left = insertRecursive(node.left, element);
            } else {
                node.right = insertRecursive(node.right, element);
            }
            return node;
        }

        public void insert(int element) {
            root = insertRecursive(root, element);
        }

        String preOrder(Node node, String result) {
            if (node != null) {
                if (!result.isEmpty()) result += " ";
                result += node.element;
                result = preOrder(node.left, result);
                result = preOrder(node.right, result);
            }
            return result;
        }

        String inOrder(Node node, String result) {
            if (node != null) {
                result = inOrder(node.left, result);
                if (!result.isEmpty()) result += " ";
                result += node.element;
                result = inOrder(node.right, result);
            }
            return result;
        }

        String posOrder(Node node, String result) {
            if (node != null) {
                result = posOrder(node.left, result);
                result = posOrder(node.right, result);
                if (!result.isEmpty()) result += " ";
                result += node.element;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfTests = input.nextInt();

        for (int i = 1; i <= numberOfTests; i++) {
            int routes = input.nextInt();
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            for (int j = 0; j < routes; j++) {
                binarySearchTree.insert(input.nextInt());
            }

            System.out.println("Case " + i + ":");

            System.out.println("Pre.: " + binarySearchTree.preOrder(binarySearchTree.root, ""));
            System.out.println("In..: " + binarySearchTree.inOrder(binarySearchTree.root, ""));
            System.out.println("Post: " + binarySearchTree.posOrder(binarySearchTree.root, ""));

            System.out.println();
        }

    }
}




package com.learning.ds.tree;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BinaryTreeAsArray {
    private int[] tree;
    int nodeCount = 0;

    public BinaryTreeAsArray(int height) {
        /**
         * Number of nodes in Binary tree are 2* height - 1
         */
        this.tree = new int[(int) Math.pow(2, height + 1) - 1];
    }

    /**
     * Start with zero and then try to insert the less value to (2*n + 1) and greater value to (2*n + 2)
     *
     * @param value
     */
    private void add(int value) {
        if (nodeCount == 0) {
            tree[0] = value;
            System.out.println("Insertion location " + 0);
            nodeCount++;
        } else {
            boolean targetToInsertFound = false;
            int currentIndex = 0;
            while (!targetToInsertFound) {
                currentIndex = value <= tree[currentIndex] ? leftChildIndex(currentIndex) : rightChildIndex(currentIndex);
                //System.out.println("Validating Node " + currentIndex);
                if (tree[currentIndex] == 0) {
                    System.out.println("Insertion location " + currentIndex);
                    tree[currentIndex] = value;
                    nodeCount++;
                    targetToInsertFound = true;
                }
            }
        }
    }

    private void bfs() {

    }

    private void inorderTraversal() {

    }

    private void preOrder() {

    }

    private void postOrder() {

    }

    private int leftChildIndex(int nodeCount) {
        return (2 * nodeCount) + 1;
    }

    private int rightChildIndex(int nodeCount) {
        return (2 * nodeCount) + 2;
    }

    private void printTree() {
        System.out.println("Total nodes in tree " + nodeCount);
        Arrays.stream(tree).forEach(System.out::println);
    }

    public static void main(String[] args) {
        BinaryTreeAsArray binaryTreeAsArray = new BinaryTreeAsArray(3);
        binaryTreeAsArray.add(8);
        binaryTreeAsArray.add(3);
        binaryTreeAsArray.add(10);
        binaryTreeAsArray.add(1);
        binaryTreeAsArray.add(6);
        binaryTreeAsArray.add(14);
        binaryTreeAsArray.add(4);
        binaryTreeAsArray.add(7);
        binaryTreeAsArray.add(13);
        binaryTreeAsArray.printTree();

    }

}

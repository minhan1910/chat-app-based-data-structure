package test;

import helper.Stack;
import helper.impl.StackLinkedListImpl;

public class StackTest {
    public static void main(String[] args) {
        int numberOfOperations = 10000000;
        long startTime = System.nanoTime();
        // Linked list based queue
        Stack<Integer> linkedListBasedStack = new StackLinkedListImpl<>();

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedStack.push(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedStack.pop();
        }

        long endTime = System.nanoTime();
        long linkedListTime = endTime - startTime;
        System.out.println("Linked list based stack took: " + linkedListTime + "\n");
    }
}

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * This program reads a list of integer numbers from the user and saves them into a stack,
 * sorted from the smallest to the largest.
 */
public class StackSorter {
    /**
     * Main method that reads input numbers, sorts them using a stack, and prints the sorted numbers.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter a list of integer numbers (one number per line, enter 'q' to finish):");

        String input;
        while (!(input = scanner.nextLine()).equals("q")) {
            try {
                int number = Integer.parseInt(input);
                stack.push(number); // Add the input number to the stack
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer number or 'q' to finish.");
            }
        }

        // Sort the stack in ascending order
        sortStack(stack);

        System.out.println("Numbers in the stack (sorted):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // Print and remove the top element of the stack
        }
    }

    /**
     * Sorts the given stack in ascending order using a temporary stack.
     *
     * @param stack The stack to be sorted.
     */
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int currentElement = stack.pop(); // Get the top element of the stack

            // Move elements from tempStack to stack that are greater than the current element
            while (!tempStack.isEmpty() && tempStack.peek() > currentElement) {
                stack.push(tempStack.pop());
            }

            // Push the current element onto the tempStack at the right position
            tempStack.push(currentElement);
        }

        // Move elements from tempStack back to the original stack to achieve ascending order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}

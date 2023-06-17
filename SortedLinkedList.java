import java.util.*;

/**
 * A program that reads integer numbers from the user one number at a time and saves them into a sorted linked list. Once the user types 'q', the program will quit and print the list.
 */
public class SortedLinkedList {
    /**
     * Reads integer numbers from the user, saves them into a sorted linked list, and displays the sorted list.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a LinkedList to store the sorted numbers
        LinkedList<Integer> sortedNumbers = new LinkedList<>();

        // Create a Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integer numbers (enter 'q' to quit):");
        
        //While loop to add numbers one at a time. User can quit by entering 'q'.
        while (true) {
            System.out.print("Number: ");
            String input = scanner.nextLine();

            // Check if the user wants to quit by entering 'q'
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            try {
                // Parse the input into an integer
                int number = Integer.parseInt(input);

                // Add the number to the sorted list
                sortedNumbers.add(number);
            } catch (NumberFormatException e) {
                // Display an error message for invalid input
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }

        // Sort the linked list in ascending order using Collections.sort
        Collections.sort(sortedNumbers);

        // Display the sorted list to the console
        System.out.println("Sorted Numbers: " + sortedNumbers);

        // Close the Scanner to release system resources
        scanner.close();
    }
}

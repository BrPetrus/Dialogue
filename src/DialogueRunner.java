/**
 * Created by Bruno on 26/12/2016.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class actually interprets the data presented and runs the dialogue.
 */
public class DialogueRunner {
    private TreeMap<Integer, Node> nodes;

    public DialogueRunner() {
        nodes = new TreeMap<>();
    }

    public void addNode(Node n) {
        nodes.put(n.getID(), n);
    }

    public void runDialogue() {
        Node currentNode = nodes.get(0);
        do {
            currentNode.display();
            ArrayList<Link> currentLinks = currentNode.getAvailableLinks();

            System.out.println();
            System.out.println();

            // Print out all the options
            for(int i = 0; i < currentLinks.size(); i++) {
                System.out.println(i+1 + ") " + currentLinks.get(i).getDialogueMessage());
            }

            // Asks user to choose a response
            int option = getOption(1, currentLinks.size());

            currentLinks.get(option-1).run();
            currentNode = currentLinks.get(option-1).getNextNode();

            // ENTER LOOP
        }while (currentNode != null);
    }

    private int getOption(int min, int max) {
        Scanner keyboardInput = new Scanner(System.in);

        System.out.print("Enter a number (" + min + " - " + max + "): ");
        int option;
        do {
            try {
                option = keyboardInput.nextInt(); // Read the input
            }catch (InputMismatchException ime) {
                // ime.printStackTrace(); DEBUG purpose
                option = -1;
                System. out.println("You must enter a valid number!");
            }finally {
                keyboardInput.nextLine(); // Clean the buffer
            }
        }while (option > max || option < min);
        keyboardInput.close();

        return option;
    }
}

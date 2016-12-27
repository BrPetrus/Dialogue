/**
 * Created by Bruno on 26/12/2016.
 */

import java.util.ArrayList;
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
        currentNode.display();
        ArrayList<Link> currentLinks = currentNode.getAvailableLinks();

        System.out.println();
        System.out.println();

        // Print out all the options
        for(int i = 0; i < currentLinks.size(); i++) {
            System.out.println(i+1 + ") " + currentLinks.get(i).getDialogueMessage());
        }

        // Asks user to choose a response

    }

    private int getOption(int min, int max) {
        
    }
}

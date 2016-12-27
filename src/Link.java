/**
 * Created by Bruno on 26/12/2016.
 */

import java.util.ArrayList;

/**
 * Link connects Nodes. They are stored as an private member of Nodes. They represent an option in dialogue. They can
 * additionally run scripts and have conditions.
 */
public class Link {
    private Node nextNode;
    private String dialogueMessage;
    private ArrayList<Condition> conditions;
    private ArrayList<Script> scripts;

    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public String getDialogueMessage() {
        return dialogueMessage;
    }
    public void setDialogueMessage(String dialogueMessage) {
        this.dialogueMessage = dialogueMessage;
    }

    public ArrayList<Condition> getConditions() {
        return conditions;
    }
    public void addCondition(Condition condition) {
        conditions.add(condition);
    }
    public void removeAllConditions() {
        conditions.clear();
    }

    public ArrayList<Script> getScripts() {
        return scripts;
    }
    public void addScript(Script script) {
        scripts.add(script);
    }
    public void removeAllScripts() {
        scripts.clear();
    }

    /**
     * Checks if all conditions are met
     * @return True if yes
     */
    public boolean isAvailable() {
        for (Condition c : conditions) {
            if(!c.evaluate())
                return false;
        }
        return true;
    }

    /**
     * This method runs all the scripts;
     */
    public void run() {

    }
}

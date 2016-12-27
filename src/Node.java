import java.util.ArrayList;

/**
 * Node describes one of the possible dialogue state we could end up in. It has its unique ID, Sring message,
 * and list of Links where the conversation can continue.
 */
public class Node {
    private int ID;
    private String message;
    private ArrayList<Link> links;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public ArrayList<Link> getAvailableLinks() {
        ArrayList<Link> availableLinks = new ArrayList<>();
        for(Link l : links) {
            if (l.isAvailable()) {
                availableLinks.add(l);
            }
        }
        return availableLinks;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void removeAllLinks() {
        links.clear();
    }

    public void display() {
        System.out.println(message);
    }
}

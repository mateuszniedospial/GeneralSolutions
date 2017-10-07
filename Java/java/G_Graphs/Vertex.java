package G_Graphs;

/**
 * Created by Mateusz Niedośpiał on 06.10.2017.
 */
public class Vertex {
    private int priority;
    private final int representation;

    public Vertex(int priority, int representation) {
        this.priority = priority;
        this.representation = representation;
    }

    public int getPriority() {
        return priority;
    }

    public int getRepresentation() {
        return representation;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

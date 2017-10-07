package G_Graphs;

/**
 * Created by Mateusz Niedośpiał on 05.10.2017.
 */
public class Edge {
    private final int startNode;
    private final int endNode;
    private final int weight;

    public Edge(int startNode, int endNode, int weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }

    public int getStartNode() {
        return startNode;
    }

    public int getEndNode() {
        return endNode;
    }

    public int getWeight() {
        return weight;
    }
}

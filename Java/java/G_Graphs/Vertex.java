package G_Graphs;

/**
 * Created by Mateusz Niedośpiał on 06.10.2017.
 */
public class Vertex {
    private int priority;
    private final int representation;

    //addition for Dijkstra
    private int index;
    private int currentPathCostSum;
    private int indexOfPredecessor;

    public Vertex(int priority, int representation) {
        this.priority = priority;
        this.representation = representation;
        this.index = 0;
        this.currentPathCostSum = 0;
        this.indexOfPredecessor = 0;
    }

    //For Dijkstra
    public Vertex(int index) {
        this.priority = 0;
        this.representation = 0;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getCurrentPathCostSum() {
        return currentPathCostSum;
    }

    public int getIndexOfPredecessor() {
        return indexOfPredecessor;
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

    public void setIndex(int index) {
        this.index = index;
    }

    public void setCurrentPathCostSum(int currentPathCostSum) {
        this.currentPathCostSum = currentPathCostSum;
    }

    public void setIndexOfPredecessor(int indexOfPredecessor) {
        this.indexOfPredecessor = indexOfPredecessor;
    }
}

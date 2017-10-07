package G_Graphs;

import java.util.List;

/**
 * Created by Mateusz Niedośpiał on 05.10.2017.
 */
public class Graph {
    private int numberOfVertexes;
    private int numberOfEdges;
    private List<Integer>[] adjForV;

    public Graph(int numberOfVertexes, int numberOfEdges, List<Integer>[] adjForV) {
        this.numberOfVertexes = numberOfVertexes;
        this.numberOfEdges = numberOfEdges;
        this.adjForV = adjForV;
    }

    public int getNumberOfVertexes() {
        return numberOfVertexes;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public List<Integer>[] getAdjForV() {
        return adjForV;
    }

    public void setNumberOfVertexes(int numberOfVertexes) {
        this.numberOfVertexes = numberOfVertexes;
    }

    public void setNumberOfEdges(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
    }

    public void setAdjForV(List[] adjForV) {
        this.adjForV = adjForV;
    }
}

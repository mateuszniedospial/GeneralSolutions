package G_Graphs;

import java.util.*;

/**
 * Created by Mateusz Niedośpiał on 05.10.2017.
 */
public class WeightedGraph {
    private final List<Vertex> vertexes;
    private final int numberOfVertexes;
    private final int numberOfEdges;
    private final List<List<Edge>> adj;

    public WeightedGraph(List<Vertex> vertexes, int numberOfVertexes, int numberOfEdges, List<List<Edge>> adj) {
        this.vertexes = vertexes;
        this.numberOfVertexes = numberOfVertexes;
        this.numberOfEdges = numberOfEdges;
        this.adj = adj;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public int getNumberOfVertexes() {
        return numberOfVertexes;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public List<List<Edge>> getAdj() {
        return adj;
    }

    public int[] bellamFord(int startingNode){
        int[] result = new int[vertexes.size()];
        Deque<Vertex> vertexesOrdered = new LinkedList<>();
        int iterator = 0;
        for(Vertex v: vertexes){
            if(v.getRepresentation() == startingNode && !vertexesOrdered.isEmpty()){
                Vertex vertexZero = vertexesOrdered.pollFirst();
                vertexesOrdered.offerFirst(v);
                vertexesOrdered.offer(vertexZero);
                result[iterator] = 0;
                iterator++;
                continue;
            }
            vertexesOrdered.add(v);
            if(v.getRepresentation() == startingNode) {
                result[iterator] = 0;
            } else {
                result[iterator] = Integer.MAX_VALUE;
            }
            iterator++;
        }
        int numberOfIterations = vertexes.size()-1;
        boolean changed = true;
        while(changed && numberOfIterations > 0){
            changed = false;
            for(Vertex v: vertexesOrdered){
                List<Edge> adjOfNode = adj.get(v.getRepresentation());
                for(Edge e: adjOfNode){
                    if(result[e.getStartNode()] != Integer.MAX_VALUE && result[e.getEndNode()] > result[e.getStartNode()]+e.getWeight()){
                        result[e.getEndNode()] = result[e.getStartNode()] + e.getWeight();
                        changed = true;
                    }
                }
            }
            numberOfIterations--;
        }
        return result;
    }
}

package G_Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by Mateusz Niedośpiał on 06.10.2017.
 */
public class Prim {
    private PriorityQueue<Edge> leftEdges;
    private PriorityQueue<Vertex> vertexes;
    private boolean[] marked;

    private List<Edge> minimumSpanningTree;

    public Prim(WeightedGraph graph, int startingVertex) {
        this.vertexes = new PriorityQueue<>(Comparator.comparingInt(Vertex::getPriority));
        this.marked = new boolean[graph.getVertexes().size()+1]; //we indexing vertexes from 1 - X not zero;
        this.leftEdges = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        execute(graph, startingVertex);
    }

    private void execute(WeightedGraph graph, int startingVertex) {
        List<Edge> mst = new ArrayList<>();
        graph.getVertexes().forEach(vertex -> vertex.setPriority(Integer.MAX_VALUE));
        graph.getVertexes().stream()
                .filter(vertex -> vertex.getRepresentation() == startingVertex)
                .forEach(vertex -> vertex.setPriority(0)); //guarantee that starting node is min;
        vertexes.addAll(graph.getVertexes());

        while(!vertexes.isEmpty()){
            Vertex startingNode = vertexes.poll();
            marked[startingNode.getRepresentation()] = true;
            leftEdges.addAll(graph.getAdj().get(startingNode.getRepresentation()-1));
            while(!leftEdges.isEmpty()){
                Edge minLeft = leftEdges.peek();
                if(marked[minLeft.getEndNode()]){
                    leftEdges.poll();
                    continue;
                }
                marked[minLeft.getEndNode()] = true;
                Vertex temp = null;
                for(Vertex v:vertexes){
                    if(v.getRepresentation() == minLeft.getEndNode()){
                        temp = v;
                        break;
                    }
                }
                vertexes.remove(temp);
                if(temp != null) temp.setPriority(0);
                vertexes.add(temp);
                Edge minLeftRemoved = leftEdges.poll();
                mst.add(minLeftRemoved);
                break;
            }
        }
        minimumSpanningTree = mst;
    }

    public List<Edge> getMinimumSpanningTree() {
        return minimumSpanningTree;
    }
}

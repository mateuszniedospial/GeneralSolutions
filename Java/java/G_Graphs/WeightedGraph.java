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

    public Vertex[] dijkstra(int startingNode){
        Vertex[] result = new Vertex[vertexes.size()];
        vertexes.forEach(v -> result[v.getIndex()] = v);
        PriorityQueue<Vertex> PQ = new PriorityQueue<>(new Comparator<Vertex>(){
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.getCurrentPathCostSum() - o2.getCurrentPathCostSum();
            }
        });

        for(Vertex v : result){
            if(v.getIndex() == startingNode){
                v.setCurrentPathCostSum(0);
                PQ.add(v);
            }else{
                v.setCurrentPathCostSum(Integer.MAX_VALUE);
                PQ.add(v);
            }
        }

        while(! PQ.isEmpty()){
            Vertex greedyMin = PQ.poll();
            for (Edge e : adj.get(greedyMin.getIndex())) {
                if(result[e.getStartNode()].getCurrentPathCostSum() != Integer.MAX_VALUE && result[e.getEndNode()].getCurrentPathCostSum() > result[e.getStartNode()].getCurrentPathCostSum()+e.getWeight()){
                    //Unfortunately there is no decreaseKey on standard PQ implemented in JCA,
                    //That is why I'm doing here cheat by deleting changed Node from PQ and adding once again so
                    //PQ can reconstruct and get balanced:
                    Vertex toDeleteAndAdd = result[e.getEndNode()];
                    PQ.remove(toDeleteAndAdd);
                    //Replacing sum cost for lower one:
                    result[e.getEndNode()].setCurrentPathCostSum(result[e.getStartNode()].getCurrentPathCostSum()+e.getWeight());
                    //Changing predecessor:
                    result[e.getEndNode()].setIndexOfPredecessor(e.getStartNode());
                    PQ.add(toDeleteAndAdd);
                }
            }
        }
        return result;
    }
}

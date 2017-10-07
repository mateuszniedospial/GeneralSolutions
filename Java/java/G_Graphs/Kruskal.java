package G_Graphs;

import java.util.*;

/**
 * Created by Mateusz Niedośpiał on 05.10.2017.
 */
public class Kruskal {
    private final PriorityQueue<Edge> pq;
    private final int[] union;

    public Kruskal(WeightedGraph graph) {
        this.pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        this.union = new int[graph.getNumberOfVertexes()+1];

        graph.getAdj().stream()
                .flatMap(Collection::stream)
                .forEach(pq::add);

        for(int i = 1; i < union.length; i++){
            union[i] = i;
        }
    }

    public List<Edge> execute(){
        List<Edge> mst = new ArrayList<>();
        while(!pq.isEmpty() && mst.size() < union.length-2){
            Edge min = pq.poll();
            if (connected(min)) continue;
            int id = union[min.getStartNode()];
            for(int i = 1; i < union.length; i++){
                if (union[i] == id) {
                    union[i] = union[min.getEndNode()];
                }
            }
            mst.add(min);
        }
        return mst;
    }

    private boolean connected(Edge min) {
        return union[min.getStartNode()] == union[min.getEndNode()];
    }
}

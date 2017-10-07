package G_Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Mateusz Niedośpiał on 05.10.2017.
 */
public class BFS {
    private boolean[] marked;
    private Deque<Integer> visited;
    private int howManyNodesVisited;

    public BFS(Graph graph, int startingNode) {
        this.marked = new boolean[graph.getNumberOfVertexes()];
        this.visited = new ArrayDeque<>();
        this.howManyNodesVisited = 0;
        bfs(graph, startingNode);
    }

    private void bfs(Graph graph, int startingNode) {
        marked[startingNode] = true;
        howManyNodesVisited++;
        visited.add(startingNode);
        while(!visited.isEmpty()){
            for (Integer vertex : graph.getAdjForV()[visited.getFirst()]) {
                if(!marked[vertex]){
                    marked[vertex] = true;
                    howManyNodesVisited++;
                    visited.addLast(vertex);
                }
            }
            visited.removeFirst();
        }
    }

    public boolean[] getMarked() {
        return marked;
    }

    public int getHowManyNodesVisited() {
        return howManyNodesVisited;
    }
}

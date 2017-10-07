package G_Graphs;

/**
 * Created by Mateusz Niedośpiał on 05.10.2017.
 */
public class DFS {
    private boolean[] marked;
    private int numberOfTraversedVertexes;

    public DFS(Graph graph, int startingNode) {
        this.marked = new boolean[graph.getNumberOfVertexes()];
        this.numberOfTraversedVertexes = 0;
        dfs(graph, startingNode);
    }

    private void dfs(Graph graph, int startingNode) {
        marked[startingNode] = true;
        numberOfTraversedVertexes++;
        for(Integer node: graph.getAdjForV()[startingNode]){
            if(!marked[node]){
                dfs(graph, node);
            }
        }
    }

    public boolean[] getMarked() {
        return marked;
    }

    public int getNumberOfTraversedVertexes() {
        return numberOfTraversedVertexes;
    }
}

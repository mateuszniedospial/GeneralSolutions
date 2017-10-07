package G_Graphs;

import java.util.*;

/**
 * Created by Mateusz Niedośpiał on 05.10.2017.
 */
public class X_Test {
    public static void main(String[] args) {

        List<Integer>[] gAdj = new List[8];
        for(int i = 0; i < gAdj.length; i++){
            gAdj[i] = new LinkedList<>();
        }

        gAdj[0].add(1);
        gAdj[0].add(4);
        gAdj[0].add(7);

        gAdj[1].add(0);
        gAdj[1].add(2);
        gAdj[1].add(4);

        gAdj[2].add(1);
        gAdj[2].add(3);

        gAdj[3].add(2);
        gAdj[3].add(4);

        gAdj[4].add(0);
        gAdj[4].add(1);
        gAdj[4].add(3);
        gAdj[4].add(5);

        gAdj[5].add(4);
        gAdj[5].add(6);

        gAdj[6].add(5);
        gAdj[6].add(7);

        gAdj[7].add(0);
        gAdj[7].add(6);

        Graph graph = new Graph(8, 10, gAdj);

        DFS dfs = new DFS(graph, 0);
        BFS bfs = new BFS(graph, 0);

        List<List<Edge>> adjForGraph = new ArrayList<>();

        List<Edge> a = new LinkedList<>();
        List<Edge> b = new LinkedList<>();
        List<Edge> c = new LinkedList<>();
        List<Edge> d = new LinkedList<>();
        List<Edge> e = new LinkedList<>();
        List<Edge> f = new LinkedList<>();
        List<Edge> g = new LinkedList<>();
        List<Edge> h = new LinkedList<>();
        List<Edge> i = new LinkedList<>();

        Edge e12 = new Edge(1, 2, 4);
        Edge e18 = new Edge(1, 8, 8);

        Edge e21 = new Edge(2, 1, 4);
        Edge e23 = new Edge(2, 3, 8);
        Edge e28 = new Edge(2, 8, 11);

        Edge e32 = new Edge(3, 2, 8);
        Edge e34 = new Edge(3, 4, 7);
        Edge e36 = new Edge(3, 6, 4);
        Edge e39 = new Edge(3, 9, 2);

        Edge e43 = new Edge(4, 3, 7);
        Edge e45 = new Edge(4, 5, 9);
        Edge e46 = new Edge(4, 6, 14);

        Edge e54 = new Edge(5, 4, 9);
        Edge e56 = new Edge(5, 6, 10);

        Edge e63 = new Edge(6, 3, 4);
        Edge e64 = new Edge(6, 4, 14);
        Edge e65 = new Edge(6, 5, 10);
        Edge e67 = new Edge(6, 7, 2);

        Edge e76 = new Edge(7, 6, 2);
        Edge e78 = new Edge(7, 8, 1);
        Edge e79 = new Edge(7, 9, 6);

        Edge e81 = new Edge(8, 1, 8);
        Edge e82 = new Edge(8, 2, 11);
        Edge e87 = new Edge(8, 7, 1);
        Edge e89 = new Edge(8, 9, 7);

        Edge e93 = new Edge(9, 3, 2);
        Edge e97 = new Edge(9, 7, 6);
        Edge e98 = new Edge(9, 8, 7);

        a.add(e12);
        a.add(e18);

        b.add(e21);
        b.add(e23);
        b.add(e28);

        c.add(e32);
        c.add(e34);
        c.add(e36);
        c.add(e39);

        d.add(e43);
        d.add(e45);
        d.add(e46);

        e.add(e54);
        e.add(e56);

        f.add(e63);
        f.add(e64);
        f.add(e65);
        f.add(e67);

        g.add(e76);
        g.add(e78);
        g.add(e79);

        h.add(e81);
        h.add(e82);
        h.add(e87);
        h.add(e89);

        i.add(e93);
        i.add(e97);
        i.add(e98);

        adjForGraph.add(a);
        adjForGraph.add(b);
        adjForGraph.add(c);
        adjForGraph.add(d);
        adjForGraph.add(e);
        adjForGraph.add(f);
        adjForGraph.add(g);
        adjForGraph.add(h);
        adjForGraph.add(i);

        List<Vertex> vertexes = new ArrayList<>();
//        Vertex A = new Vertex(0, 1);
//        Vertex B = new Vertex(0, 2);
//        Vertex C = new Vertex(0, 3);
//        Vertex D = new Vertex(0, 4);
//        Vertex E = new Vertex(0, 5);
//        Vertex F = new Vertex(0, 6);
//        Vertex G = new Vertex(0, 7);
//        Vertex H = new Vertex(0, 8);
//        Vertex I = new Vertex(0, 9);

//        vertexes.add(A);
//        vertexes.add(B);
//        vertexes.add(C);
//        vertexes.add(D);
//        vertexes.add(E);
//        vertexes.add(F);
//        vertexes.add(G);
//        vertexes.add(H);
//        vertexes.add(I);

//        WeightedGraph wg = new WeightedGraph(vertexes,9, 28, adjForGraph);
////        Kruskal krusk = new Kruskal(wg);
////        List<Edge> mst = krusk.execute();
//
//        Prim prim = new Prim(wg, 1);
//        List<Edge> minimumSpanningTree = prim.getMinimumSpanningTree();

        Vertex S = new Vertex(0, 0);
        Vertex A = new Vertex(0, 1);
        Vertex B = new Vertex(0, 2);
        Vertex C = new Vertex(0, 3);
        Vertex D = new Vertex(0, 4);
        Vertex E = new Vertex(0, 5);

        vertexes.add(S);
        vertexes.add(A);
        vertexes.add(B);
        vertexes.add(C);
        vertexes.add(D);
        vertexes.add(E);

        List<List<Edge>> adjacencyOfGraph = new ArrayList<>();

        Edge sA = new Edge(0, 1, 10);
        Edge sE = new Edge(0, 5, 8);

        Edge aC = new Edge(1, 3, 2);

        Edge bA = new Edge(2, 1, 1);

        Edge cB = new Edge(3, 2, -2);

        Edge dA = new Edge(4, 1, -4);
        Edge dC = new Edge(4, 3, -1);

        Edge eD = new Edge(5, 4, 1);

        List<Edge> adjS = new ArrayList<>();
        adjS.add(sA);
        adjS.add(sE);

        List<Edge> adjA = new ArrayList<>();
        adjA.add(aC);

        List<Edge> adjB = new ArrayList<>();
        adjB.add(bA);

        List<Edge> adjC = new ArrayList<>();
        adjC.add(cB);

        List<Edge> adjD = new ArrayList<>();
        adjD.add(dA);
        adjD.add(dC);

        List<Edge> adjE = new ArrayList<>();
        adjE.add(eD);

        adjacencyOfGraph.add(adjS);
        adjacencyOfGraph.add(adjA);
        adjacencyOfGraph.add(adjB);
        adjacencyOfGraph.add(adjC);
        adjacencyOfGraph.add(adjD);
        adjacencyOfGraph.add(adjE);

        WeightedGraph forBellam = new WeightedGraph(vertexes, vertexes.size(), 8, adjacencyOfGraph);
        int[] shortestPathsS = forBellam.bellamFord(0);
        int[] shortestPathsD = forBellam.bellamFord(4);
    }
}

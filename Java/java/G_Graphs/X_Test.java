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

        Vertex a_dijkstra = new Vertex(0);
        Vertex b_dijkstra = new Vertex(1);
        Vertex c_dijkstra = new Vertex(2);
        Vertex d_dijkstra = new Vertex(3);
        Vertex e_dijkstra = new Vertex(4);
        Vertex f_dijkstra = new Vertex(5);
        Vertex g_dijkstra = new Vertex(6);
        Vertex h_dijkstra = new Vertex(7);

        List<Vertex> vertexesDijkstra = new ArrayList<>();
        vertexesDijkstra.add(a_dijkstra);
        vertexesDijkstra.add(b_dijkstra);
        vertexesDijkstra.add(c_dijkstra);
        vertexesDijkstra.add(d_dijkstra);
        vertexesDijkstra.add(e_dijkstra);
        vertexesDijkstra.add(f_dijkstra);
        vertexesDijkstra.add(g_dijkstra);
        vertexesDijkstra.add(h_dijkstra);

        Edge a_b_Dij = new Edge(0, 1, 20);
        Edge a_d_Dij = new Edge(0, 3, 80);
        Edge a_g_Dij = new Edge(0, 6, 90);

        Edge b_f_Dij = new Edge(1, 5, 10);

        Edge c_d_Dij = new Edge(2, 3, 10);
        Edge c_F_Dij = new Edge(2, 5, 50);
        Edge c_H_Dij = new Edge(2, 7, 20);

        Edge d_C_Dij = new Edge(3, 2, 10);
        Edge d_G_Dij = new Edge(3, 6, 20);

        Edge e_B_Dij = new Edge(4, 1, 50);
        Edge e_G_Dij = new Edge(4, 6, 30);

        Edge f_C_Dij = new Edge(5, 2, 10);
        Edge f_D_Dij = new Edge(5, 3, 40);

        Edge g_A_Dij = new Edge(6, 0, 20);

        List<List<Edge>> adjALL = new ArrayList<>();
        List<Edge> adjOfA = new ArrayList<>();
        adjOfA.add(a_b_Dij);
        adjOfA.add(a_d_Dij);
        adjOfA.add(a_g_Dij);

        List<Edge> adjOfB = new ArrayList<>();
        adjOfB.add(b_f_Dij);

        List<Edge> adjOfC = new ArrayList<>();
        adjOfC.add(c_d_Dij);
        adjOfC.add(c_F_Dij);
        adjOfC.add(c_H_Dij);

        List<Edge> adjOfD = new ArrayList<>();
        adjOfD.add(d_C_Dij);
        adjOfD.add(d_G_Dij);

        List<Edge> adjOfE = new ArrayList<>();
        adjOfE.add(e_B_Dij);
        adjOfE.add(e_G_Dij);

        List<Edge> adjOfF = new ArrayList<>();
        adjOfF.add(f_C_Dij);
        adjOfF.add(f_D_Dij);

        List<Edge> adjOfG = new ArrayList<>();
        adjOfG.add(g_A_Dij);

        List<Edge> adjOfH = new ArrayList<>();

        adjALL.add(adjOfA);
        adjALL.add(adjOfB);
        adjALL.add(adjOfC);
        adjALL.add(adjOfD);
        adjALL.add(adjOfE);
        adjALL.add(adjOfF);
        adjALL.add(adjOfG);
        adjALL.add(adjOfH);

        WeightedGraph graphForDijkstra = new WeightedGraph(vertexesDijkstra, 8, 14, adjALL);
        Vertex[] dijkstraResult = graphForDijkstra.dijkstra(0);
    }
}

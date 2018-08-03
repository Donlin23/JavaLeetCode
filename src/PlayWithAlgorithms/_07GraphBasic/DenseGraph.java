package PlayWithAlgorithms._07GraphBasic;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Author: Donlin
 * @Date: Created in 10:10 2018/8/1
 * @Version: 1.0
 * @Description: Dense graph data struct
 */
public class DenseGraph implements Graph{
    private int n;      // n means the number of vertex
    private int m;      // m means the number of edge
    private boolean isDirected; // if nor a directed graph
    private boolean[][] g;  // indicate the graph use adjacency matrix

    public DenseGraph(int n, boolean isDirected) {
        this.n = n;
        this.m = 0;
        this.isDirected = isDirected;
        g = new boolean[n][n];
    }

    public int V(){ return n; }
    public int E(){ return m; }

    public void addEdge(int v, int w){
        assert(0 <= v && v < n);
        assert(0 <= v && v < n);

        if (hasEdge(v,w))
            return;

        g[v][w] = true;
        if (!isDirected)
            g[w][v] = true;

        m ++;
    }

    public boolean hasEdge(int v, int w){
        assert (0 <= v && v < n);
        assert (0 <= v && v < n);
        return g[v][w];
    }

    public Iterator<Integer> adj(int v){
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for (int i = 0; i < g[v].length; i++) {
            if ( g[v][i] )
                adjV.add(i);
        }
        return adjV.iterator();
    }

    public void show(){
        if (g == null){
            System.out.println("No Dense Graph!");
            return;
        }
        System.out.println("DenseGraph: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < g[i].length; j++) {
                System.out.print((g[i][j]? 1:0) + " ");
            }
            System.out.println();
        }
    }
}

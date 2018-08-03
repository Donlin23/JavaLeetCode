package PlayWithAlgorithms._07GraphBasic;

import java.util.Iterator;
import java.util.Vector;

/**
 * @Author: Donlin
 * @Date: Created in 10:17 2018/8/1
 * @Version: 1.0
 * @Description: Sparse Graph data struct
 */
public class SparseGraph implements Graph{
    private int n;      // the num of the vertex
    private int m;      // the num of the edge
    private boolean isDirected; // if nor a directed graph
    private Vector<Integer>[] g;  // indicate the graph use adjacency list

    public SparseGraph(int n, boolean isDirected) {
        this.n = n;
        this.m = 0;
        this.isDirected = isDirected;
        g = (Vector<Integer>[]) new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Integer>();
        }
    }

    public int V(){ return n; }
    public int E(){ return m; }

    public void addEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && v < n;

        g[v].add(w);
        if (v != w && !isDirected)
            g[w].add(v);
    }

    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (g[v].contains(w))
            return true;
        return false;
    }

    public Iterator<Integer> adj(int v){
        assert v >= 0 && v < n;
        return g[v].iterator();
    }

    public void show(){
        if (g == null){
            System.out.println("No Sparse Graph!");
            return;
        }
        System.out.println("SparseGraph: ");
        for (int i = 0; i < n; i++) {
            Iterator<Integer> iterator = g[i].iterator();
            System.out.print(i + ": ");
            while (iterator.hasNext()){
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }
}

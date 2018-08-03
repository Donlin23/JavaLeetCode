package PlayWithAlgorithms._07GraphBasic;

import java.util.Iterator;

/**
 * @Author: Donlin
 * @Date: Created in 15:58 2018/8/2
 * @Version: 1.0
 * @Description: dfs algorithm demo, to count the connected component of the graph
 */
public class Component {

    private Graph graph;
    private boolean[] visited;
    private int ccount;         // means the connected component of the graph
    private int[] id;

    // Depth-First Traversal algorithm
    private void dfs(int v){
        visited[v] = true;
        id[v] = ccount;
        Iterator iterator = graph.adj(v);
        while(iterator.hasNext()){
            int i = (int) iterator.next();
            if ( !visited[i] ){
                dfs(i);
            }
        }
    }

    public Component(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        this.ccount = 0;
        this.id = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            if ( !visited[i] ){
                dfs(i);
                ccount ++;
            }
        }
    }

    public int count(){
        return ccount;
    }

    public boolean isConnected(int v, int w){
        assert v >= 0 && v < graph.V();
        assert w >= 0 && w < graph.V();
        return id[v] == id[w];
    }
}

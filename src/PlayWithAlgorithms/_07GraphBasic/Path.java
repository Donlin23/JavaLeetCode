package PlayWithAlgorithms._07GraphBasic;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

/**
 * @Author: Donlin
 * @Date: Created in 16:42 2018/8/2
 * @Version: 1.0
 * @Description: from source point start off, depth-first traversal to all point.
 */
public class Path {

    private Graph graph;
    private int source;
    private boolean[] visited;
    private int[] from;

    private void dfs(int source){
        visited[source] = true;
        Iterator iterator = graph.adj(source);
        while (iterator.hasNext()){
            int i = (int) iterator.next();
            if ( !visited[i] ){
                from[i] = source;
                dfs(i);
            }
        }
    }

    public Path(Graph graph, int source) {
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        this.from = new int[graph.V()];
        assert source >= 0 && source < graph.V();
        this.source = source;

        for (int i = 0; i < from.length; i++) {
            from[i] = -1;
        }
        dfs(source);
    }

    public boolean hasPath(int v){
        assert v >= 0 && v < graph.V();
        return visited[v];
    }

    public void path(int w, Vector vector){
        Stack<Integer> stack = new Stack<>();

        int cursor = w;
        while ( cursor != -1){
            stack.push(cursor);
            cursor = from[cursor];
        }
        vector.clear();
        while ( !stack.empty() ){
            vector.add(stack.peek());
            stack.pop();
        }
    }

    public void showPath(int w){
        Vector<Integer> vector = new Vector<>();
        path(w, vector);
        System.out.println("from " + this.source + " start:");
        Iterator iterator = vector.iterator();
        while(iterator.hasNext()){
            System.out.print((int)iterator.next());
            if (iterator.hasNext()){
                System.out.print("->");
            }else {
                System.out.println();
            }
        }
    }
}

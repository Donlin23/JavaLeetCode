package PlayWithAlgorithms._07GraphBasic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * @Author: Donlin
 * @Date: Created in 9:25 2018/8/3
 * @Version: 1.0
 * @Description: BFS algorithm demo, to count the shortest path of the graph from point START to point DESTINATION
 */
public class ShortestPath {

    private Graph graph;
    private int source;     // start point
    private boolean[] visited;
    private int[] from;
    private int[] ord;

    public ShortestPath(Graph graph, int source) {
        // initialization
        this.graph = graph;
        assert source >= 0 && source < graph.V();
        this.source = source;

        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        ord = new int[graph.V()];
        for (int i = 0; i < from.length; i++) {
            from[i] = -1;
            ord[i] = -1;
        }

        LinkedList<Integer> q = new LinkedList<>();

        // breath-first traversal
        q.add( source );
        visited[source] = true;
        ord[source] = 0;
        while( !q.isEmpty() ){
            int v = q.peek();
            q.poll();
            Iterator iterator = graph.adj(v);
            while( iterator.hasNext()){
                int temp = (int)iterator.next();
                if ( !visited[temp] ){
                    q.add(temp);
                    visited[temp] = true;
                    from[temp] = v;
                    ord[temp] = ord[v] + 1;
                }
            }
        }
    }

    public boolean hasPath(int w){
        assert w >= 0 && w < graph.V();
        return visited[w];
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

    public int length(int w){
        assert w >= 0 && w < graph.V();
        return ord[w];
    }


}

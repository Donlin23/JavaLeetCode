package PlayWithAlgorithms._07GraphBasic;

import java.util.Iterator;

/**
 * @Author: Donlin
 * @Date: Created in 15:02 2018/8/2
 * @Version: 1.0
 * @Description: indicate a graph
 */
public interface Graph {
    int V();
    int E();
    void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
    Iterator adj(int v);
    void show();
}

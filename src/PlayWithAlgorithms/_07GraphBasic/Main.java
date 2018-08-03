package PlayWithAlgorithms._07GraphBasic;

/**
 * @Author: Donlin
 * @Date: Created in 9:31 2018/8/2
 * @Version: 1.0
 * @Description: Main application
 */
public class Main {

    public static void main(String[] args) {

        // use SparseGraph to storage testG1
        String filename = "testG2.txt";
        SparseGraph g1 = new SparseGraph(6, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        ShortestPath shortestPath = new ShortestPath(g1, 0);
        shortestPath.showPath(5);
        //Component component = new Component(g1);
        Path path = new Path(g1, 0);
        path.showPath(5);
        //System.out.println(component.count());
//        System.out.println("test G1 in Sparse Graph:");
//        g1.show();
//
//        System.out.println();
//
//        // use DenseGraph to storage testG1
//        DenseGraph g2 = new DenseGraph(13, false);
//        ReadGraph readGraph2 = new ReadGraph(g2, filename);
//        System.out.println("test G1 in Dense Graph:");
//        g2.show();
//
//        System.out.println();
//
//        // use SparseGraph to storage testG2
//        filename = "testG2.txt";
//        SparseGraph g3 = new SparseGraph(6, false);
//        ReadGraph readGraph3 = new ReadGraph(g3, filename);
//        System.out.println("test G2 in Sparse Graph:");
//        g3.show();
//
//        System.out.println();

//        // use DenseGraph to storage testG2
//        DenseGraph g4 = new DenseGraph(6, false);
//        ReadGraph readGraph4 = new ReadGraph(g4, filename);
//        System.out.println("test G2 in Dense Graph:");
//        g4.show();


        /*
        // generate a graph with random
        int N = 20;
        int M = 100;

        // Sparse Graph
        SparseGraph g1 = new SparseGraph(N, false);
        for (int i = 0; i < M; i++) {
            int a = (int)(Math.random() * 100) % 20;
            int b = (int)(Math.random() * 100) % 20;
            g1.addEdge(a, b);
        }
        g1.show();

        // traversal the sparse graph from iterator
        System.out.println("SparseGraph from iterator:");
        for (int i = 0; i < g1.V(); i++) {
            System.out.print(i + ": ");
            Iterator iterator = g1.adj(i);
            while (iterator.hasNext()){
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }

        System.out.println();

        //Dense Graph
        DenseGraph g2 = new DenseGraph(N, false);
        for (int i = 0; i < M; i++) {
            int a = (int)(Math.random() * 100) % 20;
            int b = (int)(Math.random() * 100) % 20;
            g2.addEdge(a, b);
        }
        g2.show();
        */

    }//main_end
}

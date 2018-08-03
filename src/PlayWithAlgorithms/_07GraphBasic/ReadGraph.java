package PlayWithAlgorithms._07GraphBasic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @Author: Donlin
 * @Date: Created in 14:51 2018/8/2
 * @Version: 1.0
 * @Description: read a graph from a text file
 */
public class ReadGraph {

    private Scanner scanner;

    public ReadGraph(Graph graph, String filename) {
        readFile(filename);
        int V = scanner.nextInt();
        if (V < 0)
            throw new IllegalArgumentException("number of vertices in a Graph must be non-negative.");
        assert V == graph.V();

        int E = scanner.nextInt();
        if (E < 0)
            throw new IllegalArgumentException("number of edges in a Graph must be non-negative.");

        // add edge from the file
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            assert v >= 0 && v < V;
            assert w >= 0 && v < V;
            graph.addEdge(v, w);
        }
    }

    private void readFile(String filename){
        assert filename != null;
        try {
            File file = new File(filename);
            if (file.exists()){
                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }else {
                throw new IllegalArgumentException(filename + "doesn't exist.");
            }
        }catch (IOException e){
            throw new IllegalArgumentException("Could not open " + filename + e);
        }
    }
}

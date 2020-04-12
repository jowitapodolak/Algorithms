
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
//import org.jgrapht.alg.util;
import java.util.TreeSet;

// 1. Sort all the edges in non-decreasing order of their weight.
public class Graph {
    // number of vertices
    private long n;
    private ArrayList<Long> vertices = new ArrayList<>();
    // number of edges
    private long m;
     // vertices to their edgesWeights (sorted)
    public HashMap<Long, HashSet<Edge>> verticesData; // it doesn't need to be a treeset cs I'm adding to PG anyway
     // nodes that were visited
    public Set<Long> visited = new HashSet<>();
    public PriorityQueue<Edge> pq = new PriorityQueue<>();
    public Set<Edge> Prims = new HashSet<>();

    public Graph() {
        // read input and create a list of edges sorted in ascending order
        // edges = new HashSet<>();
        verticesData = new HashMap<>();
        try {
            readInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInput() throws IOException {
         Reader reader =new Reader();
        //Scanner reader = new Scanner("5 5\n 0 3 3\n2 3 6\n3 4 4\n3 5 2\n4 5 1");
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader reader = new BufferedReader(new StringReader("5 5\n 0 3 3\n2 3
        // 6\n3 4 4\n3 5 2\n4 5 1"));
        boolean isFirstLine = true;
        // first line with m pass - cause it can be qual to 0
        for (long i = 0; i <= this.m; i++) {
            if (isFirstLine) {
                this.n = reader.nextLong();
                this.m = reader.nextLong();
                isFirstLine = false;
            } else {
                // read m edges
                long u = reader.nextLong();
                long v = reader.nextLong();
                vertices.add(u); 
                vertices.add(v);
                long weight = reader.nextLong();
                // ad first and second vertex to the map
                addVertex(u, v, weight);
                addVertex(v, u, weight);
            }
        }
    }

    private void addVertex(long u, long v, long weight) {
        Edge edge = new Edge(u, v, weight);
        if (verticesData.containsKey(u)) {
            verticesData.get(u).add(edge);
        } else {
            HashSet<Edge> edges = new HashSet<>();
            edges.add(edge);
            verticesData.put(u, edges);
        }
    }

    public void prims() {
        // Here I will choose a random vertex and choose minimum weight for it
        // add all of its edges to priority queue
        // choose edge that is shortest
        // check if IT leads to an unvisited vertex - if not next edge
        // add this vertex edges to visited and priority queue and continue

        // Randomly choose a vertex
        Random rand = new Random();
        long currentVer = vertices.get(rand.nextInt(vertices.size()-1));
        visited.add(currentVer);
        //System.out.prlongln(currentVer);
        while (visited.size() != n) {
            HashSet<Edge> currEdges = verticesData.get(currentVer);
            // long currentV = verticesData.get(ranVer);
            // adding edges for current vertex to PQ
            for (Edge edge : currEdges) {
                pq.add(edge);
            }
            // check the shortest edge so far
            Edge shortest = pq.poll();
            // check if the shortes edge is leading to an unvisited edge If not - take the
            // next one.
            while (visited.contains(shortest.getV())) {
                shortest = pq.poll();
            }
            visited.add(shortest.getV());
            Prims.add(shortest);
            currentVer = shortest.getV();
        }
    }

    public long addWeights() {
        long sum = 0;
        for (Edge edge : Prims) {
            sum += edge.getWeight();
        }
        return sum;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.prims();
        // System.out.prlongln(graph.verticesData);
        // System.out.prlongln(graph.visited);
        // System.out.prlongln(graph.pq);
        // System.out.prlongln(graph.Prims);
        System.out.print(graph.addWeights());
    }
    // public Set<Edge> getEdges(){
    // return edges;
    // }

    // public Edge[] getSortedEdges(){
    // Arrays.sort(edges);
    // return edges;
    // }

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public long getM() {
        return m;
    }

    public void setM(long m) {
        this.m = m;
    }
}
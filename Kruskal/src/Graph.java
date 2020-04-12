import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
//import org.jgrapht.alg.util;

// 1. Sort all the edges in non-decreasing order of their weight.
public class Graph {
    // number of vertices
    private int n;
    // number of edges
    private int m;
    //graph is representented by an array od edges
    //private Edge[] edges;
    private Set<Edge> edges;

    public Graph() {
        //read input and create a list of edges sorted in ascending order
        edges = new HashSet<>();
        readInput();
        
    }

    private void readInput() {
        //new StringReader("4 4\n 1 2 532755\n1 4 528816\n3 1 626561\n3 4 980893")
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            boolean flag = true;
            String line = reader.readLine();
            //long i =0;
            while(line!=null){
                 //read n and m
                 StringTokenizer st = new StringTokenizer(line);
                 if(flag){
                     flag = false;
                     //only for the first line 
                     this.n = Integer.parseInt(st.nextToken()); 
                     this.m = Integer.parseInt(st.nextToken()); 
                     //edges = new Edge[m];
                     line =reader.readLine();
                 }else{
                    //read an edge - beginVer, endVer, EdgeWeight
                    int u = Integer.parseInt(st.nextToken()); 
                    // System.out.println("u: ");
                    // System.out.println(u);
                    int v = Integer.parseInt(st.nextToken()); 
                    // System.out.println("v: ");
                    // System.out.println(v);
                    int weight = Integer.parseInt(st.nextToken()); 
                    // System.out.println("weight: ");
                    // System.out.println(weight);
                    Edge edge = new Edge(u,v,weight); 
                    edges.add(edge);
                    //i++;
                    line = reader.readLine();
                 }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public Set<Edge> getEdges(){
        return edges;
    }

    // public Edge[] getSortedEdges(){
    //     Arrays.sort(edges);
    //     return edges;
    // }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }
}
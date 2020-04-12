import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//import org.jgrapht.alg.util;
//A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph.
// steps for finding MST using Kruskal’s algorithm
// (1.) Sort all the edges in non-decreasing order of their weight. - done by Graph
// 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far.
// If cycle is not formed, include this edge. Else, discard it. - USES UNION-FIND ALGORITHM
// 3. Repeat step#2 until there are (V-1) edges in the spanning tree.

public class MST {
    Graph graph;
    ArrayList<Edge> sortedEdges;
    Set<Edge> mstEdges;
    QuickUnionPathCompressionUF uf;
    //number of vertices
    int n;
    
    public MST() {
        graph = new Graph();
        sortedEdges = sortEdges();
        mstEdges = new HashSet<>();
        n = graph.getN();
        //create union find and pass there number of vertices
        uf = new QuickUnionPathCompressionUF(n);
    }
    //SROTING WITH PRIORITY 
    private ArrayList<Edge> sortEdges(){
        ArrayList<Edge> edges1 = new ArrayList<>(graph.getEdges());
        Collections.sort(edges1); 
        return edges1;

    }
    public void addEdges(){
        for(Edge edge: sortedEdges){
            int p =edge.getU();
            int q =edge.getV();
            // check if begin vertex and end vertex are connected 
            //if not - add edge
            if(!(uf.connected(p,q))){
                mstEdges.add(edge);//WRONG IT'S EMPTY
                //System.out.println("Edge added: " + edge);
                uf.union(p,q);
            }
            //if(uf.components()==1) break;
            if(mstEdges.size()==n-1) break;//number of edges in MST is one less than vertices
            
        }   
    }

    public long calculateWeight(){
        long sumWeight=0;
        for(Edge edge: mstEdges){
            sumWeight = sumWeight + edge.getWeight(); 
        }
        return sumWeight;
    }
    public static void main(String[] args) {
        MST mst = new MST(); 
        mst.addEdges();
       
        long n = mst.calculateWeight(); 
        System.out.println(n);
       //System.out.println(mst.getSortedEdges());
       //System.out.println(mst.getMstEdges());
    //    for(Edge edge: mst.getMstEdges()){
    //        System.out.println("1:");
    //        System.out.println(edge);
    //    }
    }
    public ArrayList<Edge> getSortedEdges() {
        return sortedEdges;
    }

    public void setSortedEdges(ArrayList<Edge> sortedEdges) {
        this.sortedEdges = sortedEdges;
    }

    public Set<Edge> getMstEdges() {
        return mstEdges;
    }

    public void setMstEdges(Set<Edge> mstEdges) {
        this.mstEdges = mstEdges;
    }
}
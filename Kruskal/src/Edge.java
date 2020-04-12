public class Edge implements Comparable<Edge>{
    private int u; 
    private int v; 
    private int weight; 
    //Edge class needs to implement Comparable to qualify for sorting
    public Edge(int u, int v, int weight) {
        this.u =u;
        this.v = v; 
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge edge){
        return Integer.compare(weight, edge.getWeight());
       // return weight - edge.getWeight()>=0 ? 0: -1;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

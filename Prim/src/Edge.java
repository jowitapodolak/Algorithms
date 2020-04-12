public class Edge implements Comparable<Edge>{
    //maybe it should be a subclass of MST?
    private long u; 
    private long v; 
    private long weight; 
    //Edge class needs to implement Comparable to qualify for sorting
    public Edge(long u, long v, long weight) {
        this.u =u;
        this.v = v; 
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge edge){
        return Long.compare(weight, edge.getWeight());
       // return weight - edge.getWeight()>=0 ? 0: -1;
    }

    public long getU() {
        return u;
    }

    public void setU(long u) {
        this.u = u;
    }

    public long getV() {
        return v;
    }

    public void setV(long v) {
        this.v = v;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
}
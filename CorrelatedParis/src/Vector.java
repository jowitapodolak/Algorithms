public class Vector{
    long [] vector;
    int vectorNumber;

    public Vector(int index){
        vector = new long[4];
        vectorNumber = index; // the number of the index as read from standard input
    }
    
    
    public long getLong(int index){
        if(index>=0 && index<4){
           return vector[index];
        } throw new IllegalArgumentException();
    }

    public int getVectorNumber() {
        return vectorNumber;
    }

    public long[] getVector() {
        return vector;
    }

    public void setLong(int index, long value) {
        vector[index] = value;
    }

}
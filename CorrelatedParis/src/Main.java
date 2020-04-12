
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int THRESHOLD = 70;
    // primary data structure - stores vectors as 4 floats
    private int allVectors; // number of vectors
    private MinHash mh1;
    private MinHash mh2;
    private MinHash mh3;
    private MinHash mh4;
    private MinHash mh5;
    private MinHash mh6;
    private HashMap<List<Integer>, List<Vector>> buckets; // each key is one bucket - later to be changed into list (of 3
                                                    // values)

    public Main() {
        buckets = new HashMap<>();
        mh1 = new MinHash(); //calculate new hash value for a vector by calling hash method on this objec
        mh2 = new MinHash();
        mh3 = new MinHash();
        mh4 = new MinHash(); //calculate new hash value for a vector by calling hash method on this objec
        mh5 = new MinHash();
        mh6 = new MinHash();
        try {
            readVectors();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public HashMap<List<Integer>, List<Vector>> getMap() {
        return buckets;
    }

    private void readVectors() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        allVectors =Integer.parseInt(reader.readLine()); // first value indicates the number of vectors
        for (int i = 0; i < allVectors; i++) {
            Vector vector = new Vector(i); // i is an identification of a vector

            
            String line =reader.readLine();
            String[] longs = line.trim().split(" ");
            long value0 = Long.parseLong(longs[0]);
            vector.setLong(0, value0);
            long value1 = Long.parseLong(longs[1]);
            vector.setLong(1, value1);
            long value2 = Long.parseLong(longs[2]);
            vector.setLong(2, value2);
            long value3 = Long.parseLong(longs[3]);
            vector.setLong(3, value3);
            
            // create hashmap

            int minHash1 = mh1.hash(vector);
            int minHash2 = mh2.hash(vector);
            int minHash3 = mh3.hash(vector);
            int minHash4 = mh4.hash(vector);
            int minHash5 = mh5.hash(vector);
            int minHash6 = mh6.hash(vector);
            List<Integer> bucket = new ArrayList<>();
            bucket.add(minHash1);
            bucket.add(minHash2);
            bucket.add(minHash3);
            bucket.add(minHash5);
            bucket.add(minHash4);
            bucket.add(minHash6);
            
            //if hashmap contains list (minHash1,minHash2,minHash3) as key add to it this vector and if not create a new list key 
            //(the order doesn't matter? If not should we use a set?)
            if (buckets.containsKey(bucket)) {
                buckets.get(bucket).add(vector);
            } else {
                ArrayList<Vector> listOfVectors = new ArrayList<>();
                listOfVectors.add(vector);
                buckets.put(bucket, listOfVectors);
            }
        }
    }

    public void iterateThroughBuckets() {
        // System.out.println("iteratingthroughbuckets");
        for (List<Integer> list : buckets.keySet()) {
            // System.out.println("hashvalue" +i);
            List<Vector> similarVectors = buckets.get(list);
            // Iterating through vectors that are in the same bucket (stored as begin index
            // of a vector)
            for (int j = 0; j < similarVectors.size(); j++) {
                // System.out.println("vector: "+ similarVectorIndexes.get(j));
                for (int k = j + 1; k < similarVectors.size(); k++) {
                    int ones = 0;
                    for (int z = 0; z < 4; z++) {
                        // calculating similarity - inner product
                        ones += Long.bitCount(similarVectors.get(j).getLong(z) & (similarVectors.get(k).getLong(z)));
                    }
                    if (ones >= THRESHOLD) {
                        System.out.print(similarVectors.get(j).getVectorNumber());
                        System.out.print(" " + similarVectors.get(k).getVectorNumber());
                        return;
                    }

                }
            }

        }

    }

    public static void main(String[] args) {
        Main mh = new Main();
        mh.iterateThroughBuckets();

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SparseInnerProductMap {
    private BufferedReader reader;
    // private Scanner sc;
    private long n = 0;
    private int s1 = 0;
    private int s2 = 0;
    // mapping from indexes (which may be very big) to values stored at those
    // position (not that big)
    private Map<Long, Integer> vVector;
    private Map<Long, Integer> wVector;

    public SparseInnerProductMap() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        vVector = new HashMap<Long, Integer>();
        wVector = new HashMap<Long, Integer>();

    }
    private void readVector(int length, BufferedReader reader, Map<Long, Integer> vector) throws IOException {
        for (int i = 0; i < length; i++) {
            String lineNext;
            lineNext = reader.readLine();
            String[] tokens1 = lineNext.split(":");
            String index = tokens1[0];
            Long numberIndex = Long.parseLong(index);
            String value = tokens1[1];
            int numberValue = Integer.parseInt(value);
            vector.put(numberIndex, numberValue);
            }
        }
    public void readInput() {
        try {
            String line = reader.readLine();
            // read first line
            String[] tokens = line.split(" "); // split firs line into three token
            // the dimension - length of vectors with all the values
            n = Long.parseLong(tokens[0]);
            // iterating through chars of a string to change them into digits
            // number of non-zero entries of the first vector
            s1 = Integer.parseInt(tokens[1]);
            // number of non-zero entries of the second vector
            s2 = Integer.parseInt(tokens[2]);
            // first vector
            readVector(s1, reader, vVector);
            reader.readLine(); // empty line
            readVector(s2, reader, wVector);
            // second vector
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void computeInnerVector() {
        // computing inner product
        int ip = 0;
        for (Long key : vVector.keySet()) {
            Integer vValue = vVector.get(key);
            Integer wValue = wVector.get(key);
            if (wValue != null) {
                ip += vValue * wValue;
            }
        }
        // System.out.println("The inner product is: " + ip);
        System.out.println(ip);

    }

    public static void main(String[] args) {
        SparseInnerProductMap s = new SparseInnerProductMap();
        s.readInput();
        s.computeInnerVector();
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OVectorsBuffer {
    private ArrayList<Vector> matrix = new ArrayList<>();
    private BufferedReader reader;
    private int vectorLength;
    private int noOfVectorsPairs;

    public OVectorsBuffer() {

        // reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            reader = Files.newBufferedReader(
                    Paths.get("/Users/jowi/Desktop/uni/AppliedAlgorithms/OrthogonalVectors/src/input.txt"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        vectorLength = 0;
        noOfVectorsPairs = 0;
    }

    private void scanInput() {

        try { // for the first two line it might be more than 1 digit
              // read first value
            vectorLength = reader.read() - 48;
            // System.out.println(vectorLength);
            reader.read(); // space - in ASCII 32
            noOfVectorsPairs = reader.read() - 48;
            // System.out.println(noOfVectorsPairs);
            for (int i = 0; i < noOfVectorsPairs * 2; i++) {
                Vector vector = new Vector(vectorLength);
                int currentChar = reader.read();
                int j = 0;
                while (currentChar != 10) {
                    if (currentChar > 47 && currentChar < 58) {
                        vector.insertValue(j, currentChar - 48);
                        j++;
                    }
                    currentChar = reader.read();
                }
                matrix.add(vector);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void iterateThrough() {
        // scan the input
        scanInput();
        // iterate through arrayList of Vectors.
        for (int i = 0; i < noOfVectorsPairs; i++) {
            for (int j = noOfVectorsPairs; j < noOfVectorsPairs * 2; j++) {
                if (ifOrthogonal(matrix.get(i), matrix.get(j))) {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");

    }

    // method that goes through vectors and stops and returns false
    // when the product of two at some points is 1 (cause orthogonsl vectors are
    // when the product is 0 and when we have at least one position that for both is
    // one then the result is not gonna be 0.)
    public static boolean ifOrthogonal(Vector vector1, Vector vector2) {
        for (int i = 0; i < vector1.length; i++) {
            if (vector1.getValue(i) * vector2.getValue(i) == 1)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        OVectorsBuffer ovector = new OVectorsBuffer();
        ovector.iterateThrough();

    }
}

/*
 * } catch (FileNotFoundException e) { e.printStackTrace(); }
 */
// System.out.println(Arrays.deepToString(matrix1));
// System.out.println(Arrays.deepToString(matrix2));
// vectors are saved now. Iterate through them and check if the same positons
// are product =1

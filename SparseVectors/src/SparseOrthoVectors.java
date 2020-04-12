import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class SparseOrthoVectors
{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String[] line = in.readLine().split(" ");
        int k = Integer.parseInt(line[1]);// number of vectors in a matrix 

        HashSet<HashSet<Long>> vectors = getVectors(k, in);

        in.readLine(); // read empty line
        boolean found = checkOrthoVectors(vectors, k, in);
        System.out.println(found ? "yes" : "no");
    }

    static HashSet<HashSet<Long>> getVectors(int k, BufferedReader in) throws IOException {
        HashSet<HashSet<Long>> vectors = new HashSet<>();
        for(int i=0; i<k; i++) {
            HashSet<Long> vector = new HashSet<>();
            String[] str = in.readLine().trim().split(" ");
            for(String a : str){
                vector.add(Long.parseLong(a));
            }
            vectors.add(vector);
        }
        return vectors;
    }

    static boolean checkOrthoVectors(HashSet<HashSet<Long>> vectors, int k,BufferedReader in) throws IOException {
        boolean found = false;
        for(int i=0; i<k; i++) {
            String[] str = in.readLine().trim().split(" ");
            for(HashSet<Long> set : vectors) {
                boolean isOrtho = true;
                for(int idx=0; idx < str.length; idx++) {
                    if(set.contains(Long.parseLong(str[idx]))) {
                        isOrtho = false;
                        break;
                    }
                }
                if(isOrtho) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }
}

import java.util.*;

public class SparseInnerProducArrays {

    public static void main(String[] args) {

        int n = 0;
        int s1 = 0;
        int s2 = 0;

  

        Scanner sc = new Scanner(System.in);
        // reading the first line
        n = sc.nextInt();
        s1 = sc.nextInt();
        s2 = sc.nextInt();

        int [] vVectorKeys = new int[s1];
        int [] vVectorValues = new int[s1];
        int [] wVectorKeys = new int[s2];
        int [] wVectorValues = new int[s2];

        // System.out.println("n = " + n);
        // System.out.println("s1 = " + s1);
        // System.out.println("s2 = " + s2);

        // reading the data into the vectors
        // System.out.println("Has next line? " + sc.hasNextLine());
        sc.nextLine(); // Advances this scanner past the current line and returns the input that was skipped.
        for (int i = 0; i < s1; i++) {
          String line = sc.nextLine();
          // System.out.println("line: " + line);
          String[] tokens = line.split(":");
          int x = Integer.parseInt(tokens[0]);
          int y = Integer.parseInt(tokens[1]);
          vVectorKeys[i] = x;
          vVectorValues[i] = y;
        }
        sc.nextLine();
        for (int j = 0; j < s2; j++) {
          String line = sc.nextLine();
          // System.out.println("line: " + line);
          String[] tokens = line.split(":");
          int x = Integer.parseInt(tokens[0]);
          int y = Integer.parseInt(tokens[1]);
          wVectorKeys[j] = x;
          wVectorValues[j] = y;
        }


        // System.out.println("vVector = " + Arrays.toString(vVector));
        // System.out.println("wVector = " + Arrays.toString(wVector));



        // computing inner product
        int ip = 0;
        for (int l = 0; l < s1; l++) {
                //ip += vVector[l] * wVector[l];
                //vVectorKeys[l] // check if its somewhere in the other
                for(int k=0; k<s2; k++){
                  if(vVectorKeys[l] == wVectorKeys[k]) {
                    ip = ip + vVectorValues[l]* wVectorValues[k];
                  }
                }
        }

        // System.out.println("The inner product is: " + ip);
        System.out.println(ip);
    }

}

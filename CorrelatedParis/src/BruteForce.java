import java.util.Scanner;

public class BruteForce {
    private static final int THRESHOLD = 70;

    public BruteForce(){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        long[] numbers32 = new long[4*number]; //an array of number lines of 256 bits number - each represented as 4 floats (float is 64 bits - 64*4 = 256)
        int i =0;
        while(sc.hasNext()){
            numbers32[i] = sc.nextLong();
            i++;
        }

        for(int j =0; j< number; j++){
            for(int k = j+1; k< number; k++){
                int ones =0;
                for(int z =0; z<4; z++){
                    //calculating similarity - inner product
                    ones+=Long.bitCount(numbers32[4*j +z]  & numbers32[4*k +z]);
                }
                if(ones>=THRESHOLD){
                    System.out.print(j);
                    System.out.print(" "+k);
                    return;
                }

            }
        }
    }
}

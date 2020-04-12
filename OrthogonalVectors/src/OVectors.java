//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class OVectors {

    // method that goes through vectors and stops and returns false
    // when the product of two at some points is 1 (cause orthogonsl vectors are
    // when the product is 0 and when we have at least one position that for both is
    // one then the result is not gonna be 0.)
    public static boolean ifProductIs1(int[] vector1, int[] vector2) {
        for(int i=0;i<vector1.length;i++){
            if(vector1[i]*vector2[i]==1)  return true;
        }
        return false;

    }

    public OVectors() {
    }

    public static void main(String[] args)
        {
        int vectorLength=0; 
        int noOfVectorsPairs=0;
        int[][] matrix1;
        int[][] matrix2;
        Scanner sc;
        //First with scanner, test, and do with BufferReader 
        //Scanner sc = new Scanner(System.in); 
        //Scanning from the file cause I don't know how to use debugger when scaaning input from terminal
        //try {
            //why it didn't want to print if it was in the same folder? If class and input in the same folder the name of the file with input is not enough?
            //sc = new Scanner(new File("/Users/jowi/Desktop/OrthogonalVectors/src/input.txt"));
            sc = new Scanner(System.in); 
            vectorLength = sc.nextInt();
            noOfVectorsPairs = sc.nextInt(); 

            //save all the vectos to a matrices!
            matrix1 = new int[noOfVectorsPairs][vectorLength];
            matrix2 = new int[noOfVectorsPairs][vectorLength];
            
            for(int i=0; i<noOfVectorsPairs;i++)
                for(int j=0;j<vectorLength;j++)
                    matrix1[i][j]= sc.nextInt();
            
            for(int i=0; i<noOfVectorsPairs;i++)
                for(int j=0;j<vectorLength;j++)
                    matrix2[i][j]= sc.nextInt();

            sc.close();
            //end of reading input
            
            //comparing a vector from first matrix with every vector from the second matrix.
            for(int i=0; i<noOfVectorsPairs;i++){
                int[] vector1 = matrix1[i];
                for(int j=0;j<noOfVectorsPairs;j++){
                    int[] vector2 = matrix2[j];
                    //int n = matrix1[i][j];
                    //int m = matrix2[i][j];
                    if(ifProductIs1(vector1, vector2)){
                    continue;
                    }else       
                    System.out.println("yes"); 
                    return;
                }
                }
                System.out.println("no");
            }
        }
      
                
             
       /* } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  */ 
        //System.out.println(Arrays.deepToString(matrix1));
        //System.out.println(Arrays.deepToString(matrix2));
        //vectors are saved now. Iterate through them and check if the same positons are product =1


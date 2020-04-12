import java.util.Scanner;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;

public class Foursum
{
    public static void main(String[] args)
    {
	Scanner S= new Scanner(System.in);
	int N = Integer.parseInt(S.nextLine());
	long[] a = new long[N];
	for(int i= 0; i < N; i+= 1) a[i] = Long.parseLong(S.nextLine());
        Arrays.sort(a);
        Stopwatch sw = new Stopwatch();
        // your code goes here and uses the following
        for (int i = 0; i < N; i++)
          for (int j = i+1; j < N; j++)
            for (int k = j+1; k < N; k++)

              if(Arrays.binarySearch(a, -a[i]-a[j]-a[k]) > k)
			{
			    //System.err.println(i+" "+j+" "+k);
			    System.out.println("True");
        System.out.println("Total time : " + sw.elapsedTime() + " seconds.");
			   System.exit(0);
			}


        System.out.println("False");
    }
}

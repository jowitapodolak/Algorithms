import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.Scanner;

public class FourSumFast
{
  public static boolean sumToZero(long[] a)
  {
    Arrays.sort(a);
    int N = a.length;
    for(int i = 0; i<N; i++)
      for (int j=i+1; j<N; j++)
        for (int k=j+1; k<N;k++)

          if(Arrays.binarySearch(a, -a[i]-a[j]-a[k])>k);

    return false;

  }

public static void main(String[] args){
//how to read that from a file not
In in = new In(args[0]);
int N = in.readInt();
long[] a = new long[N];
a = in.readAllLongs();
//a = in.readAllLongs();
FourSumFast.sumToZero(a);
}
}

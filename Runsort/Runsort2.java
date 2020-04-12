  import edu.princeton.cs.algs4.*;
  import java.util.Arrays;

  public class Runsort2 {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
      int hi = 0;
      int n = a.length;
      int[] b = new int[n];
      aux = new Comparable[n];
      //go through the array, save the lo-s into b -> thus we have all the beginings of the runs
      int j = 2;
      for(int i = 1; i < n; i++) {
        if(less(a[i], a[i-1])) {
          b[j] = i;
          StdOut.println("b[j]" + b[j]);
          j++;}
      }
      // Number of runs
      StdOut.println(j-1);
      // SORTEXAMPLE -> S ORT EX AMP L E
      // b              0,1,  2, 3,  4,5   //index
      // b              0,1,  4, 6,  9,10  //value(index in the original array)
      //beginings in first iteration:     b[0]=S, b[1]=O, b[2]=E, b[3]=A, b[4]=L, b[5]=E
      //beginings in second iteration:  b[0]=S, b[2]=E, b[4]=L
      //beginings in the third iteration: b[0]=S, b[4]=L

      //jumping in the index array(first take every beginning (from b), then every second, then every 4th etc.)
      //this way we iterate through pairs of sequences
      for (int x = 1; x < j; x = 2*x){  // x is an index in b (index array)
          //going through the runs - call merge than move lo
          System.out.println("x= " + x);

          for(int lo = 1; lo < (j-x)-1; lo = lo + 2 *x){
            StdOut.println("lo= " + lo);
            hi = b[x+2]-1;//these two lines don't work
            System.out.println("hi= " + hi);
              if(x+2==j-1){
              hi = j-1-1;
              merge(a, b[lo], b[lo+x]-1, hi);
              System.out.println("  if(x+2==b.length-1){");
              System.out.println(lo + ", " + (b[x+1]-1) + ", " +  hi );
              //System.out.pritnln(Arrays.toString(a));
              }
                hi = b[x+3]-1;
                merge(a, b[lo], b[x+1]-1, hi);
                System.out.println("else");
                System.out.println(lo + ", " + (b[x+1]-1) + ", " + hi );
              //  System.out.pritnln(Arrays.toString(a));
            } //these two lines don't work
            //    a, lo,    mid,       hi

  }
  }


    private static void merge(Comparable[] a, int lo, int mid, int hi)
    { // Merge a[lo..mid] with a[mid+1..hi].
      int i = lo, j = mid+1;
      for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
      aux[k] = a[k];
      for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
      if (i > mid) a[k] = aux[j++];
      else if (j > hi ) a[k] = aux[i++];
      else if (less(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];
    }

    private static boolean less(Comparable v, Comparable w) {
      return v.compareTo(w) < 0;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main (String args[]) {
      String[] a = StdIn.readAllStrings();
      Runsort2.sort(a);
      show(a);
    }
  }

  /*
      public class MergeBU
    {
    private static Comparable[] aux; // auxiliary array for merges
    // See page 271 for merge() code.
    public static void sort(Comparable[] a)
    { // Do lg N passes of pairwise merges.
    int N = a.length;
    aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz+sz) // sz: subarray size
    for (int lo = 0; lo < N-sz; lo += sz+sz) // lo: subarray index
    merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }
    }
  */

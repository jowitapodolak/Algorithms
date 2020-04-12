import edu.princeton.cs.algs4.*;

public class Runsort {

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    int n = a.length;
    //System.out.println(n);
    if(n<8){

      //System.out.println("Inserstion sort used");

      for(int z=1;z<n;z++)
      {
         for(int y=z; y>0 && less(a[y], a[y-1]); y--)
           exch(a,y,y-1);
           //assert isSorted(a, 0, i, comparator);
            }
            //assert isSorted(a, comparator);
    }else{
    //System.out.println("MErge sort used");
    int[] b = new int[n];
    aux = new Comparable[n];
    //go through the array, save the lo-s into b -> thus we have all the beginings of the runs
    int j = 2;
    for(int i = 1; i < n; i++) {
      if(less(a[i], a[i-1])) {
        b[j] = i;
        //StdOut.println("b[j]" + b[j]);
        j++;}
    }
    // Number of runs
    //StdOut.println(j-1);
    // SORTEXAMPLE -> S ORT EX AMP L E
    // b              0,1,  2, 3,  4,5   //index
    // b              0,1,  4, 6,  9,10  //value(index in the original array)
    //beginings in first iteration:     b[0]=S, b[1]=O, b[2]=E, b[3]=A, b[4]=L, b[5]=E
    //beginings in second iteration:    b[0]=S, b[2]=E, b[4]=L
    //beginings in the third iteration: b[0]=S, b[4]=L

    //jumping in the index array(first take every beginning (from b), then every second, then every 4th etc.)
    for (int x = 1; x < j ; x *= 2) {  // x is an index in b (index array)
        //going through the runs - call merge than move lo
        //for(int lo = 1; lo < b.length-1; lo = lo+2*x) //these two lines don't work
          //merge(a, b[lo], b[lo+1]-1, Math.min((b[lo+2*x]-1), ((b.length-1)-1)));  //these two lines don't work
        for(int lo = 1; lo <= (j-x)-1; lo = lo+(2*x)) {
          //System.out.println("The value of n is: " + n);
          // System.out.println("The value of j is: " + j);
          // System.out.println("The value of x is: " + x);
          // System.out.println("The value of lo is: " + lo);
          if((b[lo+2*x]-1) > 0) {
            merge(a, b[lo], (b[lo+x]-1), Math.min((b[lo+2*x]-1), (n-1)));
            //System.out.println("lo as b[lo] " + b[lo] + " mid as (b[lo+x]-1) " + (b[lo+x]-1) + " hi as (b[lo+2*x]-1) " + (b[lo+2*x]-1));
          }
          else {
            merge(a, b[lo], (b[lo+x]-1), (n-1));
            //System.out.println("lo as b[lo] " + b[lo] + " mid as (b[lo+x]-1) " + (b[lo+x]-1) + " hi as (n-1) " + (n-1));
          }
          for(Comparable q : a) {
            //System.out.println(q.toString());
          }
          //System.out.println("End of iteration");
  }
  for(Comparable z : a) {
  //  System.out.println(z.toString());
  }
  //System.out.println();
  //System.out.println("End of outer iteration");
 }
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
          //StdOut.println(a[i]);
      }
  }

  public static void main (String args[]) {


    String[] a = StdIn.readAllStrings();
    Runsort.sort(a);
    show(a);

    for(Comparable z : a) {
     System.out.println(z.toString());
    }

   }

   private static void exch(Object[] a, int i, int j) {
     Object swap = a[i];
     a[i] = a[j];
     a[j] = swap;
 }

  //  private static void exch(Object[] a, int i, int j) {
  //   Object swap = a[i];
  //   a[i] = a[j];
  //   a[j] = swap;
  // }
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

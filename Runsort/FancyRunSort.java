import edu.princeton.cs.algs4.*;

public class FancyRunSort {

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    int n = a.length;

    //array with indices of the begining of the sequences
    int[] b = new int[n];
    aux = new Comparable[n];
    //j is the size of the b +1. Start with two cause we have first artificial zero and later we start counting from 1 so we iterate through j-1
    int j = 2;
    for(int i = 1; i < n; i++) {
      //if  a[i] is smaller the the value presceding, increase j  and add new sequence to b
      if(less(a[i], a[i-1])) {
        b[j] = i;
        j++;
      }
    }
    //x is used as a way of iterating through sequences (iterating through array b)
    //first iteration iterates through every pair, the next iteration will iterate through pairs merged in the iteration before, and so on.
    for (int x = 1; x < j ; x *= 2) {
      //iterating through pairs of sequences
      for(int lo = 1; lo <= (j-x)-1; lo = lo+(2*x)) {
        //if (lo+2x)-1 is a valid index
        if((b[lo+2*x]-1) > 0) {
          //if run length is at most 8
          if((b[lo+2*x]-b[lo]) <= 8 && (b[lo+2*x]-1) > 0) {
            //use insertion sort
            Insertion.sort(a, b[lo], Math.min(b[lo+2*x], n));

          }
          else {
            //use merge sort
            //if((b[lo+2*x]-1) > 0) {
            merge(a, b[lo], (b[lo+x]-1), Math.min((b[lo+2*x]-1), (n-1)));
          }
        }
        //if last index would be out of bounds
        else {
          //if run length is at most 8
          if(((n-1))-b[lo] <= 8){
            //use insertion sort
            Insertion.sort(a, b[lo], n);

          }
          else {
            merge(a, b[lo], (b[lo+x]-1), (n-1));

          }
        }
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
  //algs4 library methods less, show, and exch used here.
  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  // print array to standard output
  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.println(a[i]);
    }
  }

  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  public static void main (String args[]) {
    String[] a = StdIn.readAllStrings();
    long startTime = System.currentTimeMillis();
    FancyRunSort.sort(a);
    System.out.println("now main method sorting");
    show(a);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("Running time");
    System.out.println(elapsedTime);

  }
}

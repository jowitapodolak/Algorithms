import edu.princeton.cs.algs4.*;

public class Runsort {

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
      for(int lo = 1; lo <= (j-x); lo = lo+(2*x)) {

        //condition needed because of wrapping around (cause by b array having additional 0)
        if((b[lo+2*x]-1) > 0) {
          //lo is lo, mid is next sequence -1 and hi is 3rd sequence -1
          merge(a, b[lo], (b[lo+x]-1), Math.min((b[lo+2*x]-1), (n-1)));
        }
        else {
          //case that b[lo+2*x]-1) <0 is possible because of wrapping around (caused by b array having additional 0)
          //if b[lo+2x)] is exceeding th array we are at the last sequences, meaning we can as well just take the last element as hi
          merge(a, b[lo], (b[lo+x]-1), (n-1));
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
    Runsort.sort(a);
    // System.out.println("now main method sorting");
    //show(a);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("Running time");
    System.out.println(elapsedTime);
  }
}

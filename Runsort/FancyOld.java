import edu.princeton.cs.algs4.*;

public class FancyOld {

  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    int n = a.length;
    //int result;

      //array with indices of the begining of the sequences
      int[] b = new int[n];
      aux = new Comparable[n];
      //j is the size of the b +1. Start with two cause we have first artificial zero and later we start counting from 1 so we iterate through j-1
      int j = 2;
      for(int i = 1; i < n; i++) {
        //if current i is smaller the the one before, increase b by this index
        if(less(a[i], a[i-1])) {
          b[j] = i;
          j++;
        }
      }
      System.out.println(j);
      //print array b
      // for(Comparable z : b) {
      //  System.out.println(z.toString());
      // }

      //x is used as a way of iterating through sequences (iterating through array b), each time log of sequence (first 8, then 4, then 2, then 1 - if even)
      //first iteration iterats through every pair, the next iteration will iterate through pairs merged in the iteration before
      for (int x = 1; x < j ; x *= 2) {
        System.out.println("x = " + x);
        //why this constraint on lo : lo <= (j-x)-1

        //iterating through pairs of sequences
        for(int lo = 1; lo <= (j-x)-1; lo = lo+(2*x)) {
          System.out.println("lo = " + lo);
          int count = (j-x)-1;
          System.out.println("(j-x)-1 = " + count);

          //if hi - lo is smaller than 8 then use insertion sort
          //if the length of two runs that we want to merge is shorter than 8 od insertion:
          if(b[lo+2*x]-b[lo]<8 && (b[lo+2*x]-1) > 0){
            int myHi = b[lo+2*x]-1; //calculated correctly - lo is increased
            System.out.println("hi =" + myHi);
            System.out.println("n -substract 1 to have hi =" + n);
            System.out.println("b[lo] =" + b[lo]);

            Insertion.sort(a, b[lo], Math.min(b[lo+2*x], n));
            System.out.println("insertion sort 1");
              for(Comparable e : a) {
                System.out.println(e);
              }
            }
            else if((n-1)-b[lo]<8){
              Insertion.sort(a, b[lo], n);
              int myHi2 = b[lo+2*x]-1;
              System.out.println("hi = " + myHi2);
              System.out.println("correct hi= " + n);
              System.out.println("insertion sort");
                for(Comparable e : a) {
                  System.out.println(e);
                }

          }else{
            System.out.println("merge sort");
          if((b[lo+2*x]-1) > 0) {
            //lo is lo, mid is next sequence -1 and hi is 3rd sequence -1
            merge(a, b[lo], (b[lo+x]-1), Math.min((b[lo+2*x]-1), (n-1)));
            System.out.println("b[lo]" + (b[lo]));

          }
          else {
            //ig b[lo+2x)] is exceedign th array we are at the last sequences, meaning we can as well just take the last element as hi
            merge(a, b[lo], (b[lo+x]-1), (n-1));

          }
          for(Comparable z : a) {
            System.out.println(z);
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
    // System.out.println("now main method sorting");
    //show(a);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("Running time");
    System.out.println(elapsedTime);
  //  show(a);
  }
}

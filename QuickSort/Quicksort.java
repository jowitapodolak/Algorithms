import edu.princeton.cs.algs4.*;

public class Quicksort{


  private static int partition(Comparable[] a, int lo, int hi){

    int i =lo, j=hi+1; //hi+1 just before hte first thing we do with before anything else is to decrement it.

    while(true){
      /*eqivalent to :
      i++;
      while(less(a[i],a[lo]))
      a[i++]
      if(i==hi) break;
      ?
      */
      while(less(a[++i],a[lo])) // running until object at i is less than key, otherwise stops. i is waiting for lo.
      if(i==hi) break; // just a test to make sure we are not going to run out of left hand of array

      while(less(a[lo], a[--j]))
      if(j==lo) break;  //apparently redundant // MEANS THAT IS SORTED

      if(i>=j) break;

      //exchange when j is smaller than i and a[i]> a[lo] and a[j]<a[lo]
      exch(a, i, j);
    }

    //put partitioning element in place of j

    exch(a, lo, j);

    return j;
    //return index at which we have our partitioning element

  }

  public static void sort(Comparable[] a){

    StdRandom.shuffle(a);
    sort(a, 0, a.length-1);

  }


  public static void sort(Comparable[] a, int lo, int hi){
    if (hi <= lo) return;
    int j=partition(a,lo,hi);
    sort(a,lo,j-1);
    sort(a,j+1,hi);
    //sort left and right part


  }

  private static boolean less(Comparable v, Comparable w){
    if(v==w) return true; // optimization when they equal
    return w.compareTo(v)>=0;
  }



  private static void exch(Object[] a, int i, int j){

    Object objectToSwap = a[i];
    a[i] = a[j];
    a[j] = objectToSwap;
  }

  public static void main(String[] args)
  {

    int[] array = {2,4,5,3,5,6,1,9,1,2};
    Quicksort.sort(array);
  }

}





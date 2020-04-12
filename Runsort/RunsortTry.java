
import edu.princeton.cs.algs4.*;
public class Runsort{

  private static Comparable[] aux;

// public static int[] sort(Comparable [] a){
//
//   int n = a.length;
//   aux = new Comparable[n];
//   int[] b = new int[n]; // bad - i have an array for each sequence of size elements
//   //iterating to find out sequences
//   int j=0;
//   for(int i=0;i<n;i++)
//   {
//     if(a[i].compareTo(a[i-1])<0){ //-1 usually
//       b[j] = i;
//       j++;
//     }
//   }
//   //return b;
//
//   for(int i =0; i<b.length; i=2+i){
//
//     int seqSize = b[i++] - b[i];
//
//     for(int lo=0; lo < n-seqSize; lo =lo + seqSize){
//
//
//       //merge(a,)
//     }
//
//   }
//
//   return null;
// }

public static int getNoOfSeq(Comparable [] a){

  int n = a.length;
    //number of sequences
  int size = 1;
  for(int i=1;i<n;i++)
    {
      if(a[i].compareTo(a[i-1])<0){ //-1 usually
      size++;
      }
    }
return size;
}


public static int sort(Comparable [] a){
  return 0;
}

  //we try to get number of sequences




private static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo, j = mid+1;
       // copy to aux[]
       //Comparable[] aux = new Comparable[a.length];

       for (int k = lo; k <= hi; k++) {
           aux[k] = a[k];
       }
       // merge back to a[]

       for (int k = lo; k <= hi; k++) {
           if      (i > mid)                    a[k] = aux[j++];
           else if (j > hi)                     a[k] = aux[i++];
           else if (less(aux[j], aux[i]))       a[k] = aux[j++];
           else                                 a[k] = aux[i++];
       }
   }

private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
}

//private static void merge(Comparable[] a, in lo, int endFirst, int hi)


public static void main(String[] args){
  //harcoded
  // String[] array = {"R", "U", "N", "S","O","R","T"};
  // System.out.println(runsort.getNoOfSeq(array));

  //to read from terminal
  String[] a = StdIn.readAllStrings();

  System.out.println(Runsort.getNoOfSeq(a));

  //show(a);

}
}

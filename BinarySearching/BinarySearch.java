// import java.util.Arrays;
import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.Math.*;


 public class BinarySearch
{
//   public static void main(String[] args)
//   {
//   double t = 9.0;
//   //
// while (Math.abs(0) > .001)
// {
//        t = (9.0/t + t) / 2.0;
//     StdOut.printf("%.5f\n", t);
//   }
// }
  //static method indexOf takes an integer key and a sorted array
  // of integer arguments and returns the index of key if it is present in the array, -1 otherwise
  // to perform binary search array needs to be sorted.
public static int indexOf(int[] a, int key )
{
  int lo=0;
  int hi=a.length-1;
  while(lo<=hi)
  {
    int mid=lo +(hi-lo)/2;
    if(key<a[mid]) hi=mid-1;
    else if(key>a[mid]) lo=a[mid]+1;
    else return mid;
  }
  return -1;

}

public static void main(String[] args)
{
  // is this object existing already whaat
  In in =new In(args[0]);
  int[] whitelist =in.readAllInts();
  Arrays.sort(whitelist);
  while(!StdIn.isEmpty())
  {
    int key=StdIn.readInt();
    if(indexOf(whitelist,key)==-1)
    StdOut.println(key);

  }






}
 }

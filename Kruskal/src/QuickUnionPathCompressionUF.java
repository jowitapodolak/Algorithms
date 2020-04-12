// // //need to functions:
// // // Union - connecting two sets - replace two components with one component (so delete the two components afterwards)
// // //Connected - checking if two objects are connected
// // public class UnionFind{
// //     private int size; 
// //     private int[] sz; 
// //     //id[i] points to the parent of i, if id[i] = i the i is a root node
// //     private int[] id;
// //     private int numComponents; 

// //     public UnionFind(int size){
// //         if(size <= 0){
// //             throw new IllegalArgumentException("size can't be negative"); 
// //         }
// //         this.size = size; 
// //         sz = new int[size]; 
// //         id = new int[size];
// //     }

// //     public void union(int p, int q){
// //         int root1 = find(p); 
// //         int root2 = find(q); 
// //         if(root1==root2) return; 

// //         if(sz[root1]<sz[root2]){
// //             sz[root2]+= sz[root1]; 
// //             id[root1]= root2;

// //         }else{
// //             sz[root1]+=sz[root2]; 
// //             id[root2]=root1;
// //         }
// //         size--;


// //     }

// //     public boolean connected(int p, int q){
// //         return find(p) == find(q);
// //     }

// //     public int find(int p){
// //         int root = p; //root = 1
// //         while( root != id[root])
// //         root = id[root]; 

// //         while(p!=root){
// //             int next = id[p]; 
// //             id[p] = root; 
// //             p=next;
// //         }
// //         return root;
// //     }

// //     //return number of components
// //     public int count(){
// //         return size;
// //     }
// // }


// public class UnionFind {

//   // The number of elements in this union find
//   private int size;

//   // Used to track the size of each of the component
//   private int[] sz;

//   // id[i] points to the parent of i, if id[i] = i then i is a root node
//   private int[] id;

//   // Tracks the number of components in the union find
//   private int numComponents;

//   public UnionFind(int size) {

//     if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");

//     this.size = numComponents = size;
//     sz = new int[size];
//     id = new int[size];

//     for (int i = 0; i < size; i++) {
//       id[i] = i; // Link to itself (self root)
//       sz[i] = 1; // Each component is originally of size one
//     }
//   }

//   // Find which component/set 'p' belongs to, takes amortized constant time.
//   public int find(int p) {

//     // Find the root of the component/set
//     int root = p;
//     while (root != id[root]) root = id[root];

//     // Compress the path leading back to the root.
//     // Doing this operation is called "path compression"
//     // and is what gives us amortized time complexity.
//     while (p != root) {
//       int next = id[p];
//       id[p] = root;
//       p = next;
//     }

//     return root;
//   }

//   // This is an alternative recursive formulation for the find method
//   // public int find(int p) {
//   //   if (p == id[p]) return p;
//   //   return id[p] = find(id[p]);
//   // }

//   // Return whether or not the elements 'p' and
//   // 'q' are in the same components/set.
//   public boolean connected(int p, int q) {
//     return find(p) == find(q);
//   }

//   // Return the size of the components/set 'p' belongs to
//   public int componentSize(int p) {
//     return sz[find(p)];
//   }

//   // Return the number of elements in this UnionFind/Disjoint set
//   public int size() {
//     return size;
//   }

//   // Returns the number of remaining components/sets
//   public int components() {
//     return numComponents;
//   }

//   // Unify the components/sets containing elements 'p' and 'q'
//   public void unify(int p, int q) {

//     int root1 = find(p);
//     int root2 = find(q);

//     // These elements are already in the same group!
//     if (root1 == root2) return;

//     // Merge smaller component/set into the larger one.
//     if (sz[root1] < sz[root2]) {
//       sz[root2] += sz[root1];
//       id[root1] = root2;
//     } else {
//       sz[root1] += sz[root2];
//       id[root2] = root1;
//     }

//     // Since the roots found are different we know that the
//     // number of components/sets has decreased by one
//     numComponents--;
//   }
// }



/******************************************************************************
 *  Compilation:  javac QuickUnionPathCompressionUF.java
 *  Execution:  java QuickUnionPathCompressionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Quick-union with path compression (but no weighting by size or rank).
 *
 ******************************************************************************/

/**
 *  The {@code QuickUnionPathCompressionUF} class represents a
 *  union–find data structure.
 *  It supports the <em>union</em> and <em>find</em> operations, along with
 *  methods for determining whether two sites are in the same component
 *  and the total number of components.
 *  <p>
 *  This implementation uses quick union (no weighting) with full path compression.
 *  Initializing a data structure with <em>n</em> sites takes linear time.
 *  Afterwards, <em>union</em>, <em>find</em>, and <em>connected</em> take
 *  logarithmic amortized time <em>count</em> takes constant time.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *     
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class QuickUnionPathCompressionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    /**
     * Initializes an empty union–find data structure with n isolated components 0 through n-1.
     * @param n the number of sites
     * @throws java.lang.IllegalArgumentException if n < 0
     */
    public QuickUnionPathCompressionUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }
  
    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param  p the integer representing one object
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        int root = p;
        while (root != id[root])
            root = id[root];
        while (p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the 
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        id[rootP] = rootQ;
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and n-1) from standard input, 
     * where each integer represents some object;
     * if the sites are in different components, merge the two components
     * and print the pair to standard output.
     *
     * @param args the command-line arguments
     */

}


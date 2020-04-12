import java.util.ArrayList;
import java.util.Collections;


public class MinHash {
    int [] perm;
   

    public MinHash(){
        perm = new int[256];
        shuffle();
        }       
        
    private void shuffle(){
        ArrayList<Integer> l = new ArrayList<>();
        //create  an arraylist of ints 0 to 255
        int i=0;
        while(i<256){
            l.add(i);
            i++;
        }
        Collections.shuffle(l);
        //move shuffled arraylist to an array
        for(int j=0;j<256;j++){
            perm[j] = l.get(j);
        }

    }
    public int hash(Vector vector){
        for(int i=0;i<256; i++){ 
            //perm[i] - value between - and 255, for example 129
            int block = perm[i]/64; //2 - (0,1,2, or 3)
            int pos = perm[i]%64; //1 (cause 129-2*64  = 1) position inside for the long
            if((vector.getLong(block) & 1L << 64-pos)>0 ){ // check if there is a one at postion perm[i]%64. If not this should give 0 (bit  wise and with 1 so all the zeros)
                return perm[i];

            }  // all zeros besides one 1 and the position perm[i]
    }
    throw new IllegalArgumentException("no hashvalue for that vector -  vector has only zeros");
}


}

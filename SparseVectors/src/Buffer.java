import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Buffer {
   public static void main(String[] args) throws Exception {
      String thisLine = null;
      
      try {
         // open input stream test.txt for reading purpose.
         BufferedReader br = new BufferedReader("c:/test.txt");
         
         while ((thisLine = br.readLine()) != null) {
            System.out.println(thisLine);
         }       
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}
import java.util.Random;

public class  RandomNumGenerator{

public static void main(String[] args){

Random rand = new Random();

for(int i=0; i< 1000000; i++ ){

  int n = rand.nextInt(10000);
  System.out.println(n);
}


}

}

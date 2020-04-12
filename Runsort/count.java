import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class count{

public static void main(String[] args){
int lines = 0;
File file = new File("longSstring.txt");
try{
Scanner scanner = new Scanner(file);

while (scanner.hasNextLine()){

 scanner.nextLine();
 lines++;
}
scanner.close();
}catch(FileNotFoundException e){
  System.out.println("exception");
}
System.out.println(lines);

}
}

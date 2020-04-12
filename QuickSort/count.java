
public class count{

public static main(String[] args){

BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
int lines = 0;
while (reader.readLine() != null) lines++;
reader.close();
System.out.println(lines);


}

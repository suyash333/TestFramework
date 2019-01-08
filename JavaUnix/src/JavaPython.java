import java.io.*;
 
class JavaPython{
public static void main(String a[]){
try{
 
String prg = "import sys\nprint int(sys.argv[1])+int(sys.argv[2])\n";
BufferedWriter out = new BufferedWriter(new FileWriter("test1.py"));
out.write(prg);
out.close();
int number1 = 10;
int number2 = 32;
 
ProcessBuilder pb = new ProcessBuilder("python","test1.py",""+number1,""+number2);
Process p = pb.start();
 
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
int ret = new Integer(in.readLine()).intValue();
System.out.println("value is : "+ret);
}catch(Exception e){System.out.println(e);}
}
}
 
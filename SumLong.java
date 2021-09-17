import java.util.Scanner;

public class SumLong {
  public static void main(String args[]) {

    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int b = in.nextInt();

    long c = Long.valueOf(a);
    long d = Long.valueOf(b);

    System.out.println(c + d);

    in.close();

  }  
}
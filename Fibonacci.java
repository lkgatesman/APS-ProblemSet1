import java.util.Scanner;

public class Fibonacci {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long fib1 = 0;
        long fib2 = 1;

        long current = fib1 + fib2;

        if (n == 1){
            System.out.println("0");
            in.close();
            return;
        }

        if (n == 2){    
            System.out.println("1");
            in.close();
            return;
        }

        for (int count = 3; count <= n; count++){

            current = fib1 + fib2;

            fib1 = fib2;

            fib2 = current;

        }

        System.out.println(current);

        in.close();

    }
    
}

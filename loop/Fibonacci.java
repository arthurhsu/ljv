package loop;

import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    System.out.print("Please input a number less than 40: ");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    int ans = 1;
    if (n >= 0 && n < 40) {
      if (n != 0 && n != 1) {
        int f[] = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; ++i) {
          f[i] = f[i-1] + f[i-2];
        }
        ans = f[n];
      }
      System.out.println("The answer is: " + ans);
    } else {
      System.out.println("Wrong number given.");
    }
  }
}

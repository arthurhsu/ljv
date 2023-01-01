package loop;

import java.util.Scanner;

public class Pascal {
  public static void main(String[] args) {
    System.out.print("Please input a number between 1 and 20: ");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();

    if (n < 1 || n > 20) {
      System.out.println("Must be a number between 1 and 20");
      return;
    }

    int[] prev = new int[1];
    prev[0] = 1;
    for (int i = 0; i <= n; ++i) {
      System.out.print(" ".repeat(4 * (n - i) / 2));
      for (int j = 0; j < prev.length; ++j) {
        System.out.printf(" %3d", prev[j]);
      }
      System.out.println();
      if (i == n) break;  // Stop when i == n to avoid additional wasted run

      int[] current = new int[prev.length + 1];
      current[0] = prev[0];
      for (int j = 1; j < prev.length; ++j) {
        current[j] = prev[j - 1] + prev[j];
      }
      current[prev.length] = 1;
      prev = current;
    }
  }
}

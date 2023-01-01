package loop;

import java.util.Scanner;

public class Diamond {
  public static void main(String[] args) {
    System.out.print("Please input an odd number between 3 and 15: ");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();

    if (n % 2 != 1 || n > 15 || n < 3) {
      System.out.println("Must be an odd number between 3 and 15");
      return;
    }

    for (int i = -n/2; i <= n/2; ++i) {
      int spaceCount = Math.abs(i);
      String pattern = " ".repeat(spaceCount) + "*".repeat(n - 2 * spaceCount);
      System.out.println(pattern);
    }
  }
}

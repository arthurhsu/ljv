package loop;

public class Multi1 {
  public static void main(String[] args) {
    for (int i = 2; i <= 9; i += 4) {
      for (int j = 1; j <= 9; ++j) {
        for (int k = i; k < i + 4; ++k) {
          System.out.printf("%1d * %1d = %2d", k, j, k * j);
          System.out.print((k == i + 3) ? "\n" : "   ");
        }
      }
      System.out.println();
    }
  }
}

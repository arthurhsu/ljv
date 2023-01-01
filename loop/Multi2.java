package loop;

public class Multi2 {
  public static void main(String[] args) {
    // Print title rows
    for (int i = 0; i <= 12; ++i) {
      if (i == 0) {
        System.out.print("   |");
      } else {
        System.out.printf(" %3d", i);
      }
    }
    System.out.println();
    System.out.println("-".repeat(4 * 13));
    for (int i = 1; i <= 12; ++i) {
      System.out.printf("%2d |", i);
      for (int j = 1; j <= 12; ++j) {
        System.out.printf(" %3d", i * j);
      }
      System.out.println();
    }
  }
}

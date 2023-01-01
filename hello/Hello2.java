package hello;

public class Hello2 {
  public static void main(String[] args) {
    String toWho = "world";
    if (args.length > 0) {
      toWho = args[0];
    }
    System.out.printf("Hello, %s!\n", toWho);
  }
}

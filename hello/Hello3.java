package hello;

public class Hello3 {
  public static void main(String[] args) {
    String toWho = (args.length > 0) ? args[0] : "world";
    System.out.printf("Hello, %s!\n", toWho);
  }
}

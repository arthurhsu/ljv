package game;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
  public static void main(String[] args) {
    Dealer dealer = new Dealer();
    Deck[] decks = dealer.deal();
  
    // Find who has ghost
    int currentPlayer = -1;
    for (int i = 0; i < decks.length; ++i) {
      if (decks[i].hasGhost()) {
        currentPlayer = i;
        break;
      }
    }

    // Main game loop
    boolean endGame = false;
    Combo combo = new Combo();
    while (!endGame) {
      System.out.println(decks[currentPlayer].toString());
      System.out.print("? ");
      Scanner in = new Scanner(System.in);
      String hand = in.nextLine();
      in.close();
      StringTokenizer tokenizer = new StringTokenizer(hand.trim());
      int[] indices = new int[tokenizer.countTokens()];
      int i = 0;
      while (tokenizer.hasMoreTokens()) {
        indices[i++] = Integer.parseInt(tokenizer.nextToken());
      }
      Combo.Type t = combo.checkType(decks[currentPlayer].getCards(indices));
      System.out.println(t);
      endGame = true;
    }
  }
}

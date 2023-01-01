package classes;

import java.util.Random;
import java.util.Arrays;

public class Deck1 {
  public static void print(int player, Card[] deck) {
    System.out.printf("Player %d:", player);
    for (int i = 0; i < deck.length; ++i) {
      System.out.printf(" %s", deck[i].toString());
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] cards = new int[52];
    int players = 4;

    // Find every card a player
    Random rnd = new Random();

    // Initialize count array to all zeros
    int[] count = new int[players];
    Arrays.fill(count, 0);

    for (int i = 0; i < 52; ++i) {
      int owner = -1;
      while (owner < 0) {
        owner = rnd.nextInt(players);
        if (count[owner] >= 13) {
          owner = -1;
        }
      }
      count[owner]++;
      cards[i] = owner;
    }

    // Print the decks
    for (int i = 0; i < players; ++i) {
      Card[] deck = new Card[13];
      int index = 0;
      for (int j = 0; j < 52; ++j) {
        if (cards[j] == i) {
          deck[index++] = new Card(j);
        }
      }
      Deck1.print(i, deck);
    }
  }
}

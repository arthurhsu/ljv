package classes;

import java.util.Random;
import java.util.Arrays;

public class Deck0 {
  public static void print(int player, int[] deck) {
    System.out.printf("Player %d:", player);
    final String[] suit = new String[] {"S", "H", "D", "C"};
    final String[] rank = new String[]
        {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    for (int i = 0; i < deck.length; ++i) {
      int suitIndex = deck[i] / 13;
      int rankIndex = deck[i] % 13;
      System.out.printf(" %s%s", rank[rankIndex], suit[suitIndex]);
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
      int[] deck = new int[13];
      int index = 0;
      for (int j = 0; j < 52; ++j) {
        if (cards[j] == i) {
          deck[index++] = j;
        }
      }
      Deck0.print(i, deck);
    }
  }
}

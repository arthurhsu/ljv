package classes;

import java.util.Random;

public class Dealer {
  public Dealer() {
    // Empty constructor
  }

  public Deck[] deal() {
    int players = 4;

    // Find every card a player
    Random rand = new Random();
    
    // Initialize decks
    Deck[] decks = new Deck[players];
    for (int i = 0; i < players; ++i) {
      decks[i] = new Deck(i);
    }

    // Deal the card
    for (int i = 0; i < 52; ++i) {
      int owner = -1;
      while (owner < 0) {
        owner = rand.nextInt(players);
        if (decks[owner].length() >= 13) {
          owner = -1;
        }
      }
      decks[owner].deal(i);
    }

    return decks;
  }

  public static void main(String[] args) {
    Dealer dealer = new Dealer();
    Deck[] decks = dealer.deal();
  
    for (int i = 0; i < decks.length; ++i) {
      System.out.println(decks[i].toString());
    }
  }
}

package game;

import java.util.Random;

public class Dealer {
  public Dealer() {
    // Empty constructor
  }

  public void deal(Player[] players) {
    // Find every card a player
    Random rand = new Random();
    
    // Initialize decks
    Deck[] decks = new Deck[players.length];
    for (int i = 0; i < players.length; ++i) {
      decks[i] = new Deck();
      players[i].receive(decks[i]);
    }

    // Deal the card
    for (int i = 0; i < 52; ++i) {
      int owner = -1;
      while (owner < 0) {
        owner = rand.nextInt(players.length);
        if (decks[owner].length() >= 13) {
          owner = -1;
        }
      }
      decks[owner].deal(i);
    }
  }
}

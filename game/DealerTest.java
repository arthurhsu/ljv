package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class DealerTest {
  @Test
  public void testDeal() {
    Player[] players = new Player[4];
    for (int i = 0; i < 4; ++i) {
      players[i] = new Player("Player " + i);
    }

    new Dealer().deal(players);
    boolean[] raw = new boolean[52];

    // There should be 4 decks, each has 13 cards
    for (int i = 0; i < 4; ++i) {
      Deck deck = players[i].showDeck();
      assertEquals(deck.length(), 13);
      Card[] cards = deck.getCards();
      for (Card c : cards) {
        raw[c.getRawIndex()] = true;
      }
    }

    // All 52 cards should be accounted for
    for (int i = 0; i < 52; ++i) {
      assertTrue(raw[i]);
    }
  }
}

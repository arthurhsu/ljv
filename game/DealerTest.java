package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class DealerTest {
  @Test
  public void testDeal() {
    Deck[] decks = new Dealer().deal();
    boolean[] raw = new boolean[52];

    // There should be 4 decks, each has 13 cards
    assertEquals(decks.length, 4);
    for (int i = 0; i < decks.length; ++i) {
      assertEquals(decks[i].length(), 13);
      Card[] cards = decks[i].getCards();
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

package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
  @Test
  public void testHaveGhost() {
    Deck deck = new Deck();
    deck.deal(new Card("AS"));
    assertFalse(deck.hasGhost());
    deck.deal(new Card("KC"));
    assertFalse(deck.hasGhost());
    deck.deal(new Card("3C"));
    assertTrue(deck.hasGhost());
  }

  @Test
  public void testRemoveCard() {
    Deck deck = new Deck();
    deck.deal(new Card("AS"));
    deck.deal(new Card("KC"));
    deck.deal(new Card("3C"));
    assertEquals(deck.length(), 3);
    assertTrue(deck.hasGhost());
    deck.removeCards(new int[]{2});
    assertEquals(deck.length(), 2);
    assertFalse(deck.hasGhost());
  }
}

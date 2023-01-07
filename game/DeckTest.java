package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
  @Test
  public void testHaveGhost() {
    Deck deck = new Deck(0);
    deck.deal(new Card("AS"));
    assertFalse(deck.hasGhost());
    deck.deal(new Card("KC"));
    assertFalse(deck.hasGhost());
    deck.deal(new Card("3C"));
    assertTrue(deck.hasGhost());
  }
}

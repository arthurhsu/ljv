package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {
  @Test
  public void testHaveGhost() {
    Deck deck = new Deck();
    deck.deal(new Card("3S"));
    deck.deal(new Card("3D"));

    Hand hand = new Hand(deck.getCards());
    assertFalse(hand.hasGhost());

    deck.deal(new Card("3C"));
    deck.deal(new Card("3H"));
    deck.deal(new Card("JC"));
    hand = new Hand(deck.getCards());
    assertTrue(hand.hasGhost());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHand() {
    Deck deck = new Deck();
    deck.deal(new Card("3S"));
    deck.deal(new Card("2D"));

    new Hand(deck.getCards());  // throws IllegalArgumentException
  }
}

package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {
  private Card[] generate(String... cards) {
    Card[] ret = new Card[cards.length];
    for (int i = 0; i < cards.length; ++i) {
      ret[i] = new Card(cards[i]);
    }
    return ret;
  }

  @Test
  public void testHaveGhost() {
    Hand hand = new Hand(generate("3S", "3D"));
    assertFalse(hand.hasGhost());

    hand = new Hand(generate("3H", "3C"));
    assertTrue(hand.hasGhost());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHand() {
    new Hand(generate("3S", "2D"));  // throws IllegalArgumentException
  }

  @Test
  public void testCanWin() {
    try {
      Hand fk1 = new Hand(generate("2S", "7C", "7D", "7S", "7H"));
      Hand a = new Hand(generate("2C"));
      Hand b = new Hand(generate("2S"));
      assertFalse(a.canWin(b));
      assertTrue(b.canWin(a));
      assertTrue(fk1.canWin(b));

      a = new Hand(generate("3C", "3H"));
      b = new Hand(generate("3D", "3S"));
      assertTrue(b.canWin(a));
      a = new Hand(generate("4D", "4C"));
      assertTrue(a.canWin(b));
      assertTrue(fk1.canWin(a));

      a = new Hand(generate("2S", "3H", "4S", "5D", "6H"));
      b = new Hand(generate("2H", "3D", "4D", "5H", "6S"));
      assertTrue(a.canWin(b));
      assertTrue(fk1.canWin(a));
      b = new Hand(generate("3C", "4C", "5C", "6C", "7C"));
      assertTrue(b.canWin(a));
      assertTrue(fk1.canWin(b));
      a = new Hand(generate("3D", "4D", "5D", "6D", "7D"));
      assertTrue(a.canWin(b));
      assertTrue(fk1.canWin(a));
      b = new Hand(generate("2C", "3C", "4C", "5C", "6C"));
      assertTrue(b.canWin(a));
      assertTrue(fk1.canWin(b));
      b = new Hand(generate("AH", "AS", "3C", "AD", "AC"));
      assertTrue(b.canWin(fk1));
    } catch (IllegalStateException e) {
      throw e;  // rethrow
    }
  }
}

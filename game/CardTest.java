package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
  @Test
  public void testWeight() {
    Card c = new Card("2S");
    assertEquals(c.weight(), 154);
    c = new Card("7C");
    assertEquals(c.weight(), 71);
    c = new Card("7D");
    assertEquals(c.weight(), 72);
  }
}

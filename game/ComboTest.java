package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class ComboTest {
  private Card[] generate(String... cards) {
    Card[] ret = new Card[cards.length];
    for (int i = 0; i < cards.length; ++i) {
      ret[i] = new Card(cards[i]);
    }
    return ret;
  }

  @Test
  public void testCheckType5() {
    Combo combo = new Combo();
    
    Card[] nada = generate("3C", "5D", "6H", "8S", "9C");
    assertEquals(combo.checkType(nada), Combo.Type.Invalid);
    
    Card[] royal1 = generate("2S", "3S", "4S", "5S", "6S");
    Card[] royal2 = generate("10D", "JD", "QD", "KD", "AD");
    assertEquals(combo.checkType(royal1), Combo.Type.RoyalFlush);
    assertEquals(combo.checkType(royal2), Combo.Type.RoyalFlush);

    Card[] foak1 = generate("AS", "AD", "AH", "3C", "AC");
    assertEquals(combo.checkType(foak1), Combo.Type.FourOfAKind);

    Card[] fullHouse1 = generate("3D", "3H", "3S", "KS", "KD");
    assertEquals(combo.checkType(fullHouse1), Combo.Type.FullHouse);

    Card[] flush1 = generate("7C", "8D", "9C", "10C", "JC");
    Card[] flush2 = generate("10D", "JC", "QS", "KS", "AD");
    assertEquals(combo.checkType(flush1), Combo.Type.Flush);
    assertEquals(combo.checkType(flush2), Combo.Type.Flush);
  }

  @Test
  public void testCheckType2() {
    Combo combo = new Combo();

    Card[] nada = generate("AS", "KS");
    assertEquals(combo.checkType(nada), Combo.Type.Invalid);

    Card[] pair = generate("2C", "2S");
    assertEquals(combo.checkType(pair), Combo.Type.Pair);
  }

  @Test
  public void testCheckType1() {
    Combo combo = new Combo();
    Card[] single = generate("2S");
    assertEquals(combo.checkType(single), Combo.Type.Single);
  }
}

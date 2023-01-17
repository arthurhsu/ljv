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

    Card[] flush3 = generate("JD", "QS", "KC", "AC", "2S");
    assertEquals(combo.checkType(flush3), Combo.Type.Invalid);
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

  @Test
  public void testGetWeight() {
    Combo combo = new Combo();
    Card[] single = generate("2S");
    assertEquals(combo.getWeight(Combo.Type.Single, single), 154);

    Card[] pair1 = generate("2S", "2C");
    Card[] pair2 = generate("2S", "2C");
    assertEquals(combo.getWeight(Combo.Type.Pair, pair1), 154);
    assertEquals(combo.getWeight(Combo.Type.Pair, pair2), 154);

    Card[] fh1 = generate("2S", "2C", "3C", "3D", "3H");
    Card[] fh2 = generate("3D", "2C", "3C", "2S", "3H");
    assertEquals(combo.getWeight(Combo.Type.FullHouse, fh1), 33);
    assertEquals(combo.getWeight(Combo.Type.FullHouse, fh2), 33);

    Card[] flush1 = generate("2S", "3C", "4S", "5D", "6H");
    assertEquals(combo.getWeight(Combo.Type.Flush, flush1), 154);
    Card[] flush2 = generate("3C", "4S", "5D", "6H", "7D");
    assertEquals(combo.getWeight(Combo.Type.Flush, flush2), 72);
    Card[] flush3 = generate("10C", "JC", "QD", "KS", "AH");
    assertEquals(combo.getWeight(Combo.Type.Flush, flush3), 143);

    Card[] rf1 = generate("3C", "4C", "5C", "6C", "7C");
    assertEquals(combo.getWeight(Combo.Type.RoyalFlush, rf1), 710);
    Card[] rf2 = generate("3D", "4D", "5D", "6D", "7D");
    assertEquals(combo.getWeight(Combo.Type.RoyalFlush, rf2), 720);
    Card[] rf3 = generate("3C", "4C", "5C", "6C", "2C");
    assertEquals(combo.getWeight(Combo.Type.RoyalFlush, rf3), 1510);

    Card[] fk1 = generate("3S", "2S", "3C", "3D", "3H");
    assertEquals(combo.getWeight(Combo.Type.FourOfAKind, fk1), 10034);
    Card[] fk2 = generate("3C", "2S", "2C", "2D", "2H");
    assertEquals(combo.getWeight(Combo.Type.FourOfAKind, fk2), 10154);
  }
}

package game;

import java.util.ArrayList;
import java.util.Arrays;

public final class Hand {
  private final ArrayList<Card> _cards;
  private Combo.Type _type;
  private Combo _combo;
  
  private Hand() {
    _combo = null;
    _type = Combo.Type.Invalid;
    _cards = null;
  }

  public static Hand pass() {
    return new Hand();
  }

  public boolean isPass() {
    return _type == Combo.Type.Invalid;
  }

  public Hand(Card[] cards) throws IllegalArgumentException {
    _combo = new Combo();
    _type = _combo.checkType(cards);
    if (_type == Combo.Type.Invalid) {
      throw new IllegalArgumentException("Invalid combination");
    }

    _cards = new ArrayList<>(Arrays.asList(cards));
  }

  public boolean canWin(Hand hand) {
    if (hand.isPass()) return true;

    // TODO: implement
    return false;
  }

  public boolean hasGhost() {
    for (Card c : _cards) {
      if (c.isGhost()) return true;
      System.out.println(c.toString());
    }
    return false;
  }

  public Card[] getCards() {
    return (Card[]) _cards.toArray();
  }

  public Combo.Type getType() {
    return _type;
  }
}
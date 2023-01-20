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

  public boolean canWin(Hand hand) throws IllegalStateException {
    if (hand.isPass()) return true;

    if (this.isPass() || (
        this._type != Combo.Type.FourOfAKind &&
        (this._type != Combo.Type.RoyalFlush &&
            hand.getType() != Combo.Type.Flush) &&
        this._type != hand.getType())) {
      throw new IllegalStateException("Attempt to test invalid hands");
    }

    return getWeight() > hand.getWeight();
  }

  public boolean hasGhost() {
    for (Card c : _cards) {
      if (c.isGhost()) return true;
      System.out.println(c.toString());
    }
    return false;
  }

  public Card[] getCards() {
    if (this.isPass()) {
      return new Card[0];
    }

    Card[] cards = new Card[_cards.size()];
    return _cards.toArray(cards);
  }

  public Combo.Type getType() {
    return _type;
  }

  public int getWeight() {
    return _combo.getWeight(_type, getCards());
  }
}
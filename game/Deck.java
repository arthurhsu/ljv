package game;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
  private ArrayList<Card> _cards;

  public Deck() {
    _cards = new ArrayList<Card>(13);
  }

  public Card[] getCards() {
    Card[] cards = new Card[_cards.size()];
    return _cards.toArray(cards);
  }

  public Card[] getCards(int[] indices) {
    Card[] cards = new Card[indices.length];
    for (int i = 0; i < indices.length; ++i) {
      cards[i] = _cards.get(indices[i]);
    }
    return cards;
  }

  public void removeCards(int[] indices) {
    Arrays.sort(indices);
    for (int i = indices.length - 1; i >= 0; --i) {
      _cards.remove(indices[i]);
    }
  }

  public void deal(int card) {
    _cards.add(new Card(card));
  }

  public void deal(Card card) {
    _cards.add(card);
  }

  public int length() {
    return _cards.size();
  }

  public String toString() {
    String ret = "";
    for (int i = 0; i < _cards.size(); ++i) {
      ret += "  " + i + ")";
      ret += " " + _cards.get(i).toString();
    }
    return ret;
  }

  public boolean hasGhost() {
    for (Card c : _cards) {
      if (c.isGhost()) return true;
    }
    return false;
  }
}

package game;

import java.util.Arrays;

public class Card {
  private String[] _SUITS;
  private String[] _RANKS;
  private int _suit;
  private int _rank;
  private int _index;

  public String suit() {
    return _SUITS[_suit];
  }

  public int rank() {
    return _rank + 1;
  }

  public String getRankString() {
    return _RANKS[_rank];
  }

  public boolean isGhost() {
    return _rank == 2 && _suit == 3;
  }

  public int getRawIndex() {
    return _index;
  }

  public String toString() {
    return _RANKS[_rank] + _SUITS[_suit];
  }

  private Card() {
    // Default constructor
    _SUITS = new String[]{"S", "H", "D", "C"};
    _RANKS = new String[]
        {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
  }

  public Card(int index) {
    this();
    _index = index;

    _suit = index / 13;
    _rank = index % 13;
  }

  public Card(String card) {
    this();

    // FIXIT: Not really ideal, but settled for now. Inputs are evil.
    String suit = card.toUpperCase().substring(
        card.length() - 1, card.length());
    String rank = card.toUpperCase().substring(0, card.length() - 1);
    _suit = Arrays.asList(_SUITS).indexOf(suit);
    _rank = Arrays.asList(_RANKS).indexOf(rank);
  }
}

package classes;

public class Deck {
  private int _player;
  private Card[] _cards;
  private int _index;

  public Deck(int player) {
    _player = player;
    _cards = new Card[13];
    _index = 0;
  }

  public void deal(int card) {
    _cards[_index++] = new Card(card);
  }

  public int length() {
    return _index;
  }

  public String toString() {
    String ret = "Player " + _player + ":";
    for (int i = 0; i < _cards.length; ++i) {
      ret += " " + _cards[i].toString();
    }
    return ret;
  }
}

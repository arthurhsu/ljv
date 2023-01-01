package classes;

public class Card {
  private String _suit;
  private String _rank;
  private int _index;

  public String suit() {
    return _suit;
  }

  public String rank() {
    return _rank;
  }

  public int getRawIndex() {
    return _index;
  }

  public String toString() {
    return _rank + _suit;
  }

  public Card(int index) {
    _index = index;

    final String[] suit = {"S", "H", "D", "C"};
    final String[] rank =
        {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    _suit = suit[index / 13];
    _rank = rank[index % 13];
  }
}

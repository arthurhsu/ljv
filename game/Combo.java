package game;

import java.util.Arrays;

public class Combo {
  public enum Type {
    Invalid,
    Single,
    Pair,
    Flush,
    FullHouse,
    FourOfAKind,
    RoyalFlush
  }

  public int getNumberOfCards(Type type) {
    switch (type) {
      case Single: return 1;
      case Pair: return 2;
      case FourOfAKind:
      case Flush:
      case FullHouse:
      case RoyalFlush:
        return 5;
      default:  // Invalid
        return -1;
    }
  }

  public Type checkType(Card[] cards) {
    switch (cards.length) {
      case 1: return Type.Single;
      case 2: return isPair(cards) ? Type.Pair : Type.Invalid;
      case 5: return isRoyalFlush(cards) ? Type.RoyalFlush : (
          isFlush(cards) ? Type.Flush : (
          isFullHouse(cards) ? Type.FullHouse : (
          isFourOfAKind(cards) ? Type.FourOfAKind : Type.Invalid)));
      default: return Type.Invalid;
    }
  }

  public boolean isType(Type type, Card[] cards) {
    if (cards.length != getNumberOfCards(type)) {
      return false;
    }

    switch (type) {
      case Single: return true;
      case Pair: return isPair(cards);
      case FourOfAKind: return isFourOfAKind(cards);
      case Flush: return isFlush(cards);
      case FullHouse: return isFullHouse(cards);
      case RoyalFlush: return isRoyalFlush(cards);
      default: return false;  // Invalid
    }
  }

  private boolean isPair(Card[] cards) {
    return cards[0].rank() == cards[1].rank();
  }

  private int[] getSortedRank(Card[] cards) {
    int[] rank = new int[5];
    for (int i = 0; i < 5; ++i) {
      rank[i] = cards[i].rank();
    }
    Arrays.sort(rank);
    return rank;
  }

  private boolean isFourOfAKind(Card[] cards) {
    int[] rank = getSortedRank(cards);

    // 1-4 or 4-1
    int startIndex = (rank[0] == rank[1]) ? 0 : 1;
    int endIndex = (rank[0] == rank[1]) ? 4 : 5;
    int start = rank[startIndex];
    for (int i = startIndex + 1; i < endIndex; ++i) {
      if (rank[i] != start) return false;
    }
    return true;
  }

  private boolean isFlush(Card[] cards) {
    int[] rank = getSortedRank(cards);
    if (rank[0] == 1 && rank[4] == 13) {  // ACE and K
      // Special case of 10 J Q K A
      return (rank[1] == 10 && rank[2] == 11 && rank[3] == 12);
    }
    for (int i = 0; i < 4; ++i) {
      if (rank[i+1] != rank[i] + 1) {
        return false;
      }
    }
    return true;
  }

  private boolean isFullHouse(Card[] cards) {
    int[] rank = getSortedRank(cards);

    // 2-3 or 3-2
    // First and last two must be the same
    if (rank[0] == rank[1] && rank[3] == rank[4]) {
      return (rank[2] == rank[1] || rank[2] == rank[3]);
    }
    return false;
  }

  private boolean isRoyalFlush(Card[] cards) {
    String suit = cards[0].suit();
    for (int i = 0; i < 5; ++i) {
      if (cards[i].suit() != suit) return false;
    }
    return isFlush(cards);
  }
}

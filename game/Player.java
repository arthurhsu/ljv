package game;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Player {
  private String _name;
  private Deck _deck;
  private HashMap<String, String> _SYMBOLS;

  public Player(String name) {
    _name = name;
    _SYMBOLS = new HashMap<>();
    _SYMBOLS.put("S", "♠");
    _SYMBOLS.put("H", "♥");
    _SYMBOLS.put("D", "♦");
    _SYMBOLS.put("C", "♣");
  }

  public void receive(Deck deck) {
    _deck = deck;
  }

  private String toDisplayString(Card[] cards) {
    String[] s = new String[]{"", "", "", "", ""};
    for (int i = 0; i < cards.length; ++i) {
      s[0] += "┌───┐";
      String rank = String.format("%2s", cards[i].getRankString());
      s[1] += "│" + rank + " │";
      s[2] += "│ " + _SYMBOLS.get(cards[i].suit()) + " │";
      s[3] += "└───┘";
      s[4] += String.format("%3s", i + 1) + "  ";
    }
    return String.join("\n", s);
  }

  private int[] getUserInput() {
    System.out.println(_name);
    System.out.println(toDisplayString(_deck.getCards()));
    System.out.print("? ");
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    StringTokenizer tokenizer = new StringTokenizer(input.trim());
    int[] indices = new int[tokenizer.countTokens()];
    int i = 0;
    while (tokenizer.hasMoreTokens()) {
      indices[i++] = Integer.parseInt(tokenizer.nextToken()) - 1;
    }
    return indices;
  }

  public Hand play(Hand hand) {
    boolean validInput = false;
    Hand myHand = Hand.pass();
    do {
      try {
        int[] indices = getUserInput();
        boolean mustPlay3C = hand.isPass() && _deck.hasGhost();
        
        // Check if user said pass
        if (indices.length == 1 && indices[0] == -1) {
          if (mustPlay3C) {
            throw new IllegalArgumentException("Must play 3C");
          }
          break;
        }

        Card[] cards = _deck.getCards(indices);
        myHand = new Hand(cards);
        if (!myHand.canWin(hand)) {
          throw new IllegalArgumentException("Must play bigger hand");
        }
        if (mustPlay3C && !myHand.hasGhost()) {
          throw new IllegalArgumentException("Must play 3C");
        }
        validInput = true;
        _deck.removeCards(indices);
      } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
      }
    } while(!validInput);

    Card[] cards = myHand.isPass() ? hand.getCards() : myHand.getCards();
    System.out.println(toDisplayString(cards));

    return myHand;
  }

  public boolean won() {
    return _deck.length() == 0;
  }

  public Deck showDeck() {
    return _deck;
  }

  public boolean canStart() {
    return _deck.hasGhost();
  }
}

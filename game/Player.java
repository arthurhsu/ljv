package game;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Player {
  private String _name;
  private Deck _deck;

  public Player(String name) {
    _name = name;
  }

  public void receive(Deck deck) {
    _deck = deck;
  }

  private int[] getUserInput() {
    System.out.println(_name);
    System.out.println(_deck.toString());
    System.out.print("? ");
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    StringTokenizer tokenizer = new StringTokenizer(input.trim());
    int[] indices = new int[tokenizer.countTokens()];
    int i = 0;
    while (tokenizer.hasMoreTokens()) {
      indices[i++] = Integer.parseInt(tokenizer.nextToken());
    }
    return indices;
  }

  public Hand play(Hand hand) {
    boolean cannotPass = hand.isPass() && _deck.hasGhost();
    boolean validInput = false;
    Hand myHand = Hand.pass();
    do {
      int[] indices = getUserInput();
      Card[] cards = _deck.getCards(indices);
      try {
        myHand = new Hand(cards);
        if (cannotPass) {
          if (myHand.isPass() || !myHand.hasGhost()) {
            throw new IllegalArgumentException("Must play 3C");
          }
        } else if (!myHand.canWin(hand)) {
          throw new IllegalArgumentException("Must play bigger hand");
        }
        validInput = true;
        _deck.removeCards(indices);

        return myHand;
      } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
      }
    } while(!validInput);
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

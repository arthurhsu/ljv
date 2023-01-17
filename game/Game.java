package game;

public class Game {
  public static void main(String[] args) {
    Dealer dealer = new Dealer();
    Player[] players = new Player[4];
    for (int i = 0; i < 4; ++i) {
      players[i] = new Player("Player " + i);
    }
    dealer.deal(players);
  
    // Main game loop
    boolean endGame = false;
    boolean started = false;
    Hand hand = Hand.pass();
    boolean cannotPass = true;
    int lastWinner = -1;
    while (!endGame) {
      for (int i = 0; i < 4; ++i) {
        if (!started && !players[i].canStart()) continue;
        if (lastWinner == i) {
          hand = Hand.pass();
          cannotPass = true;
        }
        if (!started) {
          lastWinner = i;
          started = true;
          cannotPass = true;
        }
        Hand newHand = players[i].play(hand, cannotPass);
        if (!newHand.isPass()) {
          hand = newHand;
          lastWinner = i;
          cannotPass = false;
        }
        if (players[i].won()) {
          endGame = true;
          System.out.println("Player " + i + " won!");
          break;
        } else {
          System.out.println("Player " + lastWinner + " has upper hand");
        }
      }
    }
  }
}

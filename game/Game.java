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
    while (!endGame) {
      for (int i = 0; i < 4; ++i) {
        if (!started && !players[i].canStart()) continue;
        started = true;
        players[i].play(hand);
        if (players[i].won()) {
          endGame = true;
          System.out.println("Player " + i + " won!");
          break;
        }
      }
    }
  }
}

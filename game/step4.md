# User Interface

## Improve output

Even if this is currently a console-based game, there are still user interface
principles to follow. First is to make the display more intuitive by changing

```
Player 0
  0) 3S  1) 4H  2) 6H  3) 8H  4) 10H  5) QH  6) 4D  7) 6D  8) KD  9) AC  10) 3C  11) 4C  12) 9C
? 
```

to

```
Player 0
┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐┌───┐
│ 3 ││ 4 ││ 6 ││ 8 ││10 ││ Q ││ 4 ││ 6 ││ K ││ A ││ 3 ││ 4 ││ 9 │
│ ♠ ││ ♥ ││ ♥ ││ ♥ ││ ♥ ││ ♥ ││ ♦ ││ ♦ ││ ♦ ││ ♣ ││ ♣ ││ ♣ ││ ♣ │
└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘└───┘
  1    2    3    4    5    6    7    8    9   10   11   12   13
```

Yes this is a very old-school ASCII art. There are card related charaters given
card games are of the very first computer programs used by a lot of people.

> THINK POINT: Currently the output is done in `Player.java`. Where should we
put the new logic? and why?

One other change is that we have the card index to start from 1 instead of 0.
Why? Because there is currently no way to signal pass, and we want to use 0
as pass. Remember, when the display of index changes, the input processing also
needs to change.

## Fix existing bugs

The first player is not allowed to pass if 3C is on their hand. After that,
every player can freely pass even if they have hands to play. 

Also current logic does not really check if the first hand have 3C. Why?

When user said pass, we still want to display the previous hand, how to do it?

There's one additional bug in `Hand.java`, have you found it? Also the
`Game.java` did not properly recording and passing hands.

> EXERCISE: How to test these bugs and make sure they do not happen again?

In the next session, we'll start finishing the TODO so that game play will not
keep complaining "Must play bigger hand".

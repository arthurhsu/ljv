# Game Big2 (1)

The game Big2 is a popular card game in Taiwan. There are 4 players in a game,
each is dealt with 13 cards. The card 3C is the "ghost", the smallest in the
game. Player with card 3C will start the initial combination that has the card
3C. The first player exhausts their cards wins.

The following are valid combinations:

* Single: 1 card
* Pair: 2 cards of the same rank
* Flush: 5 cards whose rank are in order, but not in the same suit
* Full House: 5 cards consisting one Triple and one Pair
* Royal Flush: Flush in the same suit
* Four of a kind: 4 cards with the same rank, plus 1 random card

When a player starts with a combination (e.g. Flush), everyone in that round
must present a combination that is greater than the existing one. The general
rule of ranking is:

* 2 is the biggest rank, then A K Q J 10 9 8 7 6 5 4 3. Rank is used to
  determine the order of Single and Pair
* If the rank is the same, use suit to determine Spade > Heart > Diamond > Club.
* A Flush is valued at its biggest rank, e.g. 2 3 4 5 6 is bigger than
  A K Q J 10
* A Full House is valued at its triples, e.g. Q Q Q 3 3 is greater than
  4 4 4 K K.
* Royal Flush can trimph any Flush
* Four of a kind can trimph any combination (ignoring the combination rule)

With that in mind, we can start coding the game.

## First step
Copy over `Card.java`, `Dealer.java`, and `Desk.java`. Change the package names.
Create `Game.java` and move `main()` function from `Dealer.java` to it.

We then create `Combo.java` to hold the definition and detections of valid
combinations.

## `enum`
An `enum` is a special `class` that represents a group of constants
(unchangeable variables, like `final` variables). We use enums instead of fixed
numbers to increase code readability.

## `switch` fall through
In our `getNumberOfCards()` method, a technique called "switch fall-through" is
used:

```java
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
```

Each `case` in a `switch` must be **terminated**, or it will just fall through
to the next `case`. The termination can be either `break`, `return`, or
`continue` (if and only if used inside a loop wrapping the `switch`).

## Standard Libraries
A standard library provides some reusable functionalities that you don't need to
write yourself again. For example, to sort an array, one just need to call
`Arrays.sort()` provided by `java.util.Arrays`.

Java is famous for its rich standard libraries. It is giagantic that one must
be acquainted to how to find the functions via Googling in order to master the
Java programming language.

In `Game.java`, we also use `java.util.Scanner` to read user input from the
console, and `java.util.StringTokenizer` for string tokenization.

## Overloading
First we need to enrich the `Deck` class to offer additional functionalities:
* `hasGhost()`
* `getCards()`

There are two `getCards()` in the new version of `Deck`. They *return the same
type, but take different parameters*. This is called **overloading** in OOP
terms.

> **IMPORTANT**: The return type MUST be the same. Otherwise it will be a syntax
  error.

The two versions of `getCards()` serves different purpose: one is to show all
cards, and the other is to get cards that the player picks.

## String tokenization
String tokenization is a very common technique/process to split strings. For
example, when a user inputs

```
1 2 3 4 5
```

We will read it as one string `1 2 3 4 5`, but our intention is to fill them
into a 5-element integer array. Therefore we use the tokenizer to split them
into 5 different strings, then parse them into integer arrays.

## for-each loop and string comparison
Take a look at `Deck.hasGhost`:

```java
public boolean hasGhost() {
  for (Card c : _cards) {
      if (c.toString().equals("3C")) return true;
  }
  return false;
}
```

The `for (Card c: _cards)` is called for-each loop, which means "for every `c`
in `_cards`". It's basically a shorthand of

```java
for (int i = 0; i < _cards.length; ++i) {
  Card c = _cards[i];
  ...
}
```

Only iteratable collections can use the for-each loop. We'll talk more about the
concept of collections and iterators in the future.

The other interesting part is how a `String` comparison is done:

```java
if (c.toString().equals("3C")) return true;
```

Can we just do this?
```java
if (c.toString() == "3C") return true;
```

The answer is **NO** and this is a very common trap. In Java, strings are
reference types (remember the primitive vs reference?). The `==` operator will
just compare the references (aka memory addresses) of any reference type.
Given they are stored in different memory spot, the evaluation will always fail.
As a result, in Java we use the `equals()` method to compare the actual contents
inside a reference typed object.

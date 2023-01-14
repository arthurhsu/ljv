# Refactoring and class design

In previous code, there are some "bad smells" in the class design.

```java
public class Game {
  public static void main(String[] args) {
    Dealer dealer = new Dealer();
    Deck[] decks = dealer.deal();
  
    // Find who has ghost
    int currentPlayer = -1;
    for (int i = 0; i < decks.length; ++i) {
      if (decks[i].hasGhost()) {
        currentPlayer = i;
        break;
      }
    }
...
```

First, the concept player is now embedded inside the `main()` method, and also
`decks` index implies player. That's a good trait of player should be its own
class given we try to impose the concept `Player` for both a method and another
class.

Therefore we isolated `Player` into its own class, also have the input related
code moved into it. For a `Player` to play a hand, we need to have a `Hand`
class to represent the hand being played.

Another refactoring done is to change the data structure inside `Deck` class.
The `_cards` array can shrink once a `Hand` is played. Therefore, `ArrayList`
is a much better data structure to use than array.

Also, the original `hasGhost` implementation is not ideal. The `Card` should
just be able to tell anyone "am I a ghost", because the information is solely
determined by member data inside `Card` object. Therefore it makes very
little sense that `hasGhost` is not determined inside the `Card` class.

## Exceptions and testing exceptions

In the `Hand` class, we demonstrated how to throw exceptions inside constructor,
also demonstrated how to test exceptions are properly thrown in JUnit4.

> NOTE: JUnit5 has different way of testing exceptions by introducing
`assertThrows`, check JUnit documentation that corresponds to your environment.

> EXERCISE 1: compare the `main` method before and after. What are the
differences? List the pros and cons you have observed.

> EXERCISE 2: How would you better test the new `Hand` and `Player` class?

## The tricky System.in

In the new code we have removed one line:

```java
in.close();
```

This is because now every `Player` object have a `Scanner` to read, and closing
it actually caused subsequent `NoSuchElementExceptions` when the `Scanner` in
next `Player` object try to read. I don't know about this until reading the
[Stack Overflow article](https://stackoverflow.com/questions/10604125/how-can-i-clear-the-scanner-buffer-in-java).

It's quite normal. No one will memorize every single detail, and it's important
to learn how to find answers.

## Remaining issues

We still don't have an implementation to determine can a hand win over the
other. Also the input of gameplay is very miserable. That's going to be fixed
in the next steps.

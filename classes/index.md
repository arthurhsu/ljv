# Class (1)

Let's start with a real world sample. Say, we want to write a card game that
the computer will deal poker cards to 4 players in the game. How can we do that?

First is how to represent the 52 cards. We can assign each card a number:

* Spades A to K: 0 to 12
* Hearts A to K: 13 to 25
* Diamonds A to K: 26 to 38
* Clubs A to K: 39 to 51

With that we can deal cards to player. There are two ways of doing it

* Shuffle the 52 cards, then divide them into 4 piles
* For every card, assign them player 0 to 3, and make sure each player has less
  than 13 cards

The second way is easier so we'll use that as an example. The first version can
be found in `Deck0.java`.

Let's take a look at `Deck0.java`. It actually mixed different parts of the
logic inside one file:

* How to deal cards (separate cards into decks)
* How to display cards

First we want to separate the card display logic from the code. In this case,
we will create a card class like the one in `Card.java`. After creating it,
we can change logic in Deck to things like `Deck1.java`.

With the new code, we found that there are still two logic inside a file:

* How to deal cards (separate cards into decks)
* How to display decks

Therefore we can further break down `Deck1.java` into `Deck.java` and
`Dealer.java`. The former will be focused on deck display logic, and the latter
will be focused on card dealing.

In this new code, we gather all deck related logic into `Deck.java` so that
Dealer no longer needs to use `count[]` to keep count on deck length.

> **TRY IT**: Change the dealer logic to shuffle the 52 cards first, and then
  deal to 4 players like actually playing card. Try to modify both `Deck0.java`
  and `Dealer.java`. What differences have you observed?

## More about `class`

A class defines structures and behaviors of an **object**. The structure part
is what data is carried within an object (also known as **members**), and the
behavior parts are **methods** that an object can perform. This is the
fundamental part of Object-Oriented programming (OOP): we focus on defining
objects and how objects interacts with one another.

To create an object (called **instantiate** in OOP terms), we need to use the
`new` operator. For example:

```java
Dealer dealer = new Dealer();
```

This creates an `Dealer` object that can perform stuff.

### Class accessor scope

An object can carry member or method itself. There are three different
visibilities:
* `public`: can be seen from outside of the object class
* `private`: cannot be seen from outside of the object class, nor the decendents
  of the object class
* `protected`: cannot be seen from outside of the object, but can be seen by
  the decendents of the object class

Decendents are part of the inheritance concept and will be talked later. Right
now we just use `public` and `private` in our code.

> **ADVANCED TIP**: these are called **class scope** in Java, and they operate
  on `class` only. Therefore, two objects of the same class can see each other's
  private members without any problem.

The visibility applies to both member and methods. Usually methods are `public`
or `protected`, and members are `private`. This is called **encapsulation**.
The goal is to make sure object's internal data is not changeable outside its
class.

### Constructors

When `new` is called to instantiate an object, the contructor method will be
automatically invoked. A constructor method MUST have the same name as the class
itself, and it MUST NOT have a return type.

# Loop (2) - `while` and `do while`

In our code we introduced the `while` loop in the card dealing logic:

```java
for (int i = 0; i < 52; ++i) {
  int owner = -1;
  while (owner < 0) {
    owner = rnd.nextInt(players);
    if (count[owner] >= 13) {
      owner = -1;
    }
  }
  count[owner]++;
  cards[i] = owner;
}
```

`while` loop is a specialized loop that have only stop conditions. Therefore
the code above is equivalent to

```java
for (int i = 0; i < 52; ++i) {
  for (int owner = -1; owner < 0;) {
    owner = rnd.nextInt(players);
    if (count[owner] >= 13) {
      owner = -1;
    }
  }
  count[owner]++;
  cards[i] = owner;
}
```

This version is way more cryptic to read (though totally legit). Therefore you
can treat `while` loop as more about readability.

There's a variation of `while`, that's `do {...} while(<stop condition>)`. Our
case can be rewrite into the following form:

```java
for (int i = 0; i < 52; ++i) {
  int owner;
  do {
    owner = rnd.nextInt(players);
    if (count[owner] >= 13) {
      owner = -1;
    }
  } while (owner < 0);
  count[owner]++;
  cards[i] = owner;
}
```

`do-while` is useful when your execution block (the `do {...}` part) needs to
run at least once no matter what.
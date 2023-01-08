# Testing

The most commonly used Java testing library is the JUnit, which is generally
used for **unit testing**. Unit testing is to test whether the designed methods
operate as expected.

If the VisualStudio Code Java extension is installed, by default it supports
JUnit integration.

## Adding a simple test

We start from adding `DeckTest` to test the `Deck` class. Let's say we want to
test the `hasGhost()` method works as expected. We start with the test class:

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
  @Test
  public void testHaveGhost() {
    // test code inside
  }
}
```

First there are two imports: `org.junit.Test` and a `static` import
`org.junit.Assert.*`. The latter one instructs Java to import all static methods
from the `org.junit.Assert` class so that we can just type `assertTrue` in later
code instead of typing `Assert.assertTrue`.

The `@Test` is an **annotation** in Java. In this case, it annotates the method
so that it's clear that this function is meant for unit testing. JUnit will
automatically pick it up and run as a test. Take a look at `ComboTest`, the
utility function `generate()` is not annotated as `@Test` so that both the tool
and the people know that is not a test.

Conventionally, we prefix all test methods with `test` and postfix all test
classes with `Test`.

## Test authoring and debugging

To simplify our test code, we override the ctor of `Card` class so that
it takes a human readable string to instantiate a `Card` object. (In Java
or C++, constructor is usually abbreviated as ctor). To do that,
two string literal arrays are abstracted out into a private default ctor.
A default ctor will take no params. Because we don't want a card to be
created without rank and suit, we mark the default ctor as `private` and
force all external callers to use the parameterized version of ctor.
That is one of the very few legit case to use private ctor.

We then add `ComboTest`. The helper method has an interesting signature:

```java
private Card[] generate(String... cards) {...}
```

The `String...` is telling Java that we are going to have one or more parameters
for this method, and treat them all as strings. The cards will effectively be
treated as `String[]`. This kind of parameter is called **varargs**, meaning
variable length arguments. Varargs are generally not recommended in production
code (tests are usually okay).

The other trick used here is how ctor can call each other:

```java
public Card(String card) {
  this();

  // FIXIT: Not really ideal, but settled for now. Inputs are evil.
  String suit = card.toUpperCase().substring(
      card.length() - 1, card.length());
  String rank = card.toUpperCase().substring(0, card.length() - 1);
  _suit = Arrays.asList(_SUITS).indexOf(suit);
  _rank = Arrays.asList(_RANKS).indexOf(rank);
}
```

In the code you can see there is a `this()` call, which is to invoke the
default ctor. This is a common technique in Java object construction.
Also the comment says `FIXME`, another common tag that we add in the code to
remind ourselves to revisit later when we have time. If there were user given
strings, it's usually not good to parse it in the ctor. Imagine you are creating
an array of objects, and one of the object's constructor throws an exception,
that could be very annoying. There are design patterns to overcome these type
of things, and it's worth reading once you are fluent at least one programming
language.

The test actually found a bug in previous version of code and therefore we need
to fix the bug in combo detection.

## Extreme programming (XP)

Writing tests along side writing classes is an approach called "extreme
programming" and is highly recommended. This will help guarantee your code work
as expected and be more maintainable.

> EXERCISE: write a test for `Dealer`

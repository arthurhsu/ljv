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

To simplify our test code, we override the constructor of `Card` class so that
it takes a human readable string to instantiate a `Card` object. To do that,
two string literal arrays are abstracted out into a private default constructor.
A default constructor will take no params. Because we don't want a card to be
created without rank and suit, we mark the default constructor as `private` and
force all external callers to use the parameterized version of constructors.
That is one of the very few legit case to use private constructors.

We then add `ComboTest`. The helper method has an interesting signature:

```java
private Card[] generate(String... cards) {...}
```

The `String...` is telling Java that we are going to have one or more parameters
for this method, and treat them all as strings. The cards will effectively be
treated as `String[]`. This kind of parameter is called **varargs**, meaning
variable length arguments. Varargs are generally not recommended in production
code (tests are usually okay).

The test actually found a bug in previous version of code and therefore we need
to fix the bug in combo detection.

## Extreme programming (XP)

Writing tests along side writing classes is an approach called "extreme
programming" and is highly recommended. This will help guarantee your code work
as expected and be more maintainable.
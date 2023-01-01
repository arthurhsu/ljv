# Basic flow control

Let's evolve the greeting program a little bit. Say we want our program to greet
the world if no specific person is given, or greet the person if given.

```bash
$ env java -cp <class path> hello.Hello
Hello, world!
$ env java -cp <class path> hello.Hello Sophia
Hello, Sophia!
```

We can then leverage the **arguments** passed in our `main` function, see
`Hello2.java`:

```java
public static void main(String[] args) {
  String toWho = "world";
  if (args.length > 0) {
    toWho = args[0];
  }
  System.out.printf("Hello, %s!\n", toWho);
}
```

`toWho` is a **variable**, variable in Java *MUST* be declared before use with
a **data type**. The data types supported by Java can be found in [Oracle
documents](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html).

There are two kinds of data types: **primitive** and **reference**. Primitive
data types means that the data hold in varaibles use **stack**, while the
reference data types means the data hold in varaibles use **heap**.

> **TIP**: All arrays are reference types, e.g. `int[]` is a reference type, but
`int` is primitive

**stack** and **heap** are more about memory management, which you'll learn in
a much later time. Let's just know about it for now.

## Conditional, expressions, operators

Java offers two conditionals: `if` and `switch`. `if` is the most used
conditional, and its syntax is:

```java
if (<boolean expression>) {
  statement;
  statement;
  ...
}
```

An **expression** is what you want the computer to evaluate. For example,
`3 + 4` is an expression that will evaluate to `7`, and `args.length > 0` is
an expression that will evaluate to either `true` or `false`. Expression has
type too: all expressions MUST evaluate to a primitive type.

There is a short-hand of writing the following:

```java
String toWho = "world";
if (args.length > 0) {
  toWho = args[0];
}
```
to
```java
String toWho = (args.length > 0) ? args[0] : "world";
```

The C-family has very rich **operators** to help shorten the code. For example:

```java
int a = 3;
a = a + 1;  // increment by one
a++;  // ditto
++a;  // ditto
a = a - 1;  // decrement by one
a--;
--a;
a = a + 3;  // add a number
a += 3;  // ditto
a = a - 2;
a -= 2;
a = a * 8;
a *= 8
a = a / 8;
a /= 8;
a = a % 2;  // modulo by 2
a %= 2;
```

Operators also have **precendences**, for example:

```java
int a = 3;
int b = 2;
int c = a + 5 * b + a / b;
```
According to arithmetic laws, `5 * b` will be evaluated first, then `a / b`,
then the plus operation.

There are interesting things happening with `++` and `--`.

`++a` means increment `a` first, then use value `a`;
`a++` means use value `a` first, then increment `a`;

> **TRY IT**: try the following code yourself:
```java
public static void main(String[] args) {
  int a = 2;
  System.out.println(a++);
  System.out.println(a);
  System.out.println(++a);
  System.out.println(a);
}
```

# `switch`

`switch` is also a shorthand to comprehend multiple `if-elseif` comparing the
same variable. For example:

```java
if (a == 1) {
  s = "uno";
} else if (a == 2) {
  s = "dos";
} else if (a == 3) {
  s = "tres";
} else {
  s = "mucho";
}
```

This can be written in `switch`:

```java
switch (a) {
  case 1:
    s = "uno";
    break;  // You must have break here, otherwise it will flow through
  case 2:
    s = "dos";
    break;
  case 3:
    s = "tres";
    break;
  default:
    s = "mucho";
    break;  // whether you have break here or not does not matter.
            // we usually add one to be consistent with other cases.
}
```

It's not necessarily shorter nor more readable. In this case, using array will
be a much better choice:

```java
final String[] literals = new String[] {"uno", "dos", "tres", "mucho"};
int index = (a >= 1 && a <= 3) ? a - 1 : 3;
s = literals[index];
```

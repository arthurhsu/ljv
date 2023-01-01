# Loops (1)

Loops are one of the most important tools in programming languages, because
computers are initially designed to carry out repetitive works for humans. In
Java, several loop types are being provided, and we will cover mostly the `for`
loop and the `while` loop given they are the most used loops.

## `for` loops - counter

There are two different `for` loops offered in Java, and let's start with the
counter one:

```java
int[] a = new Array[10];
for (int i = 0; i < 10; ++i) {
  a[i] = i;
}
```

The example creates an array filling its number from 0 to 9. The `for` loop here
has three main parts:

* **initial condition**: `int i = 0` sets up a counter variable `i` with initial
  value `0`
* **stop condition**: `i < 10` is the stop condition, means when will the loop
  stop
* **step statement**: `++i` is the step statement, means when the block inside
  the loop finished, what should be done. In this case, we increment the
  variable `i` by one so that it can be the next index.

All three are *statements*, therefore the `for` loop can sometimes be in some
interesting form:

```java
for (;;) {
  // An infinite loop that will never stop
}
```

## Coding exercise

### Multiplication table (1)
Write a program to generate the following output:

```
2 * 1 =  2   3 * 1 =  3   4 * 1 =  4   5 * 1 =  5
2 * 2 =  4   3 * 2 =  6   4 * 2 =  8   5 * 2 = 10
2 * 3 =  6   3 * 3 =  9   4 * 3 = 12   5 * 3 = 15
2 * 4 =  8   3 * 4 = 12   4 * 4 = 16   5 * 4 = 20
2 * 5 = 10   3 * 5 = 15   4 * 5 = 20   5 * 5 = 25
2 * 6 = 12   3 * 6 = 18   4 * 6 = 24   5 * 6 = 30
2 * 7 = 14   3 * 7 = 21   4 * 7 = 28   5 * 7 = 35
2 * 8 = 16   3 * 8 = 24   4 * 8 = 32   5 * 8 = 40
2 * 9 = 18   3 * 9 = 27   4 * 9 = 36   5 * 9 = 45

6 * 1 =  6   7 * 1 =  7   8 * 1 =  8   9 * 1 =  9
6 * 2 = 12   7 * 2 = 14   8 * 2 = 16   9 * 2 = 18
6 * 3 = 18   7 * 3 = 21   8 * 3 = 24   9 * 3 = 27
6 * 4 = 24   7 * 4 = 28   8 * 4 = 32   9 * 4 = 36
6 * 5 = 30   7 * 5 = 35   8 * 5 = 40   9 * 5 = 45
6 * 6 = 36   7 * 6 = 42   8 * 6 = 48   9 * 6 = 54
6 * 7 = 42   7 * 7 = 49   8 * 7 = 56   9 * 7 = 63
6 * 8 = 48   7 * 8 = 56   8 * 8 = 64   9 * 8 = 72
6 * 9 = 54   7 * 9 = 63   8 * 9 = 72   9 * 9 = 81
```
Reference answer: `Multi1.java`

### Multiplication table (2)

Write a program to generate the following output:

```
   |   1   2   3   4   5   6   7   8   9  10  11  12
----------------------------------------------------
 1 |   1   2   3   4   5   6   7   8   9  10  11  12
 2 |   2   4   6   8  10  12  14  16  18  20  22  24
 3 |   3   6   9  12  15  18  21  24  27  30  33  36
 4 |   4   8  12  16  20  24  28  32  36  40  44  48
 5 |   5  10  15  20  25  30  35  40  45  50  55  60
 6 |   6  12  18  24  30  36  42  48  54  60  66  72
 7 |   7  14  21  28  35  42  49  56  63  70  77  84
 8 |   8  16  24  32  40  48  56  64  72  80  88  96
 9 |   9  18  27  36  45  54  63  72  81  90  99 108
10 |  10  20  30  40  50  60  70  80  90 100 110 120
11 |  11  22  33  44  55  66  77  88  99 110 121 132
12 |  12  24  36  48  60  72  84  96 108 120 132 144
```

Reference answer: `Multi2.java`

### Fibonacci series

Give an arbitrary number N, N < 40, find the corresponding term in Fibonacci
series.

Reference answer: `Fibonacci.java`

### Diamond

Given an arbitrary odd number N, 3 <= N <= 15, draw a diamond shape with height
equals to N. For example:

```
Please input an odd number between 3 and 15: 7
   *
  ***
 *****
*******
 *****
  ***
   *
```

Reference answer: `Diamond.java`

### Pascal triangle

Given an arbitrary number N, N <= 20. Generate Pascal triangle to the Nth term.
For example:

```
Please input a number between 1 and 20: 8
                   1
                 1   1
               1   2   1
             1   3   3   1
           1   4   6   4   1
         1   5  10  10   5   1
       1   6  15  20  15   6   1
     1   7  21  35  35  21   7   1
   1   8  28  56  70  56  28   8   1
```

Reference answer: `Pascal.java`
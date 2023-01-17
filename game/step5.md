# Developing algorithm (1)

## Determine whether a hand can win or not

To determine whether a hand can win or not, the common way of thinking is to
quantify hands, i.e. give each hand a score. The hand with higher score wins.

For singles, we already have rule:

* 2 > A > K > Q > J > 10 > ... > 4 > 3
* S > H > D > C

If we weight rank by 10 and suit by 1:

|Rank|2|A|K|Q|J|numbers|
|----|-|-|-|-|-|-------|
|Score|150|140|130|120|110|numbers * 10|

|Suit|S|H|D|C|
|----|-|-|-|-|
|Score|4|3|2|1|

Then each single's value can be calculated and compared, e.g. 2S (154) is higher
than AD (142).

* For pairs, we can reuse the comparison.
* For fullhouses, we can reuse the comparison on triples.
* For flushs, we can value it by the largest card in the suit.

Royal flush cannot use simple flush rule because any royal flush will beat a
non-royal one. Therefore we need to add additional weight to it. One way is to
use `10 * highest weight` as royal flush's value.

- 3/4/5/6/7C (710) will still be higher than 2S/3C/4S/5D/6H (154)
- 3/4/5/6/7C (710) will be smaller than 2/3/4/5/6C (1510)
- 3/4/5/6/7C (710) will be smaller than 3/4/5/6/7D (720)
- 3/4/5/6/7D (710) will be smaller than 2/3/4/5/6C (1510)

Four-of-a-kind will triumph everything, therefore it needs a higher weight. One
way is to add `10000` to the highest of the 4.

- 2/2/2/2/* will be the biggest set in the game (10154)
- 3/3/3/3/* will still be big enough than anyone (10034)

> EXERCISE: Now it's time to turn these into code. Try to do it yourself before
reading the examples.

What we want to show you here is how software design usually works: for
something that's not immediately obvious, we spent some time to think through
and see if we can derive a math model to solve it. Then we code and add tests
to validate our model and implementation.

Next problems in the game play:
* How can we quickly identify available hands to play?
* We did not handle when everyone passes on a hand, the hand winner can keep
  playing.

# Hello World! - How a Java program runs

```java
package hello;

public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }
}
```

## Entry point

All code starts from this method

```java
public static void main(String[] args) {...}
```

This is called the **entry point** of a program. No matter how many lines before or after this function, it is where the program will start running. This is a tradition of the C-family languages (except JavaScript).

## How a program runs

If you looked at the `TERMINAL` tab in Visual Studio Code when you click the `Run` link in `Hello.java`, you can see something like this:

```bash
arthurhsu@arthurhsu-macbookpro:~/src/ljv$  cd /Users/arthurhsu/src/ljv ; /usr/bin/env /opt/homebrew/Cellar/openjdk/18.0.2/libexec/openjdk.jdk/Contents/Home/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /Users/arthurhsu/Library/Application\ Support/Code/User/workspaceStorage/b57ab09c9ab4a7f1d36ac44a6d1e450b/redhat.java/jdt_ws/ljv_7469dd50/bin hello.Hello 
Hello, world!
```

This whole long yada-yadas can be viewed as:

```bash
env java -cp <class path> hello.Hello
```

* `env` means use a sandbox to run this program, it's a UNIX command.
  `man env` for more details.
* All Java programs are run using Java runtime environment (JRE), and the
  command line to invoke JRE is `java`.
* The long yada-yadas are to specify the full path of these programs.

So if you take a look at the class path (`/Users/arthurhsu/Library/Application\ Support/Code/User/workspaceStorage/b57ab09c9ab4a7f1d36ac44a6d1e450b/redhat.java/jdt_ws/ljv_7469dd50/bin`
in this example), you can find a directory `hello`, and inside `hello` there is a `Hello.class`. This ia called a
**class file**. The class file is generated from the `Hello.java` by Java compiler.

Java is a compiled language: all source code (`.java` files) must be compiled into runtime file (`.class` files) so
that they can be run.

## Language elements

### `class` and `package`

If your project is stored in a sub-directory (say `ljv/hello`) in this example, you must indicate `package hello`
because Java thinks each sub-directory is a package by default (unless you told it not to do so).

> **TRY IT**: see what happens if you removed the first line `package hello;`

All Java code are wrapped in `class`. Each class must stay in one file with the same name. For example, we have
`class Hello` here, then the file **MUST** be named `Hello.java`.

> **TRY IT**: see what happens if you rename the file into `hello.java` (swap the first letter to lower case).

`public` and `static` are **decorators**. We'll skip it for now, just memorize the `main` function will always have
either of these signatures:

```java
public static void main(String[] args) {...}
```
```java
public static int main(String[] args) {...}
```

`main` is a **method** (in Java terms, or **function** in C-family terms). A function comes with a return type before
it (`void` in our example, means returning nothing), and a **block** wrapped by a pair of brackets (`{}`).

A block is the fundamental unit of **scope**, scope means where a variable/function can be seen or not.

> **MEMORY POINT**: remember the variable scope practice demonstrated in class?

Within the block, there are **statements**, each end with a semicolon `;`. In our example, there's only one statement:

```java
System.out.println("Hello, world!");
```

This prints "Hello, world!" on screen. It calls a method, `System.out.println`, which prints a line on screen.
We pass in `"Hello, world!"` here, which is called a **string literal**.

Memorizing these terminologies are important because the Java compiler will show errors in these terminologies. If you
did not memorize them and need to Google every time, it will be very slow.
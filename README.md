# dp-Builder

Design Patterns #2 - Builder

This is the second pattern exercise from a series of academic projects were I'm implementing different code quality concepts in small projects. 
Check the previous project ([Singleton](https://github.com/euaaron/dp-singleton)).

The Builder pattern is a creational pattern that aims to improve the creation of objects by adding an organized way to validate fields during the creation.
The idea is to when creating an object, instead of use the class constructor, to use a different method to add values to each property but still having not only the consistency that constructors provide.

## Examples

Let's imagine a class Music with `id`, `name`, `band`, `album`, `year`, `duration`, `genre`, where except the id, everything else must be informed manually when creating the object:

```java
// Example using Java without builder pattern

Music calm = new Music("Fade Into You", "Mazzy Star", "So Tonight That I Might See", "1993", "04:55", "Alternative");

```

As you can see, all values are `String`s, so how could we know if we wrote the right value in the right place if the constructor don't have a JavaDoc comment?
That's why builder get handy. Let's see how it would be using builder.

```java
// Example using Java with builder pattern

Music calm = new MusicBuilder().setName("Stuck In A Moment You Can't Get Out Of")
                               .setBand("U2")
                               .setAlbum("All That You Can't Leave Behind")
                               .setYear("2000")
                               .setDuration("04:31")
                               .setGenre("Alternative")
                               .build();
```

In the previous example the `build()` method returns a `Music object` with all previous values or throw an error if there are missing or invalid fields.
This way, even without a Javadoc notation, we can know what values we need to add to the object and add them to the right place, removing chance of making mistakes.

To undertand more about this pattern take a look at this project, where I implement this pattern with a simple Profile class and use JUnit to test.

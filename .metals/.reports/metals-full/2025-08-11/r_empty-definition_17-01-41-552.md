error id: file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/util/Util.scala:`<none>`.
file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/util/Util.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -it/unibo/bluff/model.
	 -scala/Predef.it.unibo.bluff.model.
offset: 57
uri: file:///C:/Users/goalp/OneDrive%20-%20Alma%20Mater%20Studiorum%20Università%20di%20Bologna/Desktop/UNI/ScalaBluff/ScalaBluff/src/main/scala/it/unibo/bluff/model/util/Util.scala
text:
```scala
package it.unibo.bluff.util

import it.unibo.bluff.mode@@l.{Card, Rank, Suit}

trait RNG:
  def nextInt(bound: Int): Int
  def shuffle[A](xs: List[A]): List[A] =
    val buf = scala.collection.mutable.ArrayBuffer.from(xs)
    val out = scala.collection.mutable.ArrayBuffer[A]()
    while buf.nonEmpty do
      val i = nextInt(buf.size)
      out += buf.remove(i)
    out.toList

object RNG:
  def default(seed: Long = System.currentTimeMillis()): RNG = new RNG:
    private var s = new scala.util.Random(seed)
    def nextInt(bound: Int): Int = s.nextInt(bound)

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.